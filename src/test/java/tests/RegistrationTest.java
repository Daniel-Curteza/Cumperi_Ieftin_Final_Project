package tests;

import POJO.RegModel;
import data.RegistrationDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "regJsonDataProvider", dataProviderClass = RegistrationDP.class)
    public void registerWithRegisterModel(RegModel regModel) throws  InterruptedException {
        setUp();
        navigateToURL("account/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println(regModel);
        registrationPage.register(
                regModel.getRegAccount().getName(),
                regModel.getRegAccount().getFirstName(),
                regModel.getRegAccount().getEmail(),
                regModel.getRegAccount().getPhone(),
                regModel.getRegAccount().getAddress(),
                regModel.getRegAccount().getCity(),
                regModel.getRegAccount().getCounty(),
                regModel.getRegAccount().getPassword()
        );

        if (regModel.getRegErr().isEmpty()) {
            System.out.println("Verifying successful registration");
            Assert.assertTrue(registrationPage.verifyRegistrationSuccessful(regModel.getRegAccount().getName()));
        } else {
            System.out.println("Verifying failed registration");
            Assert.assertTrue(registrationPage.verifyRegistrationFailed(regModel.getRegErr()));
        }
    }
}
