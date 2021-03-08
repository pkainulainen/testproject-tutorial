package net.petrikainulainen.testproject.opensdk;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrates how you write tests for a web
 * application with TestProject OpenSDK and JUnit 5.
 */
class BlogSearchTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void configureTestProjectOpenSDK() {
        driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withCapabilities(new ChromeOptions())
                .build(ChromeDriver.class);
    }

    @Nested
    class WhenNoSearchResultsIsFound {

        @Test
        void shouldDisplayEmptySearchResultPage() {
            driver.get("https://www.petrikainulainen.net/blog/");

            WebElement searchField = driver.findElement(By.id("s"));
            searchField.sendKeys("pascal");
            searchField.sendKeys(Keys.ENTER);

            WebElement noResultElement = driver.findElement(By.cssSelector(".template-search .content .post_box .archive_content"));
            assertThat(noResultElement.getText()).isEqualTo("No results found.");
        }
    }

    @Nested
    class WhenOneSearchResultIsFound {

        @Test
        void shouldDisplaySearchResultPageWithOneSearchResult() {
            driver.get("https://www.petrikainulainen.net/blog/");

            WebElement searchField = driver.findElement(By.id("s"));
            searchField.sendKeys("clojure");
            searchField.sendKeys(Keys.ENTER);

            List<WebElement> searchResults = driver.findElements(By.tagName("article"));
            assertThat(searchResults).hasSize(1);
        }

        @Test
        void shouldDisplaySearchResultPageWithCorrectSearchResult() {
            driver.get("https://www.petrikainulainen.net/blog/");

            WebElement searchField = driver.findElement(By.id("s"));
            searchField.sendKeys("clojure");
            searchField.sendKeys(Keys.ENTER);

            WebElement searchResult = driver.findElement(By.tagName("article"));
            WebElement resultTitle = searchResult.findElement(By.className("headline"));
            assertThat(resultTitle.getText()).isEqualTo("Java Testing Weekly 22 / 2018");
        }
    }

    @AfterAll
    static void shutdownTestProjectOpenSDK() {
        driver.quit();
    }
}
