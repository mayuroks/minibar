package com.mayurrokade.minibar;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class UserMessageTest {

    private Context mContext;

    @Before
    public void setup() {
        mContext = RuntimeEnvironment.application;
    }

    @Test
    public void interpolator_isNotNull() {
        UserMessage userMessage = new UserMessage.Builder().with(mContext).build();

        assertNotNull(userMessage.getDismissInterpolator());
        assertNotNull(userMessage.getShowInterpolator());
    }

    @Test
    public void message_IsNotNull() {
        UserMessage userMessage = new UserMessage.Builder().with(mContext).build();
        assertNotNull(userMessage.getMessage());
    }
}
