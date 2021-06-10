package com.example.mvp.data;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServerDataSource implements NewDataSource{
    private ApiService apiService;


    public ServerDataSource(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService=retrofit.create(ApiService.class);
    }

    @Override
    public Single<List<News>> getNews() {
        return apiService.getNews();
    }

    @Override
    public Single<List<Banner>> getBanner() {
        return apiService.getBanner();
    }

    @Override
    public Single<List<News>> getLastNews() {
        return null;
    }

    @Override
    public Single<List<News>> getSaveNews() {
        return null;
    }

    @Override
    public Single<List<Cat>> getCat() {
        return apiService.getCat();
    }

    @Override
    public Single<List<News>> getSearchNews(CharSequence charSequence) {
        return apiService.getSearchNews(charSequence.toString());
    }


}
