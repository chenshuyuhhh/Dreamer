package com.example.chenshuyu.dreamer.detail;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import java.util.List;

public class DetailPresenterImp implements DetailContract.DetailPresenter {
    DetailContract.DetailUIView detailUIView;
    DetailModel detailModel = new DetailModel();

    public DetailPresenterImp(DetailContract.DetailUIView detailUIView){
        this.detailUIView = detailUIView;
    }
    @Override
    public void getContents(DetailActivity detailActivity) {
        List<String> dataList = detailModel.getDataList(detailActivity);
        if (dataList.size() > 0){
            detailUIView.updateRV(dataList);
        }else {
            detailUIView.onNull();
        }
    }

    @Override
    public void getTitle() {
        detailUIView.setTitle(detailModel.getTitle());
    }
}
