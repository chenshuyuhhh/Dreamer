package com.example.chenshuyu.dreamer.search;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.chenshuyu.dreamer.R;
import com.example.chenshuyu.dreamer.entity.Dreamer;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class SearchActivity extends AppCompatActivity implements DreamerSearchContract.DreamerSearchUIView{
    private String keyword;
    private EditText editText;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private LinearLayout linearLayout;
    private List<Dreamer.DataBean> dataBeans = new ArrayList<>();
    private DreamerSearchContract.DreamerSearchPresenter presenter = new DreamSearchPresenterImpl(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initId();
        initRV();

        linearLayout.setVisibility(View.GONE);
        editText.setHint("请输入你想搜索的关键字");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = editText.getText().toString();
                presenter.getSearchDream(keyword);
            }
        });
    }

    // 绑定控件
    private void initId(){
        editText = findViewById(R.id.search_edit);
        imageView = findViewById(R.id.search_img);
        recyclerView = findViewById(R.id.search_rv);
        linearLayout = findViewById(R.id.search_no);
    }

    // 初始化rv
    private void initRV(){
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        searchAdapter = new SearchAdapter(dataBeans,this);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(searchAdapter);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onError() {
        linearLayout.setVisibility(View.GONE);
        Toasty.error(this,"你的网络崩溃了，5555~",Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateRV(List<Dreamer.DataBean> dataBeanArrayList) {
        linearLayout.setVisibility(View.GONE);
        searchAdapter.update(dataBeanArrayList);
    }

    @Override
    public void onNull() {
        dataBeans.clear();
        searchAdapter.update(dataBeans);
        linearLayout.setVisibility(View.VISIBLE);
    }
}
