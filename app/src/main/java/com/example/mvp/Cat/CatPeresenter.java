package com.example.mvp.Cat;

import com.example.mvp.Home.HomeCotract;
import com.example.mvp.data.Cat;
import com.example.mvp.data.NewDataSource;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CatPeresenter implements CatContract.presenter {

    private CatContract.View view;
    private NewDataSource newDataSource;
    private CompositeDisposable compositeDisposable;

    public CatPeresenter(NewDataSource newDataSource){
        this.newDataSource=newDataSource;
    }


    @Override
    public void AttachView(CatContract.View view) {
         this.view=view;
         getCatList();
    }

    @Override
    public void DttachView() {
         view=null;
         if (compositeDisposable!=null && compositeDisposable.size()>0){
             compositeDisposable.clear();
         }
    }

    @Override
    public void getCatList() {
          newDataSource.getCat().subscribeOn(Schedulers.newThread())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new SingleObserver<List<Cat>>() {
                      @Override
                      public void onSubscribe(@NonNull Disposable d) {
                         compositeDisposable.add(d);
                      }

                      @Override
                      public void onSuccess(@NonNull List<Cat> catList) {
                         view.showCatList(catList);
                      }

                      @Override
                      public void onError(@NonNull Throwable e) {
                          view.showErorr(e.toString());
                      }
                  });
    }
}
