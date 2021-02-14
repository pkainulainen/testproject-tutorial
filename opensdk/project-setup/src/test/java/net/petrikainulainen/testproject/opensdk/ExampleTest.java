package net.petrikainulainen.testproject.opensdk;

import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

class ExampleTest {

    @Test
    @DisplayName("test example")
    void testExample() throws InvalidTokenException, AgentConnectException, ObsoleteVersionException, IOException {
        ChromeDriver driver = new ChromeDriver(new ChromeOptions());
    }
}
