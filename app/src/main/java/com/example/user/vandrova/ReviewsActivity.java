package com.example.user.vandrova;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.vandrova.adapter.ReviewAdapter;
import com.example.user.vandrova.dao.AppDatabase;
import com.example.user.vandrova.model.Review;

import java.util.List;

public class ReviewsActivity extends AppCompatActivity {

    private static final String PLACE_ID = "placeId";
    private static final String PLACE_NAME = "placeName";

    public static void show(Context context, String placeId, String placeName) {
        Intent intent = new Intent(context, ReviewsActivity.class);
        intent.putExtra(PLACE_ID, placeId);
        intent.putExtra(PLACE_NAME, placeName);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);


        TextView placeNameTv = findViewById(R.id.tv_place_name);
        placeNameTv.setText(getIntent().getStringExtra(PLACE_NAME));

        AppDatabase db = AppDatabase.getAppDatabase(this);
        List<Review> reviewList = db.reviewDao().getByPlaceId(getIntent().getStringExtra(PLACE_ID));



        RecyclerView recyclerView = findViewById(R.id.rv_review_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ReviewAdapter reviewAdapter = new ReviewAdapter(reviewList);
        recyclerView.setAdapter(reviewAdapter);

    }
}
