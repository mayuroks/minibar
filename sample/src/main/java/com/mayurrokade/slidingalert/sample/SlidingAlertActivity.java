package com.mayurrokade.slidingalert.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

import com.mayurrokade.slidingalert.R;
import com.mayurrokade.slidingalert.library.AlertInfo;
import com.mayurrokade.slidingalert.library.SlidingAlertView;

public class SlidingAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_alert);

        Button button = findViewById(R.id.button);
        final SlidingAlertView alertView = findViewById(R.id.slidingAlertView);

        alertView.setShowInterpolator(new DecelerateInterpolator());
        alertView.setDismissInterpolator(new AccelerateInterpolator());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alertView.isShowing()) {
                    // then dismiss
                    alertView.dismiss();
                } else {
                    // show the view
                    AlertInfo positiveAlert = new AlertInfo.Builder()
                            .setBackgroundColor(R.color.colorSuccess)
                            .setTextColor(android.R.color.white)
                            .setMessage("This is cool")
                            .build();

                    alertView.show(positiveAlert);
                }
            }
        });
    }
}
