package testBase;

import configuration.AppProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import providers.DriverFactory;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class TestBase {
    protected static WebDriver driver;
    protected static AppProperties appProperties;
    protected static DriverFactory driverFactory;

    @BeforeAll
    static void setup() {
        appProperties = AppProperties.getInstance();
        log.info("AppProperties have been initialized properly.");
        driverFactory = new DriverFactory();
    }

    @BeforeEach
    void setupDriver() {
        driver = driverFactory.getDriver();
        log.debug("WebDriver initialized properly");
        driver.get(System.getProperty("app_url"));
        log.info("Url: " + System.getProperty("app_url"));
    }

    @AfterEach
    void teardown() {
        driver.quit();
        log.info("Driver has been closed.");
    }
    @SneakyThrows
    public <T extends BasePage> T at(Class<T> pageType){
        log.info("Creating PageObject: " + pageType.getName());
        return pageType.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }
}
