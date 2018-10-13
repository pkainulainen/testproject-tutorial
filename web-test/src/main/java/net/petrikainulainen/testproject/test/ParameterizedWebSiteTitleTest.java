package net.petrikainulainen.testproject.test;

import io.testproject.java.annotations.v2.TestParameter;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import org.openqa.selenium.WebDriver;

/**
 * This test class demonstrates how we can write a simple
 * web test which can receive two parameters from the
 * TestProject framework:
 *
 * <ul>
 *     <li>The {@code expectedTitle} parameter contains the expected title of the opened website.</li>
 *     <li>The {@code url} parameter contains the url of the opened website.</li>
 * </ul>
 */
public class ParameterizedWebSiteTitleTest implements WebTest {

    @TestParameter(defaultValue = "Petri Kainulainen — Developing Software With Passion")
    public String expectedTitle;

    @TestParameter(defaultValue = "https://www.petrikainulainen.net")
    public String url;

    @Override
    public ExecutionResult execute(WebTestHelper webTestHelper) throws FailureException {
        WebDriver browser = webTestHelper.getDriver();
        browser.get(url);
        return browser.getTitle().equals(expectedTitle)
                ? ExecutionResult.PASSED
                : ExecutionResult.FAILED;
    }
}
