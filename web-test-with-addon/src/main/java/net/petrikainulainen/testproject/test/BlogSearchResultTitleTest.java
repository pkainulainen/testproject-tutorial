package net.petrikainulainen.testproject.test;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import io.testproject.proxy.addon.BlogSearchAddon;
import io.testproject.proxy.addon.net.petrikainulainen.testproject.addon.BlogSearchAction;
import io.testproject.proxy.addon.net.petrikainulainen.testproject.addon.ClearBlogSearchFieldAction;

/**
 * This test ensures that the search result page has the correct title.
 */
@Test(
        name = "The search result page should display the correct title",
        description = "Verifies that the search result page displays the correct title"
)
public class BlogSearchResultTitleTest implements WebTest {

    @Parameter(description = "Contains the url of the search page")
    private String searchPageUrl;

    @Parameter(description = "Contains the submitted search term")
    private String searchTerm;

    @Parameter(description = "Contains the expected title of the search result page")
    private String expectedSearchResultPageTitle;

    @Override
    public ExecutionResult execute(WebTestHelper webTestHelper) throws FailureException {
        WebDriver browser = webTestHelper.getDriver();
        browser.get(searchPageUrl);

        ActionRunner actionRunner = new ActionRunner(webTestHelper);

        ClearBlogSearchFieldAction clearSearchField = BlogSearchAddon.getClearBlogSearchFieldAction();
        actionRunner.runAction(clearSearchField);

        BlogSearchAction blogSearch = BlogSearchAddon.blogSearchAction(searchTerm);
        actionRunner.runAction(blogSearch);

        return browser.getTitle().equals(expectedSearchResultPageTitle) ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}
