package net.petrikainulainen.testproject.addon;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.sdk.v2.addons.WebAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This action clears the search form found from
 * the sidebar of my blog.
 *
 * Note that this action expects that our test has
 * navigated to a page that displays the search form.
 * If this is not the case, this action will fail the
 * test.
 */
@Action(name = "Clear the search field of the search form")
public class ClearBlogSearchFieldAction implements WebAction {

    @Override
    public ExecutionResult execute(WebAddonHelper webAddonHelper) throws FailureException {
        WebDriver browser = webAddonHelper.getDriver();

        WebElement searchField = browser.findElement(By.id("s"));
        if (!searchField.isDisplayed()) {
            return ExecutionResult.FAILED;
        }

        searchField.clear();
        return ExecutionResult.PASSED;
    }
}
