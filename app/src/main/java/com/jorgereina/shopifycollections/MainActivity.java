package com.jorgereina.shopifycollections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CustomCollectionsAdapter adapter;
    private List<Collections> collections = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.cc_rv);
        adapter = new CustomCollectionsAdapter(collections);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://shopicruit.myshopify.com/admin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CollectionService service = retrofit.create(CollectionService.class);
        service.collections().enqueue(new Callback<CollectionsResponse>() {
            @Override
            public void onResponse(Call<CollectionsResponse> call, Response<CollectionsResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getCollections().get(0).getTitle());
                collections.addAll(response.body().getCollections());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CollectionsResponse> call, Throwable t) {

            }
        });
    }
}
