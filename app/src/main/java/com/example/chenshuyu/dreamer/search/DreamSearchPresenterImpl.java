package com.example.chenshuyu.dreamer.search;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DreamSearchPresenterImpl implements DreamerSearchContract.DreamerSearchPresenter {
    private DreamerSearchContract.DreamerSearchUIView searchUIView;
    private DreamSearchModel dreamSearchModel = new DreamSearchModel();

    public DreamSearchPresenterImpl(DreamerSearchContract.DreamerSearchUIView searchUIView){
        this.searchUIView = searchUIView;
    }

    @Override
    public void getSearchDream(String keyword) {
        Call<Dreamer> call = dreamSearchModel.update(keyword);
        call.enqueue(new Callback<Dreamer>() {
            @Override
            public void onResponse(Call<Dreamer> call, Response<Dreamer> response) {
                Dreamer dreamer = response.body();
                if (dreamer.getData() == null){
                    searchUIView.onNull();
                }else {
                    searchUIView.updateRV(dreamer.getData());
                }
            }

            @Override
            public void onFailure(Call<Dreamer> call, Throwable t) {
                searchUIView.onError();
                t.printStackTrace();
            }
        });
    }
}
