package com.example.daraz.api;

import com.example.daraz.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemAPI {
    @GET("product/list")
    Call<List<Products>> getProduct();
}
