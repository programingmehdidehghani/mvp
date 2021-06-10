package com.example.mvp.Base;

public interface BasePeresenter<T extends BaseView> {

    void AttachView(T view);
    void DttachView();
}
