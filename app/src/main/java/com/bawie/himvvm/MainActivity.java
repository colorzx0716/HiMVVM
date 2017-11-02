package com.bawie.himvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ViewDataBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        System.out.println("mainid-- = " + Thread.currentThread().getId());

        login();
    }

    private void login() {
        Map<String,String> map = new HashMap<>();
        map.put("mobile","13717830672");
        map.put("password","123456");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceApi interfaceApi =retrofit.create(InterfaceApi.class);
        Call<BaseResponseEntity<UserEtity>> getlogin = interfaceApi.getlogin(map);
        getlogin.enqueue(new Callback<BaseResponseEntity<UserEtity>>() {
            @Override
            public void onResponse(Call<BaseResponseEntity<UserEtity>> call, Response<BaseResponseEntity<UserEtity>> response) {
                System.out.println("responseid-- = " + Thread.currentThread().getId());

                dataBinding.setVariable(com.bawie.himvvm.BR.user,response.body().data);

            }

            @Override
            public void onFailure(Call<BaseResponseEntity<UserEtity>> call, Throwable t) {

            }
        });


    }


}
