package naywiz.runner;

import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.time.Duration;

public class CommonDriver {

    private int pageLoadTimeout;
    private int elementDetectionTimeout;

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public CommonDriver(String webPlatform, String browserType) throws RuntimeException, MalformedURLException {
        pageLoadTimeout = 10;
        elementDetectionTimeout = 10;

        //calling web driver factory to create browser
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        webDriver.set(webDriverFactory.getDriver(browserType));
        webDriver.get().manage().window().maximize();
        webDriver.get().manage().deleteAllCookies();
    }


    public Driver getDriver() {
        return new Driver(webDriver.get());
    }

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public void setElementDetectionTimeout(int elementDetectionTimeout) {
        this.elementDetectionTimeout = elementDetectionTimeout;
    }

    public void navigateToUrl(String url) {
        webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));
        webDriver.get().get(url);
    }

    public void quit() {
        System.out.println("quitting the driver instance");
        webDriver.get().quit();
        webDriver.remove();
    }
}
