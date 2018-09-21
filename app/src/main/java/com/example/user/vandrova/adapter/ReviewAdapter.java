package com.example.user.vandrova.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.vandrova.R;
import com.example.user.vandrova.model.Review;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewHolder> {

    private List<Review> reviews;

    public ReviewAdapter(List<Review> reviews) {
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_review, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.bindViewHolder(reviews.get(position));
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
}
