package net.petrikainulainen.testproject.addon;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.sdk.v2.addons.WebElementAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This action clears the search field (<code>WebElement</code> object)
 * that's provided to this action by the TestProject framework.
 */
@Action(name = "Clear the search field of the search form")
public class ClearBlogSearchFieldAction implements WebElementAction {

    @Override
    public ExecutionResult execute(WebAddonHelper webAddonHelper, WebElement webElement) throws FailureException {
        webElement.clear();
        return ExecutionResult.PASSED;
    }
}
