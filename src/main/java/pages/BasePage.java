package pages;

import configuration.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Slf4j
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    private EventFiringMouse eventFiringMouse;
    private WebListener webListener = new WebListener();

    public BasePage(WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(driver, this);
    }

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("web_element_timeout"))));
        actions = new Actions(driver);
    }

    public void clickOnButton(WebElement webElement) {
        String webElementText = webElement.getText();
        waitForElementToBeClickable(webElement);
        webElement.click();
        log.info("Element " + webElement + " has been clicked.");
    }

    public void waitForElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        log.info("Waiting for " + webElement.getText() + " to be clickable.");
    }

    public void waitForElementToBeVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        log.info("Waiting for " + webElement.getText() + " to be visible.");
    }

    public void mouseHover(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) webElement;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
        log.info(webElement + " has been moved.");
    }

    public void mouseClick(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) webElement;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.click(coordinates);
        log.info(webElement + " has been clicked.");
    }
    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
        log.info("Typing " + text);
    }

    public <T> T getRandomElement(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
