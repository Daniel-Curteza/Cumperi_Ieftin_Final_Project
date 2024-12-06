package tests;

import POJO.ComparisonModel;
import data.ComparisonDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProdComparisonPage;

public class ProductComparisonTest extends BaseTest{
    @Test(dataProvider = "productComparisonJsonDataProvider", dataProviderClass = ComparisonDP.class)
    public void testProductComparison(ComparisonModel comparisonModel) throws InterruptedException {
        setUp();
        navigateToURL("");
        ProdComparisonPage prodComparisonPage = new ProdComparisonPage(driver);
        System.out.println(comparisonModel);
        prodComparisonPage.ProductsCompare(
                comparisonModel.getComparisonModel().getModel1(),
                comparisonModel.getComparisonModel().getModel2()
        );

        if (comparisonModel.getEmptyErr().isEmpty()) {
            System.out.println("Verifying products successfully added to comparison");
            Assert.assertTrue(prodComparisonPage.verifyComparisonProductsPresent());
        } else {
            System.out.println("Verifying products not added to comparison");
            Assert.assertTrue(prodComparisonPage.verifyComparisonProductsNotPresent(comparisonModel.getEmptyErr()));
        }

    }
}
