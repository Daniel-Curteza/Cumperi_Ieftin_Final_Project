package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class RegistrationPage extends BasePage{

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

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[3]/table/tbody/tr[1]/td[2]/input")
    private  WebElement registerPassword;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[3]/table/tbody/tr[2]/td[2]/input")
    private  WebElement registerRetypePassword;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div[5]/div/input[2]")
    private  WebElement registerSubmitButton;

    @FindBy (xpath = "//*[@id=\"content\"]/h1")
    private WebElement registrationWarningMessageElement;



    public RegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void register (String name, String firstName, String email, String phone, String address, String city, String password){
        waitUntilElementVisible(InregistrareCont);
        this.enterRegisterName(name);
        this.enterRegisterFirstName(firstName);
        this.registerEmail(email);
        this.enterRegisterPhone(phone);
        this.enterRegisterAddress(address);
        this.enterRegisterCity(city);
        this.enterRegisterPassword(password);
        this.enterRegisterRetypePassword(password);
        this.registerSubmit();
    }

    public void enterRegisterName(String name) {
        waitUntilElementVisible(registerEmail);
        System.out.println("Entering name: " + name);
        registerEmail.clear();
        registerEmail.sendKeys(name);
    }

    public void enterRegisterFirstName(String firstName) {
        waitUntilElementVisible(registerFirstName);
        System.out.println("Entering first name :" + firstName);
        registerEmail.clear();
        registerEmail.sendKeys(firstName);
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
        registerEmail.clear();
        registerEmail.sendKeys(phone);
    }

    public void enterRegisterAddress(String address) {
        waitUntilElementVisible(registerAddress);
        System.out.println("Entering address: " + address);
        registerEmail.clear();
        registerEmail.sendKeys(address);
    }

    public void enterRegisterCity(String city) {
        waitUntilElementVisible(registerCity);
        System.out.println("Entering city: " + city);
        registerEmail.clear();
        registerEmail.sendKeys(city);
    }

    public void enterRegisterPassword(String password) {
        waitUntilElementVisible(registerPassword);
        System.out.println("Entering password: " + password);
        registerEmail.clear();
        registerEmail.sendKeys(password);
    }

    public void enterRegisterRetypePassword(String password) {
        waitUntilElementVisible(registerRetypePassword);
        System.out.println("Retyping password: " + password);
        registerEmail.clear();
        registerEmail.sendKeys(password);
    }

    public void registerSubmit(){
        registerSubmitButton.click();
    }

    public boolean verifyRegistrationSuccessful(String name) {

        WebElement welcomeMessage = waitUntilElementVisible(By.partialLinkText("Esti conectat ca "));
        System.out.println("Login successful with message: Esti conectat ca " + name);
        return welcomeMessage.isDisplayed();
    }
    public boolean verifyRegistrationFailed(String errorMessage) {
        waitUntilElementVisible(registrationWarningMessageElement);
        System.out.println("Error message displayed: " + registrationWarningMessageElement.getText());
        return registrationWarningMessageElement.getText().equalsIgnoreCase(errorMessage);
    }

}


