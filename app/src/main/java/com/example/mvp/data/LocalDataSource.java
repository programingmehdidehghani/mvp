package com.example.mvp.data;

import java.util.List;

import io.reactivex.rxjava3.core.Single;


public class LocalDataSource implements NewDataSource{

    @Override
    public Single<List<News>> getNews() {
        return null;
    }

    @Override
    public Single<List<Banner>> getBanner() {
        return null;
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
        return null;
    }

    @Override
    public Single<List<News>> getSearchNews(CharSequence charSequence) {
        return null;
    }

}
