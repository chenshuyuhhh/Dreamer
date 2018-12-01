package com.example.chenshuyu.dreamer.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenshuyu.dreamer.R;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class DetailActivity extends AppCompatActivity implements DetailContract.DetailUIView{
    private RecyclerView recyclerView;
    private DetailAdapter detailAdapter;
    private TextView title;
    private List<String> contents = new ArrayList<>();
    private DetailPresenterImp detailPresenterImp = new DetailPresenterImp(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initID();
        initRV();
        detailPresenterImp.getContents(this);
        detailPresenterImp.getTitle();
    }

    private void initID(){
        recyclerView = findViewById(R.id.detail_rv);
        title = findViewById(R.id.detail_tv_title);
    }

    private void initRV(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        detailAdapter = new DetailAdapter(contents);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(detailAdapter);
    }

    @Override
    public void updateRV(List<String> list) {
        detailAdapter.update(list);
    }

    @Override
    public void onNull() {
        Toasty.error(this,"抱歉没有详细信息，555～", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }
}
