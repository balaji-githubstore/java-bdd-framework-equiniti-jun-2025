package com.eq.base;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * WebDriverKeyword - Added some simple keywords for automation. Please add additional keywords if required
 */
public class WebDriverKeywords {

	private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor jsExecutor;
    
    public WebDriverKeywords(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }
    

    // ==================================================
    // BROWSER ACTIONS
    // ==================================================
    
    public void navigateToUrl(String url) {
        try {
            driver.get(url);
            LoggerUtils.info("Navigated to URL: " + url);
        } catch (Exception e) {
            LoggerUtils.error("Failed to navigate to URL: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void refreshPage() {
        try {
            driver.navigate().refresh();
            LoggerUtils.info("Page refreshed");
        } catch (Exception e) {
            LoggerUtils.error("Failed to refresh page: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void navigateBack() {
        try {
            driver.navigate().back();
            LoggerUtils.info("Navigated back");
        } catch (Exception e) {
            LoggerUtils.error("Failed to navigate back: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void navigateForward() {
        try {
            driver.navigate().forward();
            LoggerUtils.info("Navigated forward");
        } catch (Exception e) {
            LoggerUtils.error("Failed to navigate forward: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // ELEMENT LOCATION METHODS
    // ==================================================
    
    public WebElement findElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            LoggerUtils.info("Element found: " + locator.toString());
            return element;
        } catch (Exception e) {
            LoggerUtils.error("Element not found: " + locator.toString());
            throw new RuntimeException(e);
        }
    }
    
    public List<WebElement> findElements(By locator) {
        try {
            List<WebElement> elements = driver.findElements(locator);
            LoggerUtils.info("Found " + elements.size() + " elements: " + locator.toString());
            return elements;
        } catch (Exception e) {
            LoggerUtils.error("Elements not found: " + locator.toString());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // ELEMENT INTERACTION METHODS
    // ==================================================
    
    public void clickElement(By locator) {
        try {
            WebElement element = findElement(locator);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            LoggerUtils.info("Clicked element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to click element: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void doubleClickElement(By locator) {
        try {
            WebElement element = findElement(locator);
            actions.doubleClick(element).perform();
            LoggerUtils.info("Double clicked element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to double click element: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void rightClickElement(By locator) {
        try {
            WebElement element = findElement(locator);
            actions.contextClick(element).perform();
            LoggerUtils.info("Right clicked element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to right click element: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void enterText(By locator, String text) {
        try {
            WebElement element = findElement(locator);
            element.clear();
            element.sendKeys(text);
            LoggerUtils.info("Entered text '" + text + "' in element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to enter text: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void clearText(By locator) {
        try {
            WebElement element = findElement(locator);
            element.clear();
            LoggerUtils.info("Cleared text from element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to clear text: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void pressKey(By locator, String key) {
        try {
            WebElement element = findElement(locator);
            Keys keyToPress = Keys.valueOf(key.toUpperCase());
            element.sendKeys(keyToPress);
            LoggerUtils.info("Pressed key '" + key + "' on element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to press key: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // DROPDOWN/SELECT METHODS
    // ==================================================
    
    public void selectDropdownByValue(By locator, String value) {
        try {
            WebElement element = findElement(locator);
            Select select = new Select(element);
            select.selectByValue(value);
            LoggerUtils.info("Selected dropdown by value '" + value + "': " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to select dropdown by value: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void selectDropdownByText(By locator, String text) {
        try {
            WebElement element = findElement(locator);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            LoggerUtils.info("Selected dropdown by text '" + text + "': " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to select dropdown by text: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void selectDropdownByIndex(By locator, int index) {
        try {
            WebElement element = findElement(locator);
            Select select = new Select(element);
            select.selectByIndex(index);
            LoggerUtils.info("Selected dropdown by index " + index + ": " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to select dropdown by index: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // VERIFICATION METHODS
    // ==================================================
    
    public boolean isElementPresent(By locator) {
        try {
            findElement(locator);
            LoggerUtils.info("Element is present: " + locator.toString());
            return true;
        } catch (Exception e) {
            LoggerUtils.info("Element is not present: " + locator.toString());
            return false;
        }
    }
    
    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = findElement(locator);
            boolean isDisplayed = element.isDisplayed();
            LoggerUtils.info("Element displayed status: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerUtils.info("Element is not displayed: " + locator.toString());
            return false;
        }
    }
    
    public boolean isElementEnabled(By locator) {
        try {
            WebElement element = findElement(locator);
            boolean isEnabled = element.isEnabled();
            LoggerUtils.info("Element enabled status: " + isEnabled);
            return isEnabled;
        } catch (Exception e) {
            LoggerUtils.error("Failed to check if element is enabled: " + e.getMessage());
            return false;
        }
    }
    
    public boolean isElementSelected(By locator) {
        try {
            WebElement element = findElement(locator);
            boolean isSelected = element.isSelected();
            LoggerUtils.info("Element selected status: " + isSelected);
            return isSelected;
        } catch (Exception e) {
            LoggerUtils.error("Failed to check if element is selected: " + e.getMessage());
            return false;
        }
    }
    
    // ==================================================
    // TEXT AND ATTRIBUTE METHODS
    // ==================================================
    
    public String getElementText(By locator) {
        try {
            WebElement element = findElement(locator);
            String text = element.getText();
            LoggerUtils.info("Element text: " + text);
            return text;
        } catch (Exception e) {
            LoggerUtils.error("Failed to get element text: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public String getElementAttribute(By locator, String attributeName) {
        try {
            WebElement element = findElement(locator);
            String attributeValue = element.getAttribute(attributeName);
            LoggerUtils.info("Element attribute '" + attributeName + "': " + attributeValue);
            return attributeValue;
        } catch (Exception e) {
            LoggerUtils.error("Failed to get element attribute: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public String getPageTitle() {
        try {
            String title = driver.getTitle();
            LoggerUtils.info("Page title: " + title);
            return title;
        } catch (Exception e) {
            LoggerUtils.error("Failed to get page title: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public String getCurrentUrl() {
        try {
            String url = driver.getCurrentUrl();
            LoggerUtils.info("Current URL: " + url);
            return url;
        } catch (Exception e) {
            LoggerUtils.error("Failed to get current URL: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // WAIT METHODS
    // ==================================================
    
    public void waitForElementToBeVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            LoggerUtils.info("Element is now visible: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Element did not become visible: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void waitForElementToBeClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            LoggerUtils.info("Element is now clickable: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Element did not become clickable: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void waitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            LoggerUtils.info("Element disappeared: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Element did not disappear: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            LoggerUtils.info("Waited for " + seconds + " seconds");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LoggerUtils.error("Wait interrupted: " + e.getMessage());
        }
    }
    
    // ==================================================
    // WINDOW/FRAME METHODS
    // ==================================================
    
    public void switchToWindow(String windowHandle) {
        try {
            driver.switchTo().window(windowHandle);
            LoggerUtils.info("Switched to window: " + windowHandle);
        } catch (Exception e) {
            LoggerUtils.error("Failed to switch to window: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void switchToNewWindow() {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                driver.switchTo().window(handle);
            }
            LoggerUtils.info("Switched to new window");
        } catch (Exception e) {
            LoggerUtils.error("Failed to switch to new window: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void switchToFrame(By frameLocator) {
        try {
            WebElement frame = findElement(frameLocator);
            driver.switchTo().frame(frame);
            LoggerUtils.info("Switched to frame: " + frameLocator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to switch to frame: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
            LoggerUtils.info("Switched to default content");
        } catch (Exception e) {
            LoggerUtils.error("Failed to switch to default content: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // ALERT METHODS
    // ==================================================
    
    public void acceptAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            LoggerUtils.info("Alert accepted");
        } catch (Exception e) {
            LoggerUtils.error("Failed to accept alert: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void dismissAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.dismiss();
            LoggerUtils.info("Alert dismissed");
        } catch (Exception e) {
            LoggerUtils.error("Failed to dismiss alert: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public String getAlertText() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            LoggerUtils.info("Alert text: " + alertText);
            return alertText;
        } catch (Exception e) {
            LoggerUtils.error("Failed to get alert text: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // JAVASCRIPT METHODS
    // ==================================================
    
    public void scrollToElement(By locator) {
        try {
            WebElement element = findElement(locator);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            LoggerUtils.info("Scrolled to element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to scroll to element: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void clickElementUsingJS(By locator) {
        try {
            WebElement element = findElement(locator);
            jsExecutor.executeScript("arguments[0].click();", element);
            LoggerUtils.info("Clicked element using JavaScript: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to click element using JavaScript: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void highlightElement(By locator) {
        try {
            WebElement element = findElement(locator);
            jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
            LoggerUtils.info("Highlighted element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to highlight element: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    // ==================================================
    // MOUSE ACTIONS
    // ==================================================
    
    public void hoverOverElement(By locator) {
        try {
            WebElement element = findElement(locator);
            actions.moveToElement(element).perform();
            LoggerUtils.info("Hovered over element: " + locator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to hover over element: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        try {
            WebElement sourceElement = findElement(sourceLocator);
            WebElement targetElement = findElement(targetLocator);
            actions.dragAndDrop(sourceElement, targetElement).perform();
            LoggerUtils.info("Dragged and dropped element from " + sourceLocator.toString() + " to " + targetLocator.toString());
        } catch (Exception e) {
            LoggerUtils.error("Failed to drag and drop: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}


