package com.example.mvp.Cat;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.mvp.Base.BaseFragment;
import com.example.mvp.Home.HomeCotract;
import com.example.mvp.data.Cat;

import java.util.List;

public class CatFragment extends BaseFragment implements CatContract.View {
    private CatContract.presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void showCatList(List<Cat> catList) {
             setupViews();
    }

    @Override
    public void showErorr(String error) {

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.AttachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.DttachView();
    }
}
