package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpFormMenuPage extends BasePage{
    public PopUpFormMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div:nth-child(6)>button")
    private WebElement createButton;

    public void createPopUpForm(){
        waitForElementToBeVisible(createButton);
        clickOnButton(createButton);
    }
}
