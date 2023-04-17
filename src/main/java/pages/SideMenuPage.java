package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenuPage extends BasePage{
    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Menu > div.awe-mcontent > div.awe-content.awe-tablc > div > div > a:nth-child(44)")
    private WebElement popUpFormButton;

    public void goToPopUpForm(){
        waitForElementToBeVisible(popUpFormButton);
        clickOnButton(popUpFormButton);
    }
}
