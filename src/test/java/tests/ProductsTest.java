package tests;

import org.pages.HomePage;
import org.pages.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.pages.ProductsPage.*;

public class ProductsTest extends BaseTest {
    ProductsPage productsPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        productsPage = new ProductsPage(driver);
        homePage = new HomePage(driver);
        homePage.clickOnProductsLink();
    }

    @Test
    public void verifyFirstProduct() {
        //Verify All Products text
        softAssert.assertEquals(txtAllProducts.getText(), "ALL PRODUCTS", "Expected 'All products' text is not visible");

        //Click on first product
        productsPage.clickOnViewProductOfFirstProduct();

        //Verify product Details page
        softAssert.assertTrue(txtProductName.isDisplayed(), "Product name is not visible");
        softAssert.assertTrue(txtCondition.isDisplayed(), "Product Condition is not visible");
        softAssert.assertTrue(txtAvailability.isDisplayed(), "Product Availability is not visible");
        softAssert.assertTrue(txtCategory.isDisplayed(), "Product Category is not visible");
        softAssert.assertTrue(txtBrand.isDisplayed(), "Product Brand is not visible");
        softAssert.assertTrue(txtPrice.isDisplayed(), "Product price is not visible");
        softAssert.assertAll();

    }
}
