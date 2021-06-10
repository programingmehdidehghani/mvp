package com.example.mvp.Cat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatAdaoter extends RecyclerView.Adapter<CatAdaoter.catViewHolder> {




    @NonNull
    @Override
    public catViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull catViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class catViewHolder extends RecyclerView.ViewHolder{

        public catViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
