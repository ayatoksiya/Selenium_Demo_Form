package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PopUpFormPage extends BasePage {
    public PopUpFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#createDinnerName-awed")
    private WebElement nameInputField;

    @FindBy(css = ".awe-icon-datepicker")
    private WebElement datepickerButton;

    @FindBy(css = "#createDinnerDatecy-awed")
    private WebElement yearSelectionButton;

    @FindBy(css = "#createDinnerDatecm-awed")
    private WebElement monthSelectionButton;

    @FindBy(css = "#createDinnerDatecy-dropmenu li")
    private List<WebElement> yearSlectionList;

    @FindBy(css = "#createDinnerDatecm-dropmenu li")
    private List<WebElement> monthSlectionList;

    @FindBy(css = ".o-enb")
    private List<WebElement> datepickerDaysList;

    @FindBy(css = ".awe-lookup-field button")
    private WebElement chefDropdownBtn;

    @FindBy(css = ".awe-multilookup-field button")
    private WebElement mealsDropdownBtn;

    @FindBy(css = "#createDinnerBonusMealId-awed")
    private WebElement bonusMealSelectionButton;

    @FindBy(css = "#createDinnerChefId-awepw li")
    private List<WebElement> chiefsDropdownList;

    @FindBy(css = ".awe-morebtn")
    private WebElement moreBtn;

    @FindBy(css = "#createDinnerBonusMealId-dropmenu>div[class='o-itsc']>ul>li")
    private List<WebElement> bonusMealList;

    @FindBy(css = "#createDinner + div .awe-okbtn")
    private WebElement formConfirmationButton;

    @FindBy(css = "#createDinnerChefId-awepw + div .awe-okbtn")
    private WebElement chefOKBtn;

    @FindBy(css = "#createDinnerMealsIds-awepw li")
    private List<WebElement> mealsDropdownList;

    @FindBy(css = ".awe-movebtn")
    private WebElement addMealBtn;

    @FindBy(css = "#createDinnerMealsIds-awepw .awe-morebtn")
    private WebElement moreMealBtn;

    @FindBy(css = "#createDinnerMealsIds-awepw + div .awe-okbtn")
    private WebElement mealOKBtn;

    public PopUpFormPage provideName(String name) {
        waitForElementToBeVisible(nameInputField);
        sendKeys(nameInputField, name);
        return this;
    }

    public void openDatepicker() {
        waitForElementToBeVisible(datepickerButton);
        clickOnButton(datepickerButton);
    }

    public void openYearSelectionList() {
        waitForElementToBeVisible(yearSelectionButton);
        clickOnButton(yearSelectionButton);
    }

    public void openMonthSelectionList() {
        waitForElementToBeVisible(monthSelectionButton);
        clickOnButton(monthSelectionButton);
    }

    public List<WebElement> getYearSlectionList() {
        return new ArrayList<>(yearSlectionList);
    }

    public List<WebElement> getMonthSelectionList() {
        return new ArrayList<>(monthSlectionList);
    }

    public List<WebElement> getDatepickerDaysList() {
        return new ArrayList<>(datepickerDaysList);
    }

    public void selectRandomYear() {
        openYearSelectionList();
        WebElement selectedYear = getRandomElement(getYearSlectionList());
        clickOnButton(selectedYear);
    }

    public void selectRandomMonth() {
        openMonthSelectionList();
        WebElement selectedMonth = getRandomElement(getMonthSelectionList());
        clickOnButton(selectedMonth);
    }

    public WebElement selectRandomDatepickerDay() {
        return getRandomElement(getDatepickerDaysList());
    }

    public void selectRandomDay() {
        WebElement selectedDAy = selectRandomDatepickerDay();
        clickOnButton(selectedDAy);
    }

    public PopUpFormPage selectDate() {
        openDatepicker();
        selectRandomYear();
        selectRandomMonth();
        selectRandomDay();
        return this;
    }
    public PopUpFormPage openChefList() {
        waitForElementToBeVisible(chefDropdownBtn);
        clickOnButton(chefDropdownBtn);
        return this;
    }
    public PopUpFormPage selectRandomChef() {
        clickOnButton(getRandomElement(chiefsDropdownList));
        return this;
    }
    public int getChefSize() {
        return chiefsDropdownList.size() - 1;
    }
    public PopUpFormPage loadMoreOptions() {
        clickOnButton(moreBtn);
        return this;
    }
    public PopUpFormPage loadChefList() {
        waitForElementToBeVisible(moreBtn);
        while (moreBtn.isDisplayed()) {
            scrollToElement(chiefsDropdownList.get(getChefSize()));
            clickOnButton(moreBtn);
        }
        return this;
    }
    public PopUpFormPage confirmChefSelection(){
        clickOnButton(chefOKBtn);
        return this;
    }

    public PopUpFormPage selectChef(){
        openChefList();
        loadChefList();
        selectRandomChef();
        confirmChefSelection();
        return this;
    }

    public PopUpFormPage openMealsList() {
        clickOnButton(mealsDropdownBtn);
        return this;
    }

    public PopUpFormPage addMeal(){
        waitForElementToBeClickable(addMealBtn);
        clickOnButton(addMealBtn);
        return this;
    }
    public PopUpFormPage selectRandomMeal(){
        getRandomElement(mealsDropdownList);
        return this;
    }

    public PopUpFormPage selectRandomMeal(int mealsNumber){
        for (int i=0; i<mealsNumber; i++){
            selectRandomMeal();
            addMeal();
        }
        return this;
    }

    public int getMealsListSize(){
        return mealsDropdownList.size()-1;
    }

    public PopUpFormPage loadMealsList() {
        waitForElementToBeVisible(addMealBtn);
        while (moreMealBtn.isDisplayed()) {
            scrollToElement(mealsDropdownList.get(getMealsListSize()));
            waitForElementToBeClickableBool(moreMealBtn);
            clickOnButton(moreMealBtn);
        }
        return this;
    }

    public PopUpFormPage confirmMealSelection(){
        clickOnButton(mealOKBtn);
        return this;
    }

    public PopUpFormPage selectMeal(int mealNumber){
        openMealsList();
        loadMealsList();
        selectRandomMeal(mealNumber);
        confirmMealSelection();
        return this;
    }

    public void openBonusMealList(){
        waitForElementToBeVisible(bonusMealSelectionButton);
        clickOnButton(bonusMealSelectionButton);
    }

//    public List<WebElement> getBonusMealList(){
//        return new ArrayList<>(bonusMealList);
//    }

    public void selectRandomBonusMeal(){
        WebElement selectedBonusMeal = getRandomElement(bonusMealList);
        clickOnButton(selectedBonusMeal);
    }

    public PopUpFormPage selectBonusMeal(){
        openBonusMealList();
        selectRandomBonusMeal();
        return this;
    }

    public void submitForm(){
        waitForElementToBeVisible(formConfirmationButton);
        clickOnButton(formConfirmationButton);
    }
}


