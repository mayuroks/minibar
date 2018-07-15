package com.mayurrokade.slidingalert.library;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/**
 * TODO disable setting zTranslation
 * TODO bouncing effect
 * TODO auto-dismiss, expose duration
 * TODO show / hide duration
 * TODO set min API 21 in gradle
 */
public class SlidingAlertView extends android.support.v7.widget.AppCompatTextView {

    private boolean mIsShowing = true;
    private int mHeight;
    private ViewPropertyAnimator mAnimator;
    private float zDepth = -1000;
    private Interpolator mShowInterpolator, mDismissInterpolator;
    private long mShowDuration = 500;
    private long mDismissDuration = 500;

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public SlidingAlertView(Context context) {
        this(context, null);
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public SlidingAlertView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public SlidingAlertView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        setTranslationZ(zDepth);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getHeight();
    }

    public void setShowDuration(long duration) {
        mShowDuration = duration;
    }

    public void setShowInterpolator(Interpolator interpolator) {
        mShowInterpolator = interpolator;
    }

    public void setDismissInterpolator(Interpolator interpolator) {
        mDismissInterpolator = interpolator;
    }

    public void show() {
        mAnimator = animate();
        setAlpha(1);
        mIsShowing = true;

        mAnimator.setDuration(mShowDuration)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        // TODO give callback on alert shown
                    }
                });

        if (mShowInterpolator != null) {
            mAnimator.setInterpolator(mShowInterpolator);
        }

        mAnimator.start();
    }

    public void dismiss() {
        mAnimator = animate();

        mAnimator.setDuration(mDismissDuration)
                .translationY(-mHeight)
                .alpha(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mIsShowing = false;

                        // TODO give callback on alert hidden
                    }
                });

        if (mDismissInterpolator != null) {
            mAnimator.setInterpolator(mDismissInterpolator);
        }

        mAnimator.start();
    }

    public void fastDismiss() {
        if (isShowing()) {
            if (mAnimator != null) {
                mAnimator.cancel();
            }

            mIsShowing = false;
            setTranslationY(-mHeight);
            setAlpha(0);
        }
    }

    public boolean isShowing() {
        return mIsShowing;
    }
}