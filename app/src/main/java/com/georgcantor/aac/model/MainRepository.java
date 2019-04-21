package com.georgcantor.aac.model;

import com.georgcantor.aac.BuildConfig;
import com.georgcantor.aac.model.data.NewsResponse;
import com.georgcantor.aac.model.remote.Api;

import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainRepository {

    private static final String MOVIES_URL = "http://api.themoviedb.org/3/";
    private Api api;
    private static MainRepository repository;

    private MainRepository() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MOVIES_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public synchronized static MainRepository getInstance() {
        if (repository == null) {
            repository = new MainRepository();
        }

        return repository;
    }

    public LiveData<NewsResponse> getNews(String sources) {
        final MediatorLiveData<NewsResponse> news = new MediatorLiveData<>();

        api.getHeadlines(sources, BuildConfig.API_KEY).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                news.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                news.setValue(null);
            }
        });

        return news;
    }
}
