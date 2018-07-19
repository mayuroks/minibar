package com.mayurrokade.minibar;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * This can be used to create a UserMessage object to show a message to the user.
 * UserMessage allows you to customize the message's background color, text color,
 * duration etc.
 */

public class UserMessage {

    private static final String EMPTY_STRING = "";

    @ColorRes
    private int backgroundColor;

    @ColorRes
    private int textColor;

    private Context context;
    private String message;
    private long duration = 1000;
    private Interpolator dismissInterpolator = new DecelerateInterpolator();
    private Interpolator showInterpolator = new AccelerateInterpolator();

    /**
     * Get background color
     *
     * @return backgroundColor which is @ColorRes
     */
    public int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Set background color
     *
     * @param backgroundColor which is @ColorRes
     */
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * Get text color
     *
     * @return textColor which is @ColorRes
     */
    public int getTextColor() {
        return textColor;
    }

    /**
     * Set text color
     *
     * @param textColor which is @ColorRes
     */
    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    /**
     * Get message
     *
     * @return message which is a String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set message
     *
     * @param message which is a String
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get duration
     *
     * @return duration which is a long
     */
    public long getDuration() {
        return duration;
    }

    /**
     * Set duration
     *
     * @param duration which is a long
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * Get showInterpolator
     *
     * @return showInterpolator which a {@link Interpolator}
     */
    public Interpolator getShowInterpolator() {
        return showInterpolator;
    }

    /**
     * Set showInterpolator
     *
     * @param showInterpolator which is a {@link Interpolator}
     */
    public void setShowInterpolator(Interpolator showInterpolator) {
        this.showInterpolator = showInterpolator;
    }

    /**
     * Get dismissInterpolator
     *
     * @return dismissInterpolator which is a {@link Interpolator}
     */
    public Interpolator getDismissInterpolator() {
        return dismissInterpolator;
    }

    /**
     * Set dismissInterpolator
     *
     * @param dismissInterpolator which is a {@link Interpolator}
     */
    public void setDismissInterpolator(Interpolator dismissInterpolator) {
        this.dismissInterpolator = dismissInterpolator;
    }

    // Prevent direct instantiation
    private UserMessage(Builder builder) {
        if (builder.message != null) {
            message = builder.message;
        } else {
            message = EMPTY_STRING;
        }

        if (builder.context != null) {
            context = builder.context;
        } else {
            throw new RuntimeException("Context cannot be null.");
        }

        if (builder.textColor == 0) {
            // TODO need a better way to set default color
            textColor = android.R.color.white;
        } else {
            textColor = builder.textColor;
        }

        if (builder.backgroundColor == 0) {
            // TODO need a better way to set default color
            backgroundColor = R.color.colorSuccess;
        } else {
            backgroundColor = builder.backgroundColor;
        }

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

    /**
     * Use this to build and customize UserMessage
     */
    public static class Builder {

        @ColorRes
        private int backgroundColor;

        @ColorRes
        private int textColor;

        private Context context;
        private String message;
        private long duration;
        private Interpolator dismissInterpolator;
        private Interpolator showInterpolator;

        public Builder with(@NonNull Context context) {
            this.context = context;
            return this;
        }

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
