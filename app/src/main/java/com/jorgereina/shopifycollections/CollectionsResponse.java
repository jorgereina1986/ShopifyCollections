package com.jorgereina.shopifycollections;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionsResponse {

    @SerializedName("custom_collections")
    private List<Collections> collections;

    public List<Collections> getCollections() {
        return collections;
    }

    public void setCollections(List<Collections> collections) {
        this.collections = collections;
    }
}
