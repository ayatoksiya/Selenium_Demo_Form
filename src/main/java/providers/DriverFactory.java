package providers;

import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

@Slf4j
public class DriverFactory {

    private WebDriver driver;
    private Browsers browsers;

    public WebDriver getDriver() {
        this.browsers = Browsers.valueOf(System.getProperty("browser_name").toUpperCase());
        switch (browsers) {
            case CHROME -> {
                getChromeDriver();
                printBrowserLog(Browsers.CHROME);
            }
            case FIREFOX -> {
                getFirefoxDriver();
                printBrowserLog(Browsers.FIREFOX);
            }
            case IE -> {
                getIEDriver();
                printBrowserLog(Browsers.IE);
            }
            case EDGE -> {
                getEdgeDriver();
                printBrowserLog(Browsers.EDGE);
            }
        }
        return this.driver;
    }

    private void printBrowserLog(Browsers browser) {
        log.info("Selected browser is: " + browser);
    }

    private void getChromeDriver() {
        ChromeOptions optionsChrome = new ChromeOptions().addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(optionsChrome);
    }

    private void getFirefoxDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        optionsFirefox.addArguments("start-maximized");
        driver = new FirefoxDriver(optionsFirefox);
    }

    private void getIEDriver() {
        InternetExplorerOptions optionsIE = new InternetExplorerOptions();
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver(optionsIE);
    }

    private void getEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        edgeOptions.addArguments("start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }
}
