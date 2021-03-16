package net.petrikainulainen.testproject.opensdk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A page object that's used to interact with the search page.
 */
public class SearchPage {

    private static final String HTML_ELEMENT_ID_SEARCH_FIELD = "s";
    private static final String PAGE_PATH = "/blog/";

    private final String pageUrl;
    private final WebDriver webDriver;

    public SearchPage(WebDriver webDriver) {
        this.pageUrl = WebDriverUrlBuilder.buildFromPath(PAGE_PATH);
        this.webDriver = webDriver;
    }

    /**
     * Opens the search page.
     * @return  A page object which allows you to interact with the search page.
     */
    public SearchPage open() {
        webDriver.get(pageUrl);
        return new SearchPage(webDriver);
    }

    /**
     * Finds blog posts by using the specified search term.
     * @param searchTerm    The search term which is entered to the search form.
     * @return  A page object which allows you to interact with the search result page.
     */
    public SearchResultPage findBlogPostsBySearchTerm(String searchTerm) {
        WebElement searchField = webDriver.findElement(By.id(HTML_ELEMENT_ID_SEARCH_FIELD));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(webDriver);
    }
}
