package uitests;

import org.arquillian.cube.CubeIp;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class SampleUITest {

    final int PORT = 8080;

    @Drone
    WebDriver webDriver;

    @CubeIp(containerName = "test*")
    String ip;

    @Test
    public void checkBodyBackgroundColor() throws MalformedURLException {
        URL url = new URL("http", ip, PORT, "/sample");
        webDriver.get(url.toString());

        String bgColor = webDriver.findElement(By.tagName("body")).getAttribute("bgcolor");
        assertEquals("blue", bgColor);
    }

    @Test
    public void checkBodyText() throws MalformedURLException {
        URL url = new URL("http", ip, PORT, "/sample");
        webDriver.get(url.toString());

        String h2Text = webDriver.findElement(By.tagName("body")).findElement(By.tagName("h2")).getText();
        assertEquals("Hello World!", h2Text);
    }
}