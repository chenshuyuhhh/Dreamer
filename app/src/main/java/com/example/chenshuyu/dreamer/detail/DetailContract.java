package com.example.chenshuyu.dreamer.detail;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import java.util.List;

public class DetailContract {
    interface DetailUIView{
        void updateRV(List<String> list);
        void onNull();
        void setTitle(String title);
    }

    interface DetailPresenter{
        void getContents(DetailActivity detailActivity);
        void getTitle();
    }
}
