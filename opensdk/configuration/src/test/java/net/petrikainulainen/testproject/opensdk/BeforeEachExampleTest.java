package net.petrikainulainen.testproject.opensdk;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * This example demonstrates how you can ensure that every
 * test method of your test class uses a different
 * driver object.
 */
class BeforeEachExampleTest {

    private ChromeDriver driver;

    @BeforeEach
    void configureTestProjectOpenSDK() {
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

    @AfterEach
    void shutdownTestProjectOpenSDK() {
        driver.quit();
    }
}
