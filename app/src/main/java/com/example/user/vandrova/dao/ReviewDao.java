package com.example.user.vandrova.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.vandrova.model.Review;

import java.util.List;

@Dao
public interface ReviewDao {

    @Query("SELECT * FROM REVIEW")
    List<Review> getAll();

    @Query("SELECT * FROM REVIEW WHERE id = :id")
    Review getById(Integer id);

    @Query("SELECT * FROM REVIEW WHERE email = :email")
    Review getByEmail(String email);

    @Insert
    void insertAll(Review... reviews);

    @Delete
    void delete(Review review);

    @Query("DELETE FROM REVIEW")
    void deleteAll();
}
