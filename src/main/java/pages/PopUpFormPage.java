package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PopUpFormPage extends BasePage{
    public PopUpFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#createDinnerName-awed")
    private WebElement nameInputField;

    @FindBy(css = "#createDinner > div > form > div:nth-child(3) > div.einput > div > div > button")
    private WebElement chefSelectionButton;

    @FindBy(css = "#createDinnerChefId-awepw > div > div.awe-list.awe-srlcont > ul > li")
    private List<WebElement> chefsList;

    public PopUpFormPage provideName(String name){
        waitForElementToBeVisible(nameInputField);
        sendKeys(nameInputField,name);
        return this;
    }

    public PopUpFormPage selectChef(){
        waitForElementToBeVisible(chefSelectionButton);
        clickOnButton(chefSelectionButton);
        WebElement chefsName = getRandomElement(chefsList);
        waitForElementToBeClickable(chefsName);
        clickOnButton(chefsName);
        return this;
    }
}
