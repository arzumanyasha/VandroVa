package com.example.user.vandrova;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.user.vandrova.adapter.ReviewAdapter;
import com.example.user.vandrova.dao.AppDatabase;
import com.example.user.vandrova.model.Review;

import java.util.List;

public class ReviewsActivity extends AppCompatActivity {

    public static void show(Context context, String placeId, String placeName) {
        Intent intent = new Intent(context, ReviewsActivity.class);
        intent.putExtra(Constants.PLACE_ID, placeId);
        intent.putExtra(Constants.PLACE_NAME, placeName);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        AppDatabase db = AppDatabase.getAppDatabase(this);
        TextView placeNameTv = findViewById(R.id.tv_place_name);
        placeNameTv.setText(getIntent().getStringExtra(Constants.PLACE_NAME));
        RatingBar ratingBar = findViewById(R.id.place_ratingBar);
        Float placeRating = db.reviewDao().getRatingByPlaceId(getIntent().getStringExtra(Constants.PLACE_ID));
        if (null != placeRating) {
            ratingBar.setRating(placeRating);
        }


        List<Review> reviewList = db.reviewDao().getByPlaceId(getIntent().getStringExtra(Constants.PLACE_ID));



        RecyclerView recyclerView = findViewById(R.id.rv_review_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ReviewAdapter reviewAdapter = new ReviewAdapter(reviewList);
        recyclerView.setAdapter(reviewAdapter);

    }
}
