package com.example.chenshuyu.dreamer.detail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import java.util.List;

public class DetailModel {
    private final String data = "data";
    private final String title = "title";
    private Intent intent;
//    private Intent intent = new Intent();
//    private Bundle bundle = new Bundle();
//    private Dreamer.DataBean dataBean = (Dreamer.DataBean)bundle.getSerializable(data);
    private void setIntent(DetailActivity detailActivity){
        intent = detailActivity.getIntent();
    }

    public List<String> getDataList(DetailActivity detailActivity){
        setIntent(detailActivity);
        Dreamer.DataBean dataBean = (Dreamer.DataBean)intent.getSerializableExtra(data);
        return dataBean.getList();
    }

    public String getTitle(){
        return intent.getStringExtra(title);
    }

}
