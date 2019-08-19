package net.petrikainulainen.testproject.addon;

import io.testproject.java.sdk.v2.reporters.ActionReporter;

/**
 * This class constructs the reported result string
 * by using the {@link String#format(String, Object...)} method
 * and sends the created string to the TestProject framework.
 */
public class ActionReportHelper {

    private final ActionReporter reporter;

    public ActionReportHelper(ActionReporter reporter) {
        this.reporter = reporter;
    }

    /**
     * Constructs the actual result string by using the {@link String#format(String, Object...)}
     * method and sends the created string to the TestProject framework.
     * @param resultTemplate    The result string template.
     * @param params            The parameters which are used to construct the actual result string.
     */
    public void reportResult(String resultTemplate, Object... params) {
        reporter.result(String.format(resultTemplate, params));
    }
}
