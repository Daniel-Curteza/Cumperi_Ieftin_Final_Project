package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

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

    @FindBy (xpath = "//*[@class='close']")
    public WebElement closeAddMessageElement;

    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement cartPopUPTrigger;

    @FindBy(partialLinkText = "Vezi Coşul")
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

    @FindBy (partialLinkText = "Termeni si conditii")
    public WebElement linkTermsConditions;

    @FindBy(xpath = "//h1[contains(text(),'Termeni si conditii de utilizare')]")
    public WebElement TermeniConditiiUtilizare;

    public String termsPageUrl ="https://www.cumperiieftin.ro/conditii-de-utilizare";




    public SearchProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void AddProductCart(String model, int quantity) throws InterruptedException {
        this.acceptCookies();
        this.enterProductModel(model);
        this.submitSearch();
        this.selectProduct();
        this.selectQuantity(quantity);
        this.addToCart();
        this.closeAddMessage();
        this.openCartPopUp();
        this.openCart();
        this.verifyQuantityCorrect(quantity);

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
        System.out.println("Submitting search");
        searchButton.click();
    }

    public void selectProduct() {
        waitUntilElementVisible(product);
        System.out.println("Selecting product");
        product.click();
    }

    public void selectQuantity(int quantity) throws InterruptedException {
        waitUntilElementVisible(inputQuantity);
        System.out.println("Selecting quantity = " + quantity);
        inputQuantity.clear();
        inputQuantity.sendKeys(String.valueOf(quantity));
        Thread.sleep(6000);
    }

    public void addToCart() {
        waitUntilElementVisible(addToCart);
        System.out.println("Adding to cart");
        addToCart.click();
    }

    public void closeAddMessage(){
        waitUntilElementVisible(closeAddMessageElement);
        System.out.println("Closing add message");
        closeAddMessageElement.click();
    }

    public void openCartPopUp() {
        System.out.println("Opening cart popup");
        cartPopUPTrigger.click();

    }

    public void openCart() {
        waitUntilElementVisible(openCartButton);
        System.out.println("Opening cart");
        openCartButton.click();
    }

    public boolean verifyQuantityCorrect(int quantity) {
        waitUntilElementVisible(cartQuantity);
        int cartQuantityValue = Integer.parseInt(Objects.requireNonNull(cartQuantity.getAttribute("value")));
        System.out.println("Cart quantity= " + cartQuantityValue);
        return cartQuantityValue == quantity;
    }

    public void AddProductWishlist(String model){
        this.acceptCookies();
        this.enterProductModel(model);
        this.submitSearch();
        this.selectProduct();
        this.addToWishlist();
        this.accessAccount();
        this.openWishlist();
        this.verifyProductInWishlist();
        this.verifyProductNotInWishlist();
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
        return cartProductModel.isDisplayed();
    }

    public boolean verifyProductNotInWishlist() {
        waitUntilElementVisible(wishlistEmpty);
        System.out.println("Verifying wishlist empty");
        return !wishlistEmpty.getText().equals(product.getText());
    }

    public void AccessTermsConditions() {
        this.acceptCookies();
        this.openTerms();
        this.acquireCurrentUrl();
        this.verifyTermsConditionsOpen();
    }

    public void openTerms() {
        waitUntilElementVisible(linkTermsConditions);
        System.out.println("Opening terms");
        linkTermsConditions.click();
    }

    public String acquireCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean verifyTermsConditionsOpen() {
        waitUntilElementVisible(TermeniConditiiUtilizare);
        return acquireCurrentUrl().equals(termsPageUrl);
    }

}
