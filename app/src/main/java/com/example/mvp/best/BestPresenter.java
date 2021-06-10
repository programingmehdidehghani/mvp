package com.example.mvp.best;

import android.content.Context;
import android.database.Cursor;

import com.example.mvp.data.MyDataBase;
import com.example.mvp.data.NewDataSource;
import com.example.mvp.data.News;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class BestPresenter implements BestContract.peresenter {
    private BestContract.View view;
    private NewDataSource newDataSource;
    private CompositeDisposable disposable=new CompositeDisposable();
    MyDataBase myDataBase;
    List<News> newsList;

    public BestPresenter(NewDataSource newDataSource){
        this.newDataSource=newDataSource;
        newsList=new ArrayList<>();
    }

    @Override
    public void AttachView(BestContract.View view) {

    }

    @Override
    public void DttachView() {

    }

    @Override
    public void getSaveNews(Context context) {
        myDataBase=new MyDataBase(context);
        Cursor cursor=myDataBase.getInfos();
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToLast()){
            int id=cursor.getInt(0);
            String title=cursor.getString(1);
            String des=cursor.getString(2);
            String data=cursor.getString(3);
            News news=new News();
            news.setTitle(title);
            news.setTitle(des);
            news.setTitle(data);
            newsList.add(news);
            view.showSaveNews(newsList);
        }

    }
}
