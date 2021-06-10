package com.example.mvp.Search;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.Base.BaseFragment;
import com.example.mvp.R;
import com.example.mvp.data.News;
import com.example.mvp.data.NewsRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends BaseFragment implements SearchContract.View{
    private SearchContract.presenter presenter;
    private RecyclerView recyclerView;
    private EditText editText;
    List<News> searchList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter= new SearchPresenter(new NewsRepository());
        searchList=new ArrayList<>();
    }

    @Override
    public void setupViews() {
       editText=(EditText)rootView.findViewById(R.id.edt_search);

       editText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
                setupViews();
                presenter.getSearchNews(s);
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_blank;
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

    @Override
    public void showSearchNews(List<News> news) {
        searchList.clear();
        searchList=news;
    }

    @Override
    public void showErorr(String erorr) {

    }
}
