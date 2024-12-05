package tests;

import POJO.PassResetModel;
import data.ResetDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PasswordResetPage;

public class PasswordResetTest extends BaseTest {
    @Test(dataProvider = "resetJsonDataProvider", dataProviderClass = ResetDP.class)
    public void passwordReset (PassResetModel passResetModel) throws InterruptedException {
        setUp();
        navigateToURL("account/login");

        PasswordResetPage passwordResetPage = new PasswordResetPage(driver);
        System.out.println(passResetModel);
        passwordResetPage.resetPassword(passResetModel.getResetAccount().getEmail());

        if (passResetModel.getResetErr().isEmpty()){
            System.out.println("Verifying successful password reset");
            Assert.assertTrue(passwordResetPage.verifyResetSuccessful(passResetModel.getResetAccount().getEmail()));
        } else {
            System.out.println("Verifying failed password reset");
            Assert.assertTrue(passwordResetPage.verifyResetFailed(passResetModel.getResetErr()));
        }
    }
}