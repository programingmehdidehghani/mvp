package com.example.mvp.best;

import android.content.Context;
import android.view.View;

import com.example.mvp.Base.BasePeresenter;
import com.example.mvp.Base.BaseView;
import com.example.mvp.Home.HomeCotract;
import com.example.mvp.data.News;

import java.util.List;

public interface BestContract {
    interface View extends BaseView{
       void showSaveNews(List<News> news);
       void showErorr(String erorr);
    }
    interface peresenter extends BasePeresenter<View>{
       void getSaveNews(Context context);
    }
}
