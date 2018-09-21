package com.example.user.vandrova.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "REVIEWS")
public class Review {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String placeId;

    private String email;

    private String name;

    private String reviewText;

    private Integer rating;

    public Review(String placeId, String email, String name, String reviewText, Integer rating) {
        this.placeId = placeId;
        this.email = email;
        this.name = name;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
