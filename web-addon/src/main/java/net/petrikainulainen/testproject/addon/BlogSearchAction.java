package net.petrikainulainen.testproject.addon;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.annotations.v2.ActionParameter;
import io.testproject.java.sdk.v2.addons.WebAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This action enters the specified search term to the
 * search form found from my blog and submits the search
 * form.
 *
 * Note that this action assumes that our test
 * has navigated to the page that display the search
 * form.
 */
@Action(name = "Enter the search term and submit the search form")
public class BlogSearchAction implements WebAction {

    @ActionParameter
    private String searchTerm;

    @Override
    public ExecutionResult execute(WebAddonHelper webAddonHelper) {
        WebDriver browser = webAddonHelper.getDriver();

        WebElement searchField = browser.findElement(By.id("s"));
        if (!searchField.isDisplayed()) {
            return ExecutionResult.FAILED;
        }

        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        return ExecutionResult.PASSED;
    }
}
