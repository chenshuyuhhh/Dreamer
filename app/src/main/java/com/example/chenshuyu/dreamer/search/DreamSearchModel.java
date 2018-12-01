package com.example.chenshuyu.dreamer.search;

        import com.example.chenshuyu.dreamer.entity.Dreamer;
        import com.example.chenshuyu.dreamer.service.RetrofitService;

        import okhttp3.OkHttpClient;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class DreamSearchModel {

    private Retrofit retrofit = new Retrofit.Builder()
            //设置数据解析器
            .addConverterFactory(GsonConverterFactory.create())
            //设置网络请求的Url地址
            .baseUrl("https://api.shenjian.io/")
            .build();

    // 创建网络请求接口的实例
    private RetrofitService api = retrofit.create(RetrofitService.class);

    //通过update方法获得网络请求拿到的数据
    public Call<Dreamer> update(String keyword){
        return api.getSearch("cfcde6656c3d1b67ecbecf400592d05e",keyword);
    }
}
