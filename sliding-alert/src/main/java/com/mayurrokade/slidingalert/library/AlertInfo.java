package com.mayurrokade.slidingalert.library;

import android.support.annotation.ColorRes;

public class AlertInfo {

    @ColorRes
    private int backgroundColor;

    @ColorRes
    private int textColor;

    private String message;

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public String getMessage() {
        return message;
    }

    private AlertInfo(Builder builder) {
        message = builder.message;
        textColor = builder.textColor;
        backgroundColor = builder.backgroundColor;
    }

    public static class Builder {
        @ColorRes
        int backgroundColor;

        @ColorRes
        int textColor;

        String message;

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

        public AlertInfo build() {
            return new AlertInfo(this);
        }
    }
}
