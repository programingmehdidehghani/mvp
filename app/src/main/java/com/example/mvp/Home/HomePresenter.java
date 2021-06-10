package com.example.mvp.Home;

import com.example.mvp.data.NewDataSource;
import com.example.mvp.data.News;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomePresenter implements HomeCotract.Presenter{
    private HomeCotract.View view;
    private NewDataSource newDataSource;
    private CompositeDisposable disposable=new CompositeDisposable();

    public HomePresenter(NewDataSource newDataSource){
        this.newDataSource=newDataSource;
    }

    @Override
    public void getNewsList() {

       newDataSource.getNews().subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleObserver<List<News>>() {
                   @Override
                   public void onSubscribe(@NonNull Disposable d) {
                      disposable.add(d);
                   }

                   @Override
                   public void onSuccess(@NonNull List<News> news) {
                      view.showNews(news);
                   }

                   @Override
                   public void onError(@NonNull Throwable e) {
                      view.showErorr();e.toString();
                   }
               });
    }

    @Override
    public void AttachView(HomeCotract.View view) {
         this.view=view;
    }

    @Override
    public void DttachView() {
         this.view=null;
         if (disposable!=null && disposable.size()>0){
            disposable.clear();
         }
    }


}
