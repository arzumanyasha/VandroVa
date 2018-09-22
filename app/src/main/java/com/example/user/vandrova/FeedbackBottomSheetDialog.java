package com.example.user.vandrova;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.vandrova.networking.Venue;
import com.example.user.vandrova.networking.PlaceAPIFactory;
import com.example.user.vandrova.networking.VenuesResponse;
import com.google.android.gms.maps.model.LatLng;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackBottomSheetDialog extends BottomSheetDialogFragment {

    String placeId = "";
    String placeName = "";
    TextView placeTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        LatLng latLng = getArguments().getParcelable(Constants.LAT_LNG);
        String lat = String.valueOf(latLng.latitude);
        String lng = String.valueOf(latLng.longitude);
        Call<VenuesResponse> resp = new PlaceAPIFactory().placeAPI.getFoursquarePlace(lat + "," + lng);
        //Call<VenuesResponse> resp = new PlaceAPIFactory().placeAPI.getFoursquarePlace("53.9045,27.5615");
        resp.enqueue(new Callback<VenuesResponse>() {
            @Override
            public void onResponse(Call<VenuesResponse> call, Response<VenuesResponse> response) {

                VenuesResponse venuesResponse = response.body();
                if (null != venuesResponse.getGroups() && !venuesResponse.getGroups().isEmpty()) {

                    if (null != venuesResponse.getGroups().get(0).getItems() && !venuesResponse.getGroups().get(0).getItems().isEmpty()) {
                        Venue venue = venuesResponse.getGroups().get(0).getItems().get(0).getVenue();
                        if (null != venue) {
                            placeId = venue.getId();
                            placeName = venue.getName();
                            setTVName(placeName);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<VenuesResponse> call, Throwable t) {
                Log.e("", t.getMessage());

            }
        });



        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);


        Button leaveFeedback;
        Button viewFeedbacks;
        placeTextView = v.findViewById(R.id.placeNameTV);
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

    private void setTVName(String placeName) {
        placeTextView.setText("You are near " + placeName);
    }


}
