package com.example.r2sacademy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    String LISTSTUDENT = "listStudent";

    @GET(LISTSTUDENT)
    Call<List<ListStudent>> getListStudent();

    @GET(LISTSTUDENT + "{/id}")
    Call<ListStudent> getStudentById(@Path("id") Object id);

    @POST("listStudent")
    Call<ListStudent> createStudent(@Body ListStudent listStudent);

    @PUT(LISTSTUDENT + "{/id}")
    Call<ListStudent> updateStudent(@Path("id") Object id, @Body ListStudent listStudent);

    @DELETE(LISTSTUDENT + "{/id}")
    Call<ListStudent> deleteStudent(@Path("id") Object id);
}
