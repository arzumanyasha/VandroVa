package com.example.user.vandrova;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.vandrova.networking.PlaceAPIFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackBottomSheetDialog extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        LatLng latLng = getArguments().getParcelable(Constants.LAT_LNG);
        String lat = String.valueOf(latLng.latitude);
        String lng = String.valueOf(latLng.longitude);
//        Call<JsonObject> resp = new PlaceAPIFactory().placeAPI.getFoursquarePlace(lat + "," + lng);
        Call<JsonObject> resp = new PlaceAPIFactory().placeAPI.getFoursquarePlace("53.9045,27.5615");
        resp.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();
                Log.i("", jsonObject.toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("", t.getMessage());

            }
        });

        final String placeId = "";
        final String placeName = "ilrhjv e;srojggirjg";

        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        Button leaveFeedback;
        Button viewFeedbacks;
        leaveFeedback = v.findViewById(R.id.feedbackBtn);
        viewFeedbacks = v.findViewById(R.id.ratingListBtn);
        leaveFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackScreenActivity.show(getActivity(), placeId, placeName);
            }
        });

        viewFeedbacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReviewsActivity.show(getActivity(), placeId, placeName);
            }
        });
        return v;
    }

}
