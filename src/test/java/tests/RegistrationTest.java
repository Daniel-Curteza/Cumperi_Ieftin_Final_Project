package tests;

import POJO.RegistrationModel;
import data.RegistrationDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "regJsonDataProvider", dataProviderClass = RegistrationDP.class)
    public void registerWithRegisterModel(RegistrationModel registrationModel) throws  InterruptedException {
        setUp();
        navigateToURL("/account/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println(registrationModel);
        registrationPage.register(
                registrationModel.getAccount().getName(),
                registrationModel.getAccount().getFirstName(),
                registrationModel.getAccount().getEmail(),
                registrationModel.getAccount().getPhone(),
                registrationModel.getAccount().getAddress(),
                registrationModel.getAccount().getCity(),
                registrationModel.getAccount().getPassword()
        );

        if (registrationModel.getRegErr().isEmpty()) {
            System.out.println("Verifying successful registration");
            Assert.assertTrue(registrationPage.verifyRegistrationSuccessful(registrationModel.getAccount().getName()));
        } else {
            System.out.println("Verifying failed registration");
            Assert.assertTrue(registrationPage.verifyRegistrationFailed(registrationModel.getRegErr()));
        }
    }
}
