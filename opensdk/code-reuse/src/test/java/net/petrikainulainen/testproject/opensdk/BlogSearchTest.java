package net.petrikainulainen.testproject.opensdk;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import net.petrikainulainen.testproject.opensdk.pages.BlogPost;
import net.petrikainulainen.testproject.opensdk.pages.SearchPage;
import net.petrikainulainen.testproject.opensdk.pages.SearchResultPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrates how you can leverage page objects
 * when you write tests for a web application with TestProject
 * OpenSDK and JUnit 5.
 */
@DisplayName("Search blog posts")
class BlogSearchTest {

    private static ChromeDriver driver;
    private SearchPage searchPage;

    @BeforeAll
    static void configureTestProjectOpenSDK() {
        driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withCapabilities(new ChromeOptions())
                .withProjectName("TestProject OpenSDK Tutorial")
                .build(ChromeDriver.class);
    }

    @BeforeEach
    void openSearchPage() {
        searchPage = new SearchPage(driver).open();
    }

    @Nested
    @DisplayName("When no search results are found")
    class WhenNoSearchResultsAreFound {

        @Test
        @DisplayName("Should display an empty search result page when no search results are found")
        void shouldDisplayEmptySearchResultPage() {
            SearchResultPage searchResultPage = searchPage.submitSearchForm("pascal");

            String noSearchResultsText = searchResultPage.findNoSearchResultsText();
            assertThat(noSearchResultsText).isEqualTo("No results found.");
        }
    }

    @Nested
    @DisplayName("When one search result is found")
    class WhenOneSearchResultIsFound {

        @Test
        @DisplayName("Should display search result page that has one search result when one search result is found")
        void shouldDisplaySearchResultPageWithOneSearchResult() {
            SearchResultPage searchResultPage = searchPage.submitSearchForm("clojure");

            List<BlogPost> searchResults = searchResultPage.findSearchResults();
            assertThat(searchResults).hasSize(1);
        }

        @Test
        @DisplayName("Should display search result page that has the correct search result when one search result is found")
        void shouldDisplaySearchResultPageWithCorrectSearchResult() {
            SearchResultPage searchResultPage = searchPage.submitSearchForm("clojure");

            BlogPost searchResult = searchResultPage.findSearchResults().get(0);
            assertThat(searchResult.getTitle()).isEqualTo("Java Testing Weekly 22 / 2018");
        }
    }

    @AfterAll
    static void shutdownTestProjectOpenSDK() {
        driver.quit();
    }
}
