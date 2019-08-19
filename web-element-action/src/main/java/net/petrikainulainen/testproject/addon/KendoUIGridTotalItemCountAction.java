package net.petrikainulainen.testproject.addon;

import io.testproject.java.annotations.v2.Action;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.addons.WebElementAction;
import io.testproject.java.sdk.v2.addons.helpers.WebAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * This action extracts the total item count of a Kendo UI grid and
 * stores the extracted item count in the <code>totalItemCount</code>
 * parameter.
 *
 * Note that this actions works only if the total item count label
 * uses this format: 1 - 20 of 91 items
 */
@Action(name = "Extracts the total item count of a Kendo UI grid")
public class KendoUIGridTotalItemCountAction implements WebElementAction {

    private static final String CSS_CLASS_TOTAL_ITEM_COUNT_LABEL = "k-pager-info";

    @Parameter(description = "Contains the total item count of a Kendo UI grid",
            direction = ParameterDirection.OUTPUT
    )
    private long totalItemCount;

    /**
     * Extracts the total item count from the displayed Kendo UI grid and
     * stores the found item count in the {@code totalItemCount} field.
     *
     * @param webAddonHelper
     * @param webElement        The root element of the Kendo UI grid.
     * @return
     * @throws FailureException
     */
    @Override
    public ExecutionResult execute(WebAddonHelper webAddonHelper, WebElement webElement) throws FailureException {
        ActionReportHelper reporter = new ActionReportHelper(webAddonHelper.getReporter());

        WebElement totalItemCountLabel = webElement.findElement(By.className(CSS_CLASS_TOTAL_ITEM_COUNT_LABEL));
        if (totalItemCountLabel == null) {
            reporter.reportResult("The total item count label wasn't found with the CSS class: %s",
                    CSS_CLASS_TOTAL_ITEM_COUNT_LABEL
            );
            return ExecutionResult.FAILED;
        }

        Optional<Long> totalItemCount = parseTotalItemCount(totalItemCountLabel.getText());
        if (!totalItemCount.isPresent()) {
            reporter.reportResult("Couldn't parse the total item count from the text: %s",
                    totalItemCountLabel.getText()
            );
            return ExecutionResult.FAILED;
        }

        this.totalItemCount = totalItemCount.get();
        reporter.reportResult("The total item count is: %d", this.totalItemCount);

        return ExecutionResult.PASSED;
    }

    private Optional<Long> parseTotalItemCount(String totalItemCountLabel) {
        String[] labelParts = totalItemCountLabel.split("of");

        if (labelParts.length != 2) {
            return Optional.empty();
        }

        String totalItemCount = labelParts[1].replace("items", "").trim();
        return Optional.of(Long.valueOf(totalItemCount));
    }
}
