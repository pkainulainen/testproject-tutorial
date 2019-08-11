package net.petrikainulainen.testproject.addon;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.sdk.v2.addons.WebElementAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This action enters the specified search term to the
 * search field (<code>WebElement</code> object) that's
 * provided to this action by the TestProject framework,
 * and submits the search form.
 */
@Action(name = "Enter the search term and submit the search form")
public class BlogSearchAction implements WebElementAction {

    @Parameter(description = "Contains the search term that is entered to the search form")
    private String searchTerm;

    @Override
    public ExecutionResult execute(WebAddonHelper webAddonHelper, WebElement webElement) throws FailureException {
        webElement.sendKeys(searchTerm);
        webElement.sendKeys(Keys.ENTER);
        return ExecutionResult.PASSED;
    }
}
