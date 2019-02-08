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
import io.testproject.proxy.addon.net.petrikainulainen.testproject.addon.BlogSearchResultFinderAction;
import io.testproject.proxy.addon.net.petrikainulainen.testproject.addon.ClearBlogSearchFieldAction;

/**
 * This test ensures that the search result page has at least one
 * search result.
 */
@Test(
        name = "The search result page must have at least one search result",
        description = "Verifies that the search result page has at least one search result"
)
public class BlogSearchResultCountTest implements WebTest {

    @Parameter(description = "Contains the url of the search page")
    private String searchPageUrl;

    @Parameter(description = "Contains the submitted search term")
    private String searchTerm;

    @Override
    public ExecutionResult execute(WebTestHelper webTestHelper) throws FailureException {
        WebDriver browser = webTestHelper.getDriver();
        browser.get(searchPageUrl);

        ActionRunner actionRunner = new ActionRunner(webTestHelper);

        ClearBlogSearchFieldAction clearSearchField = BlogSearchAddon.getClearBlogSearchFieldAction();
        actionRunner.runAction(clearSearchField);

        BlogSearchAction blogSearch = BlogSearchAddon.blogSearchAction(searchTerm);
        actionRunner.runAction(blogSearch);

        BlogSearchResultFinderAction searchResults = BlogSearchAddon.getBlogSearchResultFinderAction();
        actionRunner.runAction(searchResults);

        return searchResults.actualSearchResultCount > 0 ? ExecutionResult.PASSED : ExecutionResult.FAILED;
    }
}
