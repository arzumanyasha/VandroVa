package com.example.user.vandrova.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.vandrova.R;
import com.example.user.vandrova.model.Review;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    private TextView reviewText;
    private TextView rating;

    public ReviewViewHolder(View itemView) {
        super(itemView);
        reviewText = itemView.findViewById(R.id.tv_review);
        rating = itemView.findViewById(R.id.tv_rating);
    }

    public void bindViewHolder(Review review) {
        reviewText.setText(review.getReviewText());
        rating.setText(review.getRating().toString());
    }
}
