package com.georgcantor.aac.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.georgcantor.aac.BuildConfig
import com.georgcantor.aac.data.local.dao.FakePostDao
import com.georgcantor.aac.data.local.database.FakeDatabase
import com.georgcantor.aac.data.remote.FakeApiService
import com.georgcantor.aac.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Alex on 06.03.2018.
 *
 * this class has all the dependencies that we need through the lifecycle of our app
 */
@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.apply {
            if (BuildConfig.DEBUG) {
                addNetworkInterceptor(StethoInterceptor())
                addInterceptor(httpLoggingInterceptor)
            }
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): FakeApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        return retrofit.create(FakeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFakeDatabase(application: Application): FakeDatabase =
            Room.databaseBuilder(application, FakeDatabase::class.java, "post.db").build()

    @Provides
    @Singleton
    fun provideFakeDao(fakeDatabase: FakeDatabase): FakePostDao = fakeDatabase.fakePostDao()
}