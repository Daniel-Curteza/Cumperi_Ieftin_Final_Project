package tests;

import POJO.ProductModel;
import data.ProductModelDP;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;

public class AddToCartTest extends BaseTest{

    @Test(dataProvider = "productModelJsonDataProvider", dataProviderClass = ProductModelDP.class)
    public void searchAddToCart(ProductModel productModel) throws InterruptedException {
        setUp();
        navigateToURL("");

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        System.out.println(productModel);
        searchProductPage.AddProductCart(
                productModel.getProdModel().getModel(),
                productModel.getProdModel().getQuantity()
        );

        if(productModel.getModelError().isEmpty()) {
            System.out.println("Verifying product is added to the cart");
            Assert.assertTrue(searchProductPage.verifyQuantityCorrect(productModel.getProdModel().getQuantity()));
        }else {
            System.out.println("Verifying product is not added to the cart");
            Assert.assertFalse(searchProductPage.verifyQuantityCorrect(productModel.getProdModel().getQuantity()));
        }
    }
}
