package com.example.finalapplication;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL ="https://reqres.in/api/";
    @GET("users")
    Call<GetData> getUserList(@Query("page") int page);

    @POST("users")
    Call<FormData> createPost(@Body FormData formdata);


}
