package com.example.generalaeronautics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class homeScreenActivity extends AppCompatActivity {


    //https://jsonplaceholder.typicode.com/users
    public static final String TAG = "HOME ACTIVITY";

    RecyclerView recyclerView;
    public List<userModelClass> user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        recyclerView = findViewById(R.id.recyclerview);


        user = new ArrayList<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usersAPI usersApi = retrofit.create(usersAPI.class);

        Call<List<userModelClass>> call = usersApi.getUsers();


        call.enqueue(new Callback<List<userModelClass>>() {


            private static final String TAG = "MyActivity";

            @Override
            public void onResponse(Call<List<userModelClass>> call, Response<List<userModelClass>> response) {
                if (!response.isSuccessful()) {
                    return;
                }


                List<userModelClass> users = response.body();

                for (userModelClass emp : user) {

                    user.add(emp);


                }

                PutDataIntoRecyclerView(users);


            }


            @Override
            public void onFailure(Call<List<userModelClass>> call, Throwable t) {

            }
        });


    }

    private void PutDataIntoRecyclerView(List<userModelClass> users) {
        Adapter adapter = new Adapter(this, users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}