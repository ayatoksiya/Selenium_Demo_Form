package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPopUpPage extends BasePage{
    public ConfirmationPopUpPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationPopUpInfo(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptConfirmationPopUp(){
        driver.switchTo().alert().accept();
    }
}
