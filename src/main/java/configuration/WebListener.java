package configuration;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

@Slf4j
public class WebListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info(">>>>>>> EventListener before click.");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info(">>>>>>> EventListener after click.");
    }
}
