package com.example.chenshuyu.dreamer.search;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一管理view与presenter的所有的接口，这种方式使得view与presenter中有哪些功能，一目了然，维护起来也方便
 */
public interface DreamerSearchContract {
    interface DreamerSearchUIView{
        //接口内的方法默认public
        void onError();
        void updateRV(List<Dreamer.DataBean> dataBeans);
        void onNull();
    }

    interface DreamerSearchPresenter{
        void getSearchDream(String keyword);
    }
}
