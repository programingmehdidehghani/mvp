package com.example.mvp.Cat;

import com.example.mvp.Base.BasePeresenter;
import com.example.mvp.Base.BaseView;
import com.example.mvp.Home.HomeCotract;
import com.example.mvp.data.Cat;

import java.util.List;

public interface CatContract {
    interface View extends BaseView{

        void showCatList(List<Cat> catList);
        void showErorr(String error);
    }
    interface presenter extends BasePeresenter<View>{

        void getCatList();
    }
}
