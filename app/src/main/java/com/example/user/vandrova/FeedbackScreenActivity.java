package com.example.user.vandrova;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.user.vandrova.dao.AppDatabase;
import com.example.user.vandrova.model.Review;

public class FeedbackScreenActivity extends AppCompatActivity {

    Button sendFeedbackButton;
    TextView placeNameTextView;
    ImageView placeImageView;
    EditText feedbackEditText, emailEditText, nameEditText;
    RatingBar rating;

    public static void show(Context context, String placeId, String placeName) {
        Intent intent = new Intent(context, FeedbackScreenActivity.class);
        intent.putExtra(Constants.PLACE_ID, placeId);
        intent.putExtra(Constants.PLACE_NAME, placeName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_screen);

        Intent intent = getIntent();
        final String placeId = intent.getStringExtra(Constants.PLACE_ID);
        final String placeName = intent.getStringExtra(Constants.PLACE_NAME);

        rating = findViewById(R.id.ratingBar);
        placeNameTextView = findViewById(R.id.placeNameTextView);
        placeImageView = findViewById(R.id.placeImage);
        feedbackEditText = findViewById(R.id.feedbackEditText);
        emailEditText = findViewById(R.id.emailEditText);
        nameEditText = findViewById(R.id.userNameEditText);
        sendFeedbackButton = findViewById(R.id.sendFeedback);
        sendFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(feedbackEditText.getText()!=null && emailEditText.getText()!=null && nameEditText.getText()!=null && rating.getRating()!=0.0){
                    Review review = new Review(placeId, emailEditText.getText().toString(), nameEditText.getText().toString(), feedbackEditText.getText().toString(), rating.getNumStars());
                    AppDatabase.getAppDatabase(FeedbackScreenActivity.this).reviewDao().insertAll(review);
                    Intent newIntent = new Intent(FeedbackScreenActivity.this, MainActivity.class);
                    startActivity(newIntent);
                }
            }
        });

    }
}
