package net.petrikainulainen.testproject.opensdk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * A page object that's used to interact with the search result page.
 */
public class SearchResultPage {

    private static final String CSS_SELECTOR_SEARCH_RESULTS = ".template-search .content .post_box .archive_content";
    private static final String HTML_ELEMENT_CLASS_SEARCH_RESULT_TITLE = "headline";
    private static final String HTML_ELEMENT_TAG_SEARCH_RESULT = "article";

    private final WebDriver webDriver;

    SearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Finds the text that's shown when no search results are found
     * and returns the found text.
     * @return
     */
    public String findNoSearchResultsText() {
        WebElement noSearchResultsElement = webDriver.findElement(By.cssSelector(CSS_SELECTOR_SEARCH_RESULTS));
        return noSearchResultsElement.getText();
    }

    /**
     * Finds the search results shown on the search result page
     * and returns the found search results.
     * @return
     */
    public List<BlogPost> findSearchResults() {
        List<BlogPost> searchResults = new ArrayList<>();

        List<WebElement> searchResultElements = webDriver.findElements(By.tagName(HTML_ELEMENT_TAG_SEARCH_RESULT));
        for (WebElement currentElement: searchResultElements) {
            WebElement searchResultTitle = currentElement.findElement(By.className(HTML_ELEMENT_CLASS_SEARCH_RESULT_TITLE));
            BlogPost searchResult = new BlogPost(searchResultTitle.getText());
            searchResults.add(searchResult);
        }

        return searchResults;
    }
}
