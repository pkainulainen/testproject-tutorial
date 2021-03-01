package net.petrikainulainen.testproject.opensdk;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * This class creates a new driver object which can be shared
 * with all tests of your test suite.
 */
public class TestDriver {

    public static ChromeDriver INSTANCE = new DriverBuilder<ChromeDriver>(new ChromeOptions())
            .withCapabilities(new ChromeOptions())
            .build(ChromeDriver.class);
}
