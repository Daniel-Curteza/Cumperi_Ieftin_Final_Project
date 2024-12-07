package tests;

import POJO.ProductModel;
import data.ProductModelDP;
import org.testng.annotations.Test;
import pages.SearchProductPage;

public class AddToWishlistTest extends BaseTest{

    @Test
    public void addToWishlistTest(ProductModel productModel) {
        setUp();
        navigateToURL("");

        SearchProductPage searchProductPage = new SearchProductPage(driver);
        searchProductPage.AddProductWishlist(
                productModel.getProdModel().getModel()
        );

        if (productModel.getModelError().isEmpty())
            System.out.println("Product added to wishlist");
        else
            System.out.println("Product not added to wishlist");

        }
    }

