package com.mayurrokade.minibar.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

import com.mayurrokade.minibar.MinibarView;
import com.mayurrokade.minibar.UserMessage;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        Button button = findViewById(R.id.button);
        final MinibarView alertView = findViewById(R.id.minibarView);

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
                    UserMessage positiveAlert = new UserMessage.Builder()
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
