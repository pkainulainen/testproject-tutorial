package net.petrikainulainen.testproject.test;

import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import org.openqa.selenium.WebDriver;

/**
 * This is just a placeholder that does nothing interesting.
 * This test exists only so that we can check that the created
 * jar file contains our test case.
 */
public class WebSiteTitleTest implements WebTest {

    @Override
    public ExecutionResult execute(WebTestHelper webTestHelper) throws FailureException {
        return ExecutionResult.PASSED;
    }
}
