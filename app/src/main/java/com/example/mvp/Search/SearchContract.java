package com.example.mvp.Search;

import com.example.mvp.Base.BasePeresenter;
import com.example.mvp.Base.BaseView;
import com.example.mvp.data.News;

import java.util.List;

public interface SearchContract {
    interface View extends BaseView{
        void showSearchNews(List<News> news);
        void showErorr(String erorr);

    }
    interface presenter extends BasePeresenter<View>{
       void getSearchNews(CharSequence charSequence);
    }
}
