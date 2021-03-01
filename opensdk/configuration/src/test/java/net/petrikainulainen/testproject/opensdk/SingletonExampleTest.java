package net.petrikainulainen.testproject.opensdk;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This example demonstrates how you can ensure that
 * all test methods of your test suite uses the same
 * driver object.
 */
public class SingletonExampleTest {

    @Test
    void openReddit() {
        TestDriver.INSTANCE.get("https://www.reddit.com");
    }

    @Test
    void openHN() {
        TestDriver.INSTANCE.get("https://news.ycombinator.com/");
    }
}
