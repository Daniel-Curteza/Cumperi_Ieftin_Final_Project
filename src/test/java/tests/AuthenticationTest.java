package tests;

import POJO.AuthenticationModel;
import data.AuthenticationDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;

public class AuthenticationTest extends BaseTest {

    @Test(dataProvider = "authJsonDataProvider", dataProviderClass = AuthenticationDP.class)
    public void authWithAuthModel(AuthenticationModel authenticationModel) throws InterruptedException {
        setUp();
        navigateToURL("account/login");

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        System.out.println(authenticationModel);
        authenticationPage.login(authenticationModel.getAuthAccount().getEmail(), authenticationModel.getAuthAccount().getPassword());

        if (authenticationModel.getAuthErr().isEmpty()) {
            System.out.println("Verifying successful authentication");
            Assert.assertTrue(authenticationPage.verifyLoginSuccessful(authenticationModel.getAuthAccount().getName()));
        } else {
            System.out.println("Verifying failed authentication");
            Assert.assertTrue(authenticationPage.verifyLoginFailed(authenticationModel.getAuthErr()));
        }
    }
}
