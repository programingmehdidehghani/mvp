package com.example.mvp.data;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    @GET("index.php")
    Single<List<News>> getNews();

    @GET("index.php")
    Single<List<Banner>> getBanner();

    @GET("cat.php")
    Single<List<Cat>> getCat();

    @GET("search.php")
    Single<List<News>> getSearchNews(@Query("search") String search);

}
