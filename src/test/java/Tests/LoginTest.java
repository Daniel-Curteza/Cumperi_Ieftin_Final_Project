package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BrowserUtils;

public class LoginTest extends BaseTest {
    @DataProvider
    public Object[][]loginDataProvider() {
        return new Object[][]{
                {"qwerty@qwerty.qwerty", "qwerty", "chrome"}
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String email, String password,String browser){
        getBrowser(browser);
        getBaseURL();

        navigateToURL("/account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        System.out.println("Verify login successful");
        Assert.assertTrue(loginPage.loginSuccessful());
    }
}
