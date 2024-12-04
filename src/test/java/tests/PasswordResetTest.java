package tests;

import POJO.PasswordResetModel;
import data.ResetDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PasswordResetPage;

public class PasswordResetTest extends BaseTest {
    @Test(dataProvider = "resetJsonDataProvider", dataProviderClass = ResetDP.class)
    public void passwordReset (PasswordResetModel passwordResetModel) throws InterruptedException {
        setUp();
        navigateToURL("account/login");

        PasswordResetPage passwordResetPage = new PasswordResetPage(driver);
        System.out.println(passwordResetModel);
        passwordResetPage.resetPassword(passwordResetModel.getResetAccount().getEmail());

        if (passwordResetModel.getResetErr().isEmpty()){
            System.out.println("Verifying successful password reset");
            Assert.assertTrue(passwordResetPage.verifyResetSuccessful(passwordResetModel.getResetAccount().getEmail()));
        } else {
            System.out.println("Verifying failed password reset");
            Assert.assertTrue(passwordResetPage.verifyResetFailed(passwordResetModel.getResetErr()));
        }
    }
}