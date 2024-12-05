package tests;

import POJO.AuthModel;
import data.AuthenticationDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;

public class AuthenticationTest extends BaseTest {

    @Test(dataProvider = "authJsonDataProvider", dataProviderClass = AuthenticationDP.class)
    public void authWithAuthModel(AuthModel authModel) throws InterruptedException {
        setUp();
        navigateToURL("account/login");

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        System.out.println(authModel);
        authenticationPage.login(
                authModel.getAuthAccount().getEmail(),
                authModel.getAuthAccount().getPassword());


        if (authModel.getAuthErr().isEmpty()) {
            System.out.println("Verifying successful authentication");
            Assert.assertTrue(authenticationPage.verifyLoginSuccessful(authModel.getAuthAccount().getName()));
        } else {
            System.out.println("Verifying failed authentication");
            Assert.assertTrue(authenticationPage.verifyLoginFailed(authModel.getAuthErr()));
        }
    }
}
