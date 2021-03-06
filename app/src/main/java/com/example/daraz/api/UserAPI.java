package com.example.daraz.api;

import com.example.daraz.model.Users;
import com.example.daraz.serverresponse.SignUpResponse;
import com.example.daraz.model.Users;
import com.example.daraz.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("user/signup")
    Call<SignUpResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("user/login")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);


}
