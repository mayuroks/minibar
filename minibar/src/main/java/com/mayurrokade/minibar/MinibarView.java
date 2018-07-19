package com.mayurrokade.minibar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;

/**
 * TODO disable setting zTranslation
 * TODO implement queuing for rapid show() events
 */

public class MinibarView extends android.support.v7.widget.AppCompatTextView {

    private static final String TAG = "MinibarView";
    private boolean mIsShowing = false;
    private int mHeight;
    private ViewPropertyAnimator mAnimator;
    private float zDepth = -1000;
    private long mDismissDuration = 500;
    private long mShowDuration = 500;
    private UserMessage mUserMessage;

    public MinibarView(Context context) {
        this(context, null);
    }

    public MinibarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MinibarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Put the element behind all views to hide the Y translation.
        setTranslationZ(zDepth);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getHeight();

        if (!isShowing()) {
            setTranslationY(-mHeight);
            setAlpha(0);
        }
    }

    /**
     * Show the message in {@link MinibarView}
     *
     * @param userMessage
     */
    public void show(UserMessage userMessage) {
        mUserMessage = userMessage;

        int bgColor = ContextCompat.getColor(getContext(),
                mUserMessage.getBackgroundColor());
        int textColor = ContextCompat.getColor(getContext(),
                mUserMessage.getTextColor());
        String message = mUserMessage.getMessage();

        setBackgroundColor(bgColor);
        setTextColor(textColor);
        setText(message);

        show();
    }

    private void show() {
        mAnimator = animate();
        setAlpha(1);
        mIsShowing = true;

        mAnimator.setDuration(mShowDuration)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dismiss();
                            }
                        }, mUserMessage.getDuration());
                    }
                });

        if (mUserMessage.getShowInterpolator() != null) {
            mAnimator.setInterpolator(mUserMessage.getShowInterpolator());
        }

        mAnimator.start();
    }

    private void dismiss() {
        mAnimator = animate();

        mAnimator.setDuration(mDismissDuration)
                .translationY(-mHeight)
                .alpha(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mIsShowing = false;
                        resetView();
                    }
                });

        if (mUserMessage.getDismissInterpolator() != null) {
            mAnimator.setInterpolator(mUserMessage.getDismissInterpolator());
        }

        mAnimator.start();
    }

    private void fastDismiss() {
        if (isShowing()) {
            if (mAnimator != null) {
                mAnimator.cancel();
            }

            mIsShowing = false;
            setTranslationY(-mHeight);
            setAlpha(0);
            resetView();
        }
    }

    private boolean isShowing() {
        return mIsShowing;
    }

    private void resetView() {
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorSuccess));
        setTextColor(ContextCompat.getColor(getContext(), R.color.colorTextRegular));
        setText("");
    }
}