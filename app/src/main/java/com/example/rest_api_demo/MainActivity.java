package com.example.rest_api_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain = findViewById(R.id.recyle);
        rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RetrofitInterface retrofitInterface = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<PhotoModel>> listCall = retrofitInterface.getAllPhotos();
        listCall.enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                parseData(response.body());
            }

            @Override
            public void onFailure(Call<List<PhotoModel>> call, Throwable t) {

            }
        });
    }

    private void parseData(List<PhotoModel> body) {
        RecycerViewAdapter recycerViewAdapter = new RecycerViewAdapter(body,MainActivity.this);
        rvMain.setAdapter(recycerViewAdapter);
    }


    }
