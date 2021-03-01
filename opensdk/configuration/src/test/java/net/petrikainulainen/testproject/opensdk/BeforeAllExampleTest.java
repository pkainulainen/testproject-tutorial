package net.petrikainulainen.testproject.opensdk;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * This example demonstrates how you can ensure that every
 * test method of your test class use the same driver object.
 */
class BeforeAllExampleTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void configureTestProjectOpenSDK() {
        driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withCapabilities(new ChromeOptions())
                .build(ChromeDriver.class);
    }

    @Test
    void openReddit() {
        driver.get("https://www.reddit.com");
    }

    @Test
    void openHN() {
        driver.get("https://news.ycombinator.com/");
    }

    @AfterAll
    static void shutdownTestProjectOpenSDK() {
        driver.quit();
    }
}
