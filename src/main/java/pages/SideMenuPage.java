package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenuPage extends BasePage{
    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a:nth-child(45)")
    private WebElement popUpFormButton;

    public void goToPopUpForm(){
        waitForElementToBeVisible(popUpFormButton);
        clickOnButton(popUpFormButton);
    }
}
