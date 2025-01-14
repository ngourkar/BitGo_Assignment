package naywiz.runner;

import org.openqa.selenium.*;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class Driver {

    WebDriver driver;

    public Driver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clearElement(WebElement element) {
        element.clear();
    }

    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void selectViaVisibleText(WebElement element, String text) {
        Select selectDropDown = new Select(element);
        selectDropDown.selectByVisibleText(text);
    }

    public WebElement getElementFromLocator(By locator) {
        return driver.findElement(locator);
    }

    public void captureScreenshot(String filePath) {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenShot, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
