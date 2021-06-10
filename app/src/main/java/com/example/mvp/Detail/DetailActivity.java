package com.example.mvp.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvp.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle=getIntent().getExtras();
        String title=bundle.getString("mi");

    }
}