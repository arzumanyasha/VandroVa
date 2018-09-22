package com.example.user.vandrova.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.user.vandrova.R;
import com.example.user.vandrova.model.Review;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    private TextView reviewText;
    private TextView name;
    private RatingBar rating;
    private TextView email;

    public ReviewViewHolder(View itemView) {
        super(itemView);
        reviewText = itemView.findViewById(R.id.tv_review);
        rating = itemView.findViewById(R.id.ratingBar);
        name = itemView.findViewById(R.id.tv_name);
        email = itemView.findViewById(R.id.tv_email);

    }

    public void bindViewHolder(Review review) {
        reviewText.setText(review.getReviewText());
        name.setText(review.getName());
        rating.setRating(review.getRating());
        email.setText(review.getEmail());
    }
}
