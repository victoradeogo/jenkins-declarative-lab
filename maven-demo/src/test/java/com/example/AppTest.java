package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testGetGreeting() {
        App app = new App();

        String result = app.getGreeting();
    assertEquals("Hello from Maven and Jenkins!", result);
    }
}
