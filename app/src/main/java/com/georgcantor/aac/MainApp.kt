package com.georgcantor.aac

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Alex on 05.03.2018.
 */
class MainApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispaActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initInjector()

        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispaActivityInjector

    private fun initInjector() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }
}