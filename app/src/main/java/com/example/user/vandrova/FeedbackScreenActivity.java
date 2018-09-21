package com.example.user.vandrova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FeedbackScreenActivity extends AppCompatActivity {

    Button sendFeedbackButton;
    TextView placeNameTextView;
    ImageView placeImageView;
    EditText feedbackEditText, emailEditText, nameEditText;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_screen);

        Intent intent = getIntent();

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
                    Intent newIntent = new Intent(FeedbackScreenActivity.this, MainActivity.class);
                    startActivity(newIntent);
                }
            }
        });

    }
}
