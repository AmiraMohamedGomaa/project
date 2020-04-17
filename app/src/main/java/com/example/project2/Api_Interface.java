package com.example.project2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Interface {

    @GET("amount=10&category=21&difficulty=medium&type=multiple&fbclid=IwAR0qe3mITnOL2beC5fCQ8k4XuZWJFFqYQ6Km0lqSc-XJAY0qrdo7Jo6z1IQ\n")
    public Call<List<QuestionModel>> getApi();
}
