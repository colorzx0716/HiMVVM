package com.bawie.himvvm;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*
 * Created by 张肖肖 on 2017/11/1.
 */

public interface InterfaceApi {

    @POST("user/login")
    @FormUrlEncoded
    Call<BaseResponseEntity<UserEtity>> getlogin(@FieldMap Map<String,String> params);

}
