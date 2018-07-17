package com.mayurrokade.minibar;

import android.support.annotation.ColorRes;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * UserMessage model.
 */

public class UserMessage {

    @ColorRes
    private int backgroundColor;

    @ColorRes
    private int textColor;

    private String message;

    private long duration = 1000;

    private Interpolator dismissInterpolator = new DecelerateInterpolator();

    private Interpolator showInterpolator = new AccelerateInterpolator();

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Interpolator getShowInterpolator() {
        return showInterpolator;
    }

    public void setShowInterpolator(Interpolator showInterpolator) {
        this.showInterpolator = showInterpolator;
    }

    public Interpolator getDismissInterpolator() {
        return dismissInterpolator;
    }

    public void setDismissInterpolator(Interpolator dismissInterpolator) {
        this.dismissInterpolator = dismissInterpolator;
    }

    private UserMessage(Builder builder) {
        message = builder.message;
        textColor = builder.textColor;
        backgroundColor = builder.backgroundColor;

        if (builder.duration > 0) {
            duration = builder.duration;
        }

        if (builder.showInterpolator != null) {
            showInterpolator = builder.showInterpolator;
        }

        if (builder.dismissInterpolator != null) {
            dismissInterpolator = builder.dismissInterpolator;
        }
    }

    public static class Builder {
        @ColorRes
        int backgroundColor;

        @ColorRes
        int textColor;

        String message;

        private long duration;

        private Interpolator dismissInterpolator;

        private Interpolator showInterpolator;

        public Builder setBackgroundColor(@ColorRes int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setTextColor(@ColorRes int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setDuration(long duration) {
            this.duration = duration;
            return this;
        }

        public Builder setDismissInterpolator(Interpolator dismissInterpolator) {
            this.dismissInterpolator = dismissInterpolator;
            return this;
        }

        public Builder setShowInterpolator(Interpolator showInterpolator) {
            this.showInterpolator = showInterpolator;
            return this;
        }

        public UserMessage build() {
            return new UserMessage(this);
        }
    }
}
