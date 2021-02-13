package page;

import locator.InstagramLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageObject {
    protected WebDriver driver;
    protected InstagramLocator locator;

    protected String ATTRIBUTE_SOURCE = "src";
    protected String ATTRIBUTE_ARIA_DISABLED = "aria-disabled";

    public PageObject (WebDriver driver) {
        this.driver = driver;
    }

    public void openPageAt (String url) {
        this.driver.manage().window().maximize();
        driver.get(url);
    }

    public void clickElement (By element) {
        driver.findElement(element).click();
    }

    public void clickElementAfterClickable (By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ExpectedCondition<WebElement> elementReady = ExpectedConditions.elementToBeClickable(element);

        wait.until(elementReady).click();
    }

    public List<WebElement> getElements (By elements) {
        return driver.findElements(elements);
    }

    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }

    public List<String> getElementsAttribute (By elements, String attributeName) {
        List<WebElement> foundElements = getElements(elements);
        ArrayList<String> elementsAttribute = new ArrayList<>();

        for(WebElement element : foundElements) {
            elementsAttribute.add(element.getAttribute(attributeName));
        }

        return elementsAttribute;
    }

    public void fillInput (By element, String input) {
        driver.findElement(element).sendKeys(input);
    }

    public void fillInputAfterInteractable (By element, String input) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ExpectedCondition<WebElement> elementReady = ExpectedConditions.elementToBeClickable(element);

        wait.until(elementReady).sendKeys(input);
    }

    public boolean doesElementExist (By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
//            e.printStackTrace();
            return false;
        }
    }

    public String getAttributeFromElement (By element, String attributeName) {
        return driver.findElement(element).getAttribute(attributeName);
    }

    public int getElementsSize (By elements) {
        return driver.findElements(elements).size();
    }

    public void sleepForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
