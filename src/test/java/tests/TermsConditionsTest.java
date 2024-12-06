package tests;

import org.testng.annotations.Test;
import pages.SearchProductPage;

public class TermsConditionsTest extends BaseTest{
    @Test
    public void termsTest(){
        setUp();
        navigateToURL("");

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.TermsConditions();




    }
}
