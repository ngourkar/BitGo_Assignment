package naywiz.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.function.Supplier;

public class WebDriverFactory {

    private final HashMap<String, Supplier<WebDriver>> browserReference = new HashMap<>();

    public WebDriverFactory() {
        browserReference.put("chrome", this::createChromeDriver);
        browserReference.put("firefox", this::createFirefoxDriver);
        browserReference.put("edge", this::createEdgeDriver);
    }

    public WebDriver getDriver(String browserType) {
        return browserReference.getOrDefault(browserType.toLowerCase().trim(), () -> {
            System.out.println("The browser type is not mentioned");
            throw new RuntimeException("Browser type does not exist");
        }).get();
    }

    private WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    private WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

}
