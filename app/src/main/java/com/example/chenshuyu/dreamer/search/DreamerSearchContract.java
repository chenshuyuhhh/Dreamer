package com.example.chenshuyu.dreamer.search;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一管理view与presenter的所有的接口，这种方式使得view与presenter中有哪些功能，一目了然，维护起来也方便
 */
public interface DreamerSearchContract {
    interface DreamerSearchUIView{
        //当网络错误等原因获取搜索结果没有成功时
        void onError();
        //成功获得搜索结果，且结果不为空时
        void updateRV(List<Dreamer.DataBean> dataBeans);
        //成功获得搜索结果，但是并没有搜出来东西时
        void onNull();
    }

    interface DreamerSearchPresenter{
        //根据搜索输入的获keyword获得搜索结果的
        void getSearchDream(String keyword);
    }
}
