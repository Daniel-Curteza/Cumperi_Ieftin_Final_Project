package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class SearchProductPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"popdown_ok\"]")
    private WebElement AcceptCookies;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='button-search']")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[2]/div[5]/div[2]/div[6]/div[1]/div[2]/a")
    private WebElement product;

    @FindBy(xpath = "//*[@id='qty']")
    private WebElement inputQuantity;

    @FindBy(xpath = "//*[@id='button-cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id='cart-total']")
    private WebElement cartPopUPTrigger;

    @FindBy(xpath = "//button[contains(text(),'Vezi cosul')]")
    private WebElement openCartButton;

    @FindBy(xpath = "//*[contains(@class, 'model') and contains(text(), '010-02562-10')]")
    public WebElement cartProductModel;

    @FindBy(xpath = "//input[@class='w30']")
    public WebElement cartQuantity;


    public SearchProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String model, String quantity) {
        this.acceptCookies();
        this.enterProductModelSearch(model);
        this.submitSearch();
        this.selectProduct();
        this.selectQuantity(quantity);
        this.addToCart();
        this.openCartPopUp();
        this.openCart();
        this.verifyQuantity(quantity);

    }

    public void acceptCookies() {
        waitUntilElementVisible(AcceptCookies);
        System.out.println("Accepting cookies");
        AcceptCookies.click();
    }

    public void enterProductModelSearch(String model) {
        waitUntilElementVisible(searchBox);
        System.out.println("Entering product model");
        searchBox.clear();
        searchBox.sendKeys(model);

    }

    public void submitSearch() {
        waitUntilElementVisible(searchButton);
        System.out.println("Submitting search");
        searchButton.click();
    }

    public void selectProduct() {
        waitUntilElementVisible(product);
        System.out.println("Selecting product");
        product.click();
    }

    public void selectQuantity(String quantity) {
        waitUntilElementVisible(inputQuantity);
        System.out.println("Selecting quantity");
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity);
    }

    public void addToCart() {
        waitUntilElementVisible(addToCart);
        System.out.println("Adding to cart");
        addToCart.click();
    }

    public void openCartPopUp() {
        waitUntilElementVisible(cartPopUPTrigger);
        System.out.println("Opening cart popup");
        Actions action = new Actions(driver);
        action.moveToElement(cartPopUPTrigger).perform();

    }

    public void openCart() {
        waitUntilElementVisible(openCartButton);
        System.out.println("Opening cart popup");
        openCartButton.click();
    }

    public boolean verifyQuantity(String quantity) {
        waitUntilElementVisible(cartQuantity);
        System.out.println("Verifying quantity");
        if (quantity.equals(cartQuantity.getText())) {
            System.out.println("Quantity correct");
            return true;
        } else {
            System.out.println("Quantity incorrect");
            return false;
        }
    }
}
