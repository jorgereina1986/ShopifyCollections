package com.jorgereina.shopifycollections;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CollectionService {

//    https://shopicruit.myshopify.com/admin/custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6
//    https://shopicruit.myshopify.com/admin/collects.json?collection_id=68424466488&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6

//    @GET("page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    @GET("custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
//    Call<List<Collections>> collections(@Query("access_token") String token);
    Call<CollectionsResponse> collections();

    @GET("collects.json?{query}&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<List<Collection>> collection(@Query("collection_id") String id);


}
