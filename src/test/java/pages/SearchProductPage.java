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

    @FindBy(xpath = "//a[@class='wishlist']")
    public WebElement linkAddWishlist;

    @FindBy (partialLinkText = "Succes")
    public WebElement wishlistAddMessage;

    @FindBy(partialLinkText = "conectat")
    public WebElement accountLink;

    @FindBy (partialLinkText = "Wish")
    public WebElement linkWishlist;

    @FindBy (xpath = "/html/body/div[2]/div[5]/div[4]/div[2]")
    public WebElement wishlistEmpty;





    public SearchProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void AddProductCart(String model, String quantity) {
        this.acceptCookies();
        this.enterProductModel(model);
        this.submitSearch();
        this.selectProduct();
        this.selectQuantity(quantity);
        this.addToCart();
        this.openCartPopUp();
        this.openCart();
        this.verifyQuantityCorrect(quantity);
        this.verifyQuantityIncorrect(quantity);

    }

    public void acceptCookies() {
        waitUntilElementVisible(AcceptCookies);
        System.out.println("Accepting cookies");
        AcceptCookies.click();
    }

    public void enterProductModel(String model) {
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

    public boolean verifyQuantityCorrect(String quantity) {
        waitUntilElementVisible(cartQuantity);
        System.out.println("Verifying correct quantity");
        return cartQuantity.getText().equals(quantity);
    }

    public boolean verifyQuantityIncorrect(String quantity) {
        waitUntilElementVisible(cartQuantity);
        System.out.println("Verifying incorrect quantity");
        return !cartQuantity.getText().equals(quantity);
    }

    public void AddProductWishlist(String model){
        this.acceptCookies();
        this.enterProductModel(model);
        this.submitSearch();
        this.selectProduct();
        this.addToWishlist();
        this.accessAccount();
        this.openWishlist();
    }

    public void addToWishlist() {
        waitUntilElementVisible(linkAddWishlist);
        System.out.println("Adding to wishlist");
        linkAddWishlist.click();
        waitUntilElementVisible(wishlistAddMessage);
    }

    public void accessAccount() {
        waitUntilElementVisible(accountLink);
        System.out.println("Accessing my account page");
        accountLink.click();
    }

    public void openWishlist() {
        waitUntilElementVisible(linkWishlist);
        System.out.println("Opening wishlist");
        linkWishlist.click();
    }

    public boolean verifyProductInWishlist() {
        waitUntilElementVisible(cartProductModel);
        System.out.println("Verifying wishlist content");
        return cartProductModel.getText().equals(product.getText());
    }

    public boolean verifyProductNotInWishlist() {
        waitUntilElementVisible(wishlistEmpty);
        System.out.println("Verifying wishlist empty");
        return !wishlistEmpty.getText().equals(product.getText());
    }

}
