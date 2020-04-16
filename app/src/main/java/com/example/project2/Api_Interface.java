package com.example.project2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interface {

    @GET("amount=10&category=21&difficulty=medium&type=multiple")
    public Call<List<QuestionModel>> getApi();
}
