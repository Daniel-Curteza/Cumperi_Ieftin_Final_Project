package tests;

import POJO.ModelModel;
import POJO.ProductModel;
import data.ProductModelDP;
import org.testng.annotations.Test;
import pages.SearchProductPage;

public class SearchAddToCartTest extends BaseTest{

    @Test(dataProvider = "productModelJsonDataProvider", dataProviderClass = ProductModelDP.class)
    public void searchAddToCart(ModelModel productModel) throws InterruptedException {
        setUp();
        navigateToURL("");

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        System.out.println(productModel);
        searchProductPage.searchProduct(
                productModel.getModel(),
                productModel.getQuantity()
        );







    }
}
