package net.petrikainulainen.testproject.opensdk.pages;

/**
 * A utility class which reads environment specific
 * configuration from JVM system properties.
 */
final class WebDriverEnvironment {

    private WebDriverEnvironment() {}

    /**
     * Reads the the base url of the tested web application from
     * the JVM system property called: <code>webdriver.base.url</code>
     * and returns the found base url.
     * @return
     * @throws RuntimeException If no base url is found.
     */
    static String getBaseUrl() {
        String baseUrl = System.getProperty("webdriver.base.url");
        if (baseUrl == null) {
            throw new RuntimeException("No base url found!");
        }
        return baseUrl;
    }
}
