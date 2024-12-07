package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;

public class TermsConditionsTest extends BaseTest{
    @Test
    public void termsTest(){
        setUp();
        navigateToURL("");

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.AccessTermsConditions();
        Assert.assertTrue(searchProductPage.verifyTermsConditionsOpen());
        System.out.println("Current URL: " + searchProductPage.acquireCurrentUrl());



    }
}
