package com.example.generalaeronautics;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface usersAPI {
    @GET("users")
    Call<List<userModelClass>> getUsers();


}
