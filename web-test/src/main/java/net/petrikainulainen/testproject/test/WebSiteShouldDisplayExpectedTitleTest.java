package net.petrikainulainen.testproject.test;

import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import org.openqa.selenium.WebDriver;

/**
 * This test class demonstrates how we can write a simple
 * web test that doesn't require any parameters from the
 * TestProject framework.
 */
public class WebSiteShouldDisplayExpectedTitleTest implements WebTest {

    @Override
    public ExecutionResult execute(WebTestHelper webTestHelper) throws FailureException {
        WebDriver browser = webTestHelper.getDriver();
        browser.get("https://www.petrikainulainen.net");
        return browser.getTitle().equals("Petri Kainulainen — Developing Software With Passion")
                ? ExecutionResult.PASSED
                : ExecutionResult.FAILED;
    }
}
