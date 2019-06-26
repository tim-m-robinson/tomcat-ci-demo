package uitests;

import environment.EnvironmentManager;
import environment.RunEnvironment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class SampleTest {

    @Before
    public void startBrowser() {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void checkBodyBackgroundColor() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("http://localhost:8080/sample");
        String bgColor = driver.findElement(By.tagName("body")).getAttribute("bgcolor");
        assertEquals("blue", bgColor);
    }

    @Test
    public void checkBodyText() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("http://localhost:8080/sample");
        String h2Text = driver.findElement(By.tagName("body")).findElement(By.tagName("h2")).getText();
        assertEquals("Hello World!", h2Text);
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}