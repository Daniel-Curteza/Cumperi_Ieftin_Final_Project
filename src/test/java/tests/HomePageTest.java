package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends  BaseTest {

    @Test
    public void homePageAccessTest() throws InterruptedException {
        setUp();
        navigateToURL("");
        HomePage homePage = new HomePage(driver);

        String homePageUrl = baseURL;
        Assert.assertEquals(homePageUrl, homePage.getCurrentUrl());
    }
}
