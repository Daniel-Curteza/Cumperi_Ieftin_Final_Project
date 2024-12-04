package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"popdown_ok\"]")
    private  WebElement AcceptCookies;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private  WebElement InregistrareCont;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[1]/td[2]/input")
    private  WebElement registerName;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
    private  WebElement registerFirstName;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
    private  WebElement registerEmail;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
    private  WebElement registerPhone;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[2]/table/tbody/tr[5]/td[2]/input")
    private  WebElement registerAddress;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[2]/table/tbody/tr[7]/td[2]/input")
    private  WebElement registerCity;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[2]/table/tbody/tr[10]/td[2]/select")
    private  WebElement registerCounty;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[3]/table/tbody/tr[1]/td[2]/input")
    private  WebElement registerPassword;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[3]/table/tbody/tr[2]/td[2]/input")
    private  WebElement registerRetypePassword;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[5]/div/input[1]")
    private  WebElement termsBox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[5]/div/input[2]")
    private  WebElement registerSubmitButton;

    @FindBy(xpath = "//h1[contains(text(), 'Contul tau a fost creat!')]")
    private WebElement registrationSuccessElement;

    @FindBy (xpath = "//div[contains(text(), 'Eroare:')]")
    private WebElement registrationWarningMessageElement;
    private String county;


    public RegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void register (String name, String firstName, String email, String phone, String address, String city, String county, String password){
        this.acceptCookies();
        waitUntilElementVisible(InregistrareCont);
        this.county = county;
        this.enterRegisterName(name);
        this.enterRegisterFirstName(firstName);
        this.registerEmail(email);
        this.enterRegisterPhone(phone);
        this.enterRegisterAddress(address);
        this.enterRegisterCity(city);
        this.selectCounty();
        this.enterRegisterPassword(password);
        this.enterRegisterRetypePassword(password);
        this.selectTerms();
        this.registerSubmit();
    }

    public void acceptCookies(){
        waitUntilElementVisible(AcceptCookies);
        System.out.println("Accepting cookies");
        AcceptCookies.click();
    }

    public void enterRegisterName(String name) {
        waitUntilElementVisible(registerName);
        System.out.println("Entering name: " + name);
        registerName.clear();
        registerName.sendKeys(name);
    }

    public void enterRegisterFirstName(String firstName) {
        waitUntilElementVisible(registerFirstName);
        System.out.println("Entering first name :" + firstName);
        registerFirstName.clear();
        registerFirstName.sendKeys(firstName);
    }

    public void registerEmail(String email) {
        waitUntilElementVisible(registerEmail);
        System.out.println("Entering email: " + email);
        registerEmail.clear();
        registerEmail.sendKeys(email);
    }

    public void enterRegisterPhone(String phone) {
        waitUntilElementVisible(registerPhone);
        System.out.println("Entering phone: " + phone);
        registerPhone.clear();
        registerPhone.sendKeys(phone);
    }

    public void enterRegisterAddress(String address) {
        waitUntilElementVisible(registerAddress);
        System.out.println("Entering address: " + address);
        registerAddress.clear();
        registerAddress.sendKeys(address);
    }

    public void enterRegisterCity(String city) {
        waitUntilElementVisible(registerCity);
        System.out.println("Entering city: " + city);
        registerCity.clear();
        registerCity.sendKeys(city);
    }

    public void selectCounty(){
        waitUntilElementVisible(registerCounty);
        Select dropdown = new Select(registerCounty);
        System.out.println("Selecting county: " + county);
        dropdown.selectByVisibleText(county);

    }

    public void enterRegisterPassword(String password) {
        waitUntilElementVisible(registerPassword);
        System.out.println("Entering password: " + password);
        registerPassword.clear();
        registerPassword.sendKeys(password);
    }

    public void enterRegisterRetypePassword(String password) {
        waitUntilElementVisible(registerRetypePassword);
        System.out.println("Retyping password: " + password);
        registerRetypePassword.clear();
        registerRetypePassword.sendKeys(password);
    }

    public void selectTerms(){
        waitUntilElementVisible(termsBox);
        System.out.println("Accepting Terms and Conditions");
        if (!termsBox.isSelected()){
            termsBox.click();
        }
    }

    public void registerSubmit(){
        registerSubmitButton.click();
    }

    public boolean verifyRegistrationSuccessful(String name) {

        waitUntilElementVisible(registrationSuccessElement);
        System.out.println("Registration successful with message: Esti conectat ca " + name);
        return registrationSuccessElement.isDisplayed();
    }
    public boolean verifyRegistrationFailed(String errorMessage) {
        waitUntilElementVisible(registrationWarningMessageElement);
        System.out.println("Error message displayed: " + '"' + registrationWarningMessageElement.getText() + '"');
        return registrationWarningMessageElement.getText().equalsIgnoreCase(errorMessage);
    }

}


