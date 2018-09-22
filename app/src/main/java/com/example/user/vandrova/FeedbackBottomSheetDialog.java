package com.example.user.vandrova;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.model.LatLng;

public class FeedbackBottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetListener sheetListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        LatLng latLng = getArguments().getParcelable(Constants.LAT_LNG);

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

    public interface BottomSheetListener {
        void onButtonClicked(int btnNumb);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            sheetListener = (BottomSheetListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement buttom sheet listener");
        }

    }
}
