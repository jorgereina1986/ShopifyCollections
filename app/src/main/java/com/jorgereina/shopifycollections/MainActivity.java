package com.jorgereina.shopifycollections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://shopicruit.myshopify.com/admin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CollectionService service = retrofit.create(CollectionService.class);
        service.collections().enqueue(new Callback<CollectionsResponse>() {
            @Override
            public void onResponse(Call<CollectionsResponse> call, Response<CollectionsResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getCollections().get(0).getTitle());

            }

            @Override
            public void onFailure(Call<CollectionsResponse> call, Throwable t) {

            }
        });
    }
}
