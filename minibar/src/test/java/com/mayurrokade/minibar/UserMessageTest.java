package com.mayurrokade.minibar;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserMessageTest {

    @Test
    public void userMessageInterpolator_isNotNull() {
        assertEquals(4, 2 + 2);
        UserMessage userMessage = new UserMessage.Builder().build();

        assertNotNull(userMessage.getDismissInterpolator());
        assertNotNull(userMessage.getShowInterpolator());
    }
}
