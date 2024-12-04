package tests;

import POJO.ResetModel;
import data.ResetDP;
import org.testng.annotations.Test;

public class PasswordResetTest extends BaseTest {
    @Test(dataProvider = "resetJsonDataProvider", dataProviderClass = ResetDP.class)
    public void passwordReset (ResetModel resetModel) throws InterruptedException {
        setUp();
        navigateToURL("account/forgotten");

    }

}
