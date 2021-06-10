package com.example.mvp.data;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface NewDataSource {

    Single<List<News>> getNews();

    Single<List<Banner>> getBanner();

    Single<List<News>> getLastNews();

    Single<List<News>> getSaveNews();

    Single<List<Cat>> getCat();

    Single<List<News>> getSearchNews(CharSequence charSequence);

}
