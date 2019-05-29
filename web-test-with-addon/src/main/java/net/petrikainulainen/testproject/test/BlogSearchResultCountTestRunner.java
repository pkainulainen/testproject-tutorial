package net.petrikainulainen.testproject.test;

import io.testproject.java.enums.AutomatedBrowserType;
import io.testproject.java.sdk.v2.Runner;

public class BlogSearchResultCountTestRunner {

    private static final AutomatedBrowserType BROWSER_TYPE = AutomatedBrowserType.Chrome;
    private static final String DEVELOPER_KEY = "PUT_YOUR_DEVELOPER_KEY_HERE";

    private static final String SEARCH_PAGE_URL = "https://www.petrikainulainen.net/blog";
    private static final String SEARCH_TERM = "junit 5";

    public static void main(String[] args) throws Exception {
        Runner runner = Runner.createWeb(DEVELOPER_KEY, BROWSER_TYPE);

        BlogSearchResultCountTest test = new BlogSearchResultCountTest();
        test.setSearchPageUrl(SEARCH_PAGE_URL);
        test.setSearchTerm(SEARCH_TERM);

        runner.run(test);
    }
}
