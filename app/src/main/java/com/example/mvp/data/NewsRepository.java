package com.example.mvp.data;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class NewsRepository implements NewDataSource {
    private  ServerDataSource serverDataSource=new ServerDataSource();
    private LocalDataSource localDataSource=new LocalDataSource();

    @Override
    public Single<List<News>> getNews() {
        return serverDataSource.getNews();
    }

    @Override
    public Single<List<Banner>> getBanner() {
        return serverDataSource.getBanner();
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
        return serverDataSource.getCat();
    }

    @Override
    public Single<List<News>> getSearchNews(CharSequence charSequence) {
        return serverDataSource.getSearchNews(charSequence);
    }


}
