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

public class FeedbackBottomSheetDialog extends BottomSheetDialogFragment {
    private BottomSheetListener sheetListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final String placeId = getArguments().getString(Constants.PLACE_ID);
        final String placeName = getArguments().getString(Constants.PLACE_NAME);

        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        Button leaveFeedback;
        Button viewFeedbacks;
        leaveFeedback = v.findViewById(R.id.feedbackBtn);
        viewFeedbacks = v.findViewById(R.id.ratingListBtn);
        leaveFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackScreenActivity.show(container.getContext(), placeId, placeName);
                sheetListener.onButtonClicked(1);
                dismiss();
            }
        });

        viewFeedbacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReviewsActivity.show(container.getContext(), placeId, placeName);
                sheetListener.onButtonClicked(2);
                dismiss();
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
