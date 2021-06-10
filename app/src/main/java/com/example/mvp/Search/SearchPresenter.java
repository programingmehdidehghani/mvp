package com.example.mvp.Search;

import com.example.mvp.data.NewDataSource;
import com.example.mvp.data.News;
import com.example.mvp.data.NewsRepository;
import com.example.mvp.data.ServerDataSource;

import java.util.List;

import javax.sql.DataSource;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchPresenter implements SearchContract.presenter {
    private SearchContract.View view;
    private NewDataSource newDataSource;
    private CompositeDisposable compositeDisposable;



   public SearchPresenter(NewDataSource newDataSource){
       this.newDataSource=newDataSource;
   }


    @Override
    public void AttachView(SearchContract.View view) {
         this.view=view;
         if (compositeDisposable!=null && compositeDisposable.size()>0){
            compositeDisposable.clear();
         }
    }

    @Override
    public void DttachView() {
         this.view=null;
    }

    @Override
    public void getSearchNews(CharSequence charSequence) {
        newDataSource.getSearchNews(charSequence).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<News>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull List<News> news) {
                        view.showSearchNews(news);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showErorr(e.toString());
                    }
                });
    }
}
