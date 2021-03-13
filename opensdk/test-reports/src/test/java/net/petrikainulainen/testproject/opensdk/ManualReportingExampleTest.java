package net.petrikainulainen.testproject.opensdk;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrates how can replace automatic reporting
 * with manual reporting when you are writing tests for a web
 * application with TestProject OpenSDK and JUnit 5.
 */
@DisplayName("Manual: search blog posts")
class ManualReportingExampleTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void configureTestProjectOpenSDK() {
        driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withCapabilities(new ChromeOptions())
                .withProjectName("TestProject OpenSDK Tutorial")
                .build(ChromeDriver.class);

        driver.report().disableTestAutoReports(true);
        driver.report().disableCommandReports(true);
    }

    @Nested
    @DisplayName("When no search results are found")
    class WhenNoSearchResultsAreFound {

        @Test
        @DisplayName("Should display an empty search result page")
        void shouldDisplayEmptySearchResultPage() {
            driver.get("https://www.petrikainulainen.net/blog/");
            driver.report().step("Open the page: https://www.petrikainulainen.net/blog/");

            WebElement searchField = driver.findElement(By.id("s"));
            driver.report().step("Find the search form from the sidebar");

            searchField.sendKeys("pascal");
            searchField.sendKeys(Keys.ENTER);
            driver.report().step("Perform the search by using the search term: pascal");

            WebElement noResultElement = driver.findElement(By.cssSelector(".template-search .content .post_box .archive_content"));
            assertThat(noResultElement.getText()).isEqualTo("No results found.");
            driver.report().step("Ensure that the search result page displays the text: No results found.");

            driver.report().test("No search results: should display an empty search result page", true).submit();
        }
    }

    @Nested
    @DisplayName("When one search result is found")
    class WhenOneSearchResultIsFound {

        @Test
        @DisplayName("Should display search result page that has one search result")
        void shouldDisplaySearchResultPageWithOneSearchResult() {
            driver.get("https://www.petrikainulainen.net/blog/");
            driver.report().step("Open the page: https://www.petrikainulainen.net/blog/");

            WebElement searchField = driver.findElement(By.id("s"));
            driver.report().step("Find the search form from the sidebar");

            searchField.sendKeys("clojure");
            searchField.sendKeys(Keys.ENTER);
            driver.report().step("Perform the search by using the search term: clojure");

            List<WebElement> searchResults = driver.findElements(By.tagName("article"));
            driver.report().step("Find the search results from the search result page");

            assertThat(searchResults).hasSize(1);
            driver.report().step("Ensure that the search result page displays one search result");

            driver.report().test("One search result: should display search result page that has one search result", true).submit();
        }

        @Test
        @DisplayName("Should display search result page that has the correct search result")
        void shouldDisplaySearchResultPageWithCorrectSearchResult() {
            driver.get("https://www.petrikainulainen.net/blog/");
            driver.report().step("Open the page: https://www.petrikainulainen.net/blog/");

            WebElement searchField = driver.findElement(By.id("s"));
            driver.report().step("Find the search form from the sidebar");

            searchField.sendKeys("clojure");
            searchField.sendKeys(Keys.ENTER);
            driver.report().step("Perform the search by using the search term: clojure");

            WebElement searchResult = driver.findElement(By.tagName("article"));
            driver.report().step("Find the only search result from the search result page");

            WebElement resultTitle = searchResult.findElement(By.className("headline"));
            driver.report().step("Find the title of the search result");

            assertThat(resultTitle.getText()).isEqualTo("Java Testing Weekly 22 / 2018");
            driver.report().step("Ensure that the found search result has the correct title");

            driver.report().test("One search result: should display search result page that has the correct search result", true).submit();
        }
    }

    @AfterAll
    static void shutdownTestProjectOpenSDK() {
        driver.quit();
    }
}
