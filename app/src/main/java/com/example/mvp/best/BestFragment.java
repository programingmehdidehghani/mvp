package com.example.mvp.best;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.Base.BaseFragment;
import com.example.mvp.data.MyDataBase;
import com.example.mvp.data.News;
import com.example.mvp.data.NewsRepository;

import java.util.List;

public class BestFragment extends BaseFragment implements BestContract.View {
    private BestContract.peresenter peresenter;
    private RecyclerView recyclerView;
    

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        peresenter= new BestPresenter(new NewsRepository());

    }



    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void onStart() {
        super.onStart();
        peresenter.AttachView(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        peresenter.DttachView();
    }

    @Override
    public void showSaveNews(List<News> news) {

    }

    @Override
    public void showErorr(String erorr) {

    }
}
