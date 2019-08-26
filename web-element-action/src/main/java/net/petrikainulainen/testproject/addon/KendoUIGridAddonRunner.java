package net.petrikainulainen.testproject.addon;

import io.testproject.java.enums.AutomatedBrowserType;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import net.petrikainulainen.testproject.addon.KendoUIGridTotalItemCountAction;
import org.openqa.selenium.By;

/**
 * This runner class can run new {@link KendoUIGridTotalItemCountAction} objects.
 * Note that using is a runner class is the recommended way to debug
 * and test web element actions during the development phase.
 */
public class KendoUIGridAddonRunner {

    private static final AutomatedBrowserType BROWSER_TYPE = AutomatedBrowserType.Chrome;
    private static final String DEVELOPER_KEY = "PUT_YOUR_TEST_PROJECT_DEVELOPER_KEY_HERE";
    private static final String KENDO_UI_GRID_DEMO_PAGE_URL = "https://demos.telerik.com/kendo-ui/grid/index";
    private static final String KENDO_UI_GRID_ID = "grid";

    public static void main(String[] args) throws Exception {
        Runner runner = Runner.createWeb(DEVELOPER_KEY, BROWSER_TYPE);

        KendoUIGridTotalItemCountAction totalItemCount = new KendoUIGridTotalItemCountAction();

        WebDriver driver = runner.getDriver();
        driver.get(KENDO_UI_GRID_DEMO_PAGE_URL);

        runner.run(totalItemCount, By.id(KENDO_UI_GRID_ID));
    }
}
