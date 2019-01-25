package net.petrikainulainen.testproject.addon;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.annotations.v2.ActionParameter;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.addons.WebAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This action finds the number of search results displayed
 * on the search results page of my blog.
 *
 * Note that this action assumes that the search
 * result page is open.
 */
@Action(name = "Finds the number of search results")
public class BlogSearchResultFinderAction implements WebAction {

    @ActionParameter(direction = ParameterDirection.OUTPUT)
    private long searchResultCount;

    @Override
    public ExecutionResult execute(WebAddonHelper webAddonHelper) {
        WebDriver browser = webAddonHelper.getDriver();

        List<WebElement> searchResults = browser.findElements(By.cssSelector(".template-search .content .post_box"));
        searchResultCount = searchResults.size();

        return ExecutionResult.PASSED;
    }
}
