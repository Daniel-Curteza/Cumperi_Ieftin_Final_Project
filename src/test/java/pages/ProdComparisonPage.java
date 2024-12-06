package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdComparisonPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"popdown_ok\"]")
    private WebElement AcceptCookies;

    @FindBy (xpath = "//input[@id='search']")
    private WebElement searchBox;

    @FindBy (xpath = "//div[@class='button-search']")
    private WebElement searchButton;

    @FindBy (xpath = "//*[@id='compare-total']")
    private WebElement comparisonLink;

    @FindBy(xpath = "//*[@id=\"content\"]/div[6]/div/div[8]/input")
    private WebElement addToComparisonCheckbox;

    @FindBy (xpath = "//h1[contains(text(), 'Comparare Produse')]")
    private WebElement comparisonTitle;

    @FindBy (xpath = "//td[@colspan='3']")
    private WebElement productsPresent;

    @FindBy (xpath = "/html/body/div[2]/div[5]/div[3]/div[2]")
    private WebElement productsNotPresent;



    public ProdComparisonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ProductsCompare(String model1, String model2) throws InterruptedException {
        this.acceptCookies();
        this.enterModel1(model1);
        this.submitSearch();
        this.addToComparison();
        this.enterModel2(model2);
        this.submitSearch();
        this.addToComparison();
        this.openComparisonPage();
    }

    public void acceptCookies() {
        waitUntilElementVisible(AcceptCookies);
        System.out.println("Accepting cookies");
        AcceptCookies.click();
    }

    public void enterModel1(String model1) {
        waitUntilElementVisible(searchBox);
        System.out.println("Entering product model");
        searchBox.clear();
        searchBox.sendKeys(model1);
    }
    public void enterModel2(String model2) {
        waitUntilElementVisible(searchBox);
        System.out.println("Entering product model");
        searchBox.clear();
        searchBox.sendKeys(model2);
    }

    public void submitSearch() {
        waitUntilElementVisible(searchButton);
        System.out.println("Submitting search");
        searchButton.click();
    }

    public void addToComparison() {
        waitUntilElementVisible(addToComparisonCheckbox);
        System.out.println("Adding to comparison");
        addToComparisonCheckbox.click();
    }
    public void openComparisonPage() {
        waitUntilElementVisible(comparisonLink);
        System.out.println("Opening comparison page");
        comparisonLink.click();
    }

    public boolean verifyComparisonProductsPresent() {
        waitUntilElementVisible(productsPresent);
        System.out.println("Products present in comparison");
        return productsPresent.isDisplayed();
    }

    public boolean verifyComparisonProductsNotPresent(String errorMessage) {
        waitUntilElementVisible(productsPresent);
        System.out.println("Product not present in comparison");
        return productsNotPresent.getText().equalsIgnoreCase(errorMessage);
    }








}

