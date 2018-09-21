package com.example.user.vandrova.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.vandrova.model.Review;

import java.util.List;

@Dao
public interface ReviewDao {

    @Query("SELECT * FROM REVIEWS")
    List<Review> getAll();

    @Query("SELECT * FROM REVIEWS WHERE id = :id")
    Review getById(Integer id);

    @Query("SELECT * FROM REVIEWS WHERE email = :email")
    Review getByEmail(String email);

    @Query("SELECT * FROM REVIEWS WHERE placeId = :placeId")
    List<Review> getByPlaceId(String placeId);

    @Query("SELECT COUNT(*) FROM REVIEWS WHERE placeId = :placeId")
    Integer getCountByPlaceId(String placeId);

    @Query("SELECT SUM(RATING) FROM REVIEWS WHERE placeId = :placeId")
    Integer getSumRatingByPlaceId(String placeId);

    @Query("SELECT SUM(RATING)/COUNT(RATING) FROM REVIEWS WHERE placeId = :placeId")
    Double getRatingByPlaceId(String placeId);

    @Insert
    void insertAll(Review... reviews);

    @Delete
    void delete(Review review);

    @Query("DELETE FROM REVIEWS")
    void deleteAll();
}
