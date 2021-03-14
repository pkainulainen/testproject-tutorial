package net.petrikainulainen.testproject.opensdk.pages;

/**
 * Builds url addresses which can be used for sending
 * HTTP requests to the system under test.
 */
public final class WebDriverUrlBuilder {

    private WebDriverUrlBuilder() {}

    /**
     * Builds an url address and returns the created url.
     * @param path      The path component. The path component can contain
     *                  parameters as long as you use the format supported by
     *                  the {@link String#format(String, Object...)} method.
     * @param params    The parameter values.
     * @return
     * @throws NullPointerException If the path is null.
     */
    public static String buildFromPath(String path, Object... params) {
        if (path == null) {
            throw new NullPointerException("Path must be given.");
        }

        path = String.format(path, params);

        String baseUrl = WebDriverEnvironment.getBaseUrl();
        if (!baseUrl.endsWith("/")) {
            baseUrl += "/";
        }

        if (path.startsWith("/")) {
            path = path.replaceFirst("/", "");
        }

        return baseUrl + path;
    }
}


