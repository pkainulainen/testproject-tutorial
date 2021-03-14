package net.petrikainulainen.testproject.opensdk.pages;

/**
 * Contains the information of a search result that's
 * shown on the search result page.
 */
public class BlogPost {

    private final String title;

    public BlogPost(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
