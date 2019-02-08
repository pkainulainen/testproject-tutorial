package net.petrikainulainen.testproject.test;

import io.testproject.java.sdk.v2.addons.proxy.ActionProxy;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;

/**
 * Provides a single method that allow us to run TestProject action.
 * The goal of this class is to help us to remove duplicate exception
 * handling code from our test classes.
 */
class ActionRunner {

    private final WebTestHelper webTestHelper;

    /**
     * Configures the created object.
     * @param webTestHelper The {@code WebTestHelper} instance that runs our actions.
     */
    ActionRunner(WebTestHelper webTestHelper) {
        this.webTestHelper = webTestHelper;
    }

    /**
     * Runs the action given as a method parameter.
     * @param proxy The invoked action proxy.
     * @throws FailureException if an exception is thrown when we run our action.
     */
    void runAction(ActionProxy proxy) throws FailureException {
        try {
            ExecutionResult result = webTestHelper.executeProxy(proxy);
            if (result == ExecutionResult.FAILED) {
                throw new FailureException(String.format(
                        "The invocation of the action proxy: %s failed ",
                        proxy.getDescriptor().getClassName()
                ));
            }
        }
        catch (Exception e) {
            throw new FailureException(e.getMessage(), e);
        }
    }
}
