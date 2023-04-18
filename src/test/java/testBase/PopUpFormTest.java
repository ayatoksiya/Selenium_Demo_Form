package testBase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.ConfirmationPopUpPage;
import pages.PopUpFormMenuPage;
import pages.PopUpFormPage;
import pages.SideMenuPage;


public class PopUpFormTest extends TestBase{

    @ParameterizedTest
    @CsvFileSource(resources = "/popUpFormData.csv")
    @Tag("regression")
    @DisplayName("Pop_Up_Form_Test")
    public void validatePopUpForm(String name, String confirmationMessage, int numberOfMeals) {

        at(SideMenuPage.class).
                goToPopUpForm();

        at(PopUpFormMenuPage.class).
                createPopUpForm();

        at(PopUpFormPage.class).
                provideName(name).
                selectDate().
                selectChef().
                selectMeal(numberOfMeals).
                selectBonusMeal().
                submitForm();

        String confirmationInfo = at(ConfirmationPopUpPage.class).
                getConfirmationPopUpInfo();

        Assertions.assertThat(confirmationInfo).isEqualTo(confirmationMessage);

        at(ConfirmationPopUpPage.class).
                acceptConfirmationPopUp();
    }
}
