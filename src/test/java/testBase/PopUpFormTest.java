package testBase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.PopUpFormMenuPage;
import pages.PopUpFormPage;
import pages.SideMenuPage;

import java.lang.reflect.InvocationTargetException;

public class PopUpFormTest extends TestBase{

    @ParameterizedTest
    @CsvFileSource(resources = "/popUpFormData.csv")
    @Tag("regression")
    @DisplayName("Pop_Up_Form_Test")
    public void validatePopUpForm(String name) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        at(SideMenuPage.class).
                goToPopUpForm();

        at(PopUpFormMenuPage.class).
                createPopUpForm();

        at(PopUpFormPage.class).
                provideName(name).
                selectChef();
    }
}
