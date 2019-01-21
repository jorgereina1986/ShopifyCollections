package com.jorgereina.shopifycollections;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomCollectionsAdapter extends RecyclerView.Adapter<CustomCollectionsAdapter.ViewHolder> {

    private List<Collections> collections;

    public CustomCollectionsAdapter(List<Collections> collections) {
        this.collections = collections;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cc_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Collections collection = collections.get(i);
        viewHolder.textView.setText(collection.getTitle());
    }

    @Override
    public int getItemCount() {
        return collections != null ? collections.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.cc_title_tv);
        }
    }
}
