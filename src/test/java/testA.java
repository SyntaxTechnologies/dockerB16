import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class testA {
    private WebDriver driver;
    private static final String HUB_URL = "http://localhost:4445/wd/hub"; // Adjust if your hub is on a different machine.

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");  // Ensure a node with Chrome is registered with the hub.

        // Create a RemoteWebDriver instance with the hub's URL and the browser capabilities.
        driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // For demonstration, asserting that the title contains "Google"
        Assert.assertTrue(pageTitle.contains("Google"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
