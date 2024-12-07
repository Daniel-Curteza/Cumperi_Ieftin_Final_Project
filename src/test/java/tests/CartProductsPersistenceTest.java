package tests;

import org.testng.annotations.Test;
import pages.SearchProductPage;

public class CartProductsPersistenceTest extends BaseTest{
    @Test(dependsOnMethods = {"AddToCartTest.searchAddToCartTest"})
    public void testCartProductsPersistence() {
        setUp();
        navigateToURL("");
    }
    SearchProductPage searchProductPage = new SearchProductPage(driver);

}
