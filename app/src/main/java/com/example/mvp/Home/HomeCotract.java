package com.example.mvp.Home;

import com.example.mvp.Base.BasePeresenter;
import com.example.mvp.Base.BaseView;
import com.example.mvp.data.Banner;
import com.example.mvp.data.News;

import java.util.List;

public interface HomeCotract {
    interface  View extends BaseView{
        void showNews(List<News> newsList);
        void showErorr();
        void showBanner(List<Banner> bannerList);
    }

    interface Presenter extends BasePeresenter<View>{
         void getNewsList();
    }
}
