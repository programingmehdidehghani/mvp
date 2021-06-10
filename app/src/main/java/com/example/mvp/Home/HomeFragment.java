package com.example.mvp.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mvp.Base.BaseFragment;
import com.example.mvp.R;
import com.example.mvp.data.Banner;
import com.example.mvp.data.News;
import com.example.mvp.data.NewsRepository;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HomeFragment extends BaseFragment implements HomeCotract.View {

    private HomeCotract.Presenter presenter;
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private ImageView imageView;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new HomePresenter(new NewsRepository());
    }


    @Override
    public void setupViews() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_blank;
    }

    @Override
    public void showNews(List<News> newsList) {

    }

    @Override
    public void showErorr() {

    }

    @Override
    public void showBanner(List<Banner> bannerList) {
         Banner banner=bannerList.get(0);
        Picasso.get().load(banner.getUrl()).into(imageView);
    }

    @Override
    public Context getViewContext() {
        return null;
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