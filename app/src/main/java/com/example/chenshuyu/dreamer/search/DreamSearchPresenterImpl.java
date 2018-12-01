package com.example.chenshuyu.dreamer.search;

import com.example.chenshuyu.dreamer.entity.Dreamer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DreamSearchPresenterImpl implements DreamerSearchContract.DreamerSearchPresenter {

    /**
     * presenter应该持有 view 层和 model 层的引用
     * 这样才能完成两层之间的逻辑交互
     * 同时使 view 层和 model 层完全隔离开来
     */
    private DreamerSearchContract.DreamerSearchUIView searchUIView;
    private DreamSearchModel dreamSearchModel = new DreamSearchModel();

    /**
     * presenter 层对应的类持有的 view 层对应的类是没有办法在 presenter 内部实例化的（此时的view是有方法但是没有具体实现的接口）
     * view 层的具体实现是 activity 继承 view 层，并重写 view 层的所有方法，即 activity 就是 view 层
     * 故成员对象 view 的实例化对象是在activity中传给presenter的
     * 所以 presenter 的构造函数中应该传入 view
     * model 层是有具体实现类的，并且已经在 presenter 类的内部实例化了，这样才能拿到 model 的具体数据，进行操作
     * @param searchUIView
     */
    public DreamSearchPresenterImpl(DreamerSearchContract.DreamerSearchUIView searchUIView){
        this.searchUIView = searchUIView;
    }

    /**
     * view 层和 model 层的逻辑交互，根据model的数据，执行相关的view层操作
     * @param keyword
     */
    @Override
    public void getSearchDream(String keyword) {
        Call<Dreamer> call = dreamSearchModel.update(keyword);
        call.enqueue(new Callback<Dreamer>() {

            //发送网络请求成功
            @Override
            public void onResponse(Call<Dreamer> call, Response<Dreamer> response) {
                Dreamer dreamer = response.body();
                if (dreamer.getData() == null){
                    searchUIView.onNull();
                }else {
                    searchUIView.updateRV(dreamer.getData());
                }
            }

            //没有成功
            @Override
            public void onFailure(Call<Dreamer> call, Throwable t) {
                searchUIView.onError();
                t.printStackTrace();
            }
        });
    }
}
