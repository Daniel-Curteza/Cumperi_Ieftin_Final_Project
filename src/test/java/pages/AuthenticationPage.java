package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'Client existent')]")
    private  WebElement client_existent;

    @FindBy(xpath= "//*[@id=\"content\"]/div[2]/div[2]/form/div/input[1]")
    private  WebElement email_input;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/form/div/input[2]")
    private WebElement password_input;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/form/div/input[3]")
    private WebElement authenticationButton;

    @FindBy(partialLinkText = "conectat")
    private WebElement authenticationMessageElement;


    @FindBy(xpath="//*[@id=\"container\"]/div[2]")
    private WebElement warningMessageElement;


    public AuthenticationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login (String email, String password) {
        waitUntilElementVisible(client_existent);
        this.enterEmail(email);
        this.enterPassword(password);
        this.submit();

    }

    public void enterEmail(String email) {
        waitUntilElementVisible(email_input);
        System.out.println("Entering email: " + email);
        email_input.clear();
        email_input.sendKeys(email);
    }

    public void enterPassword(String password){
        waitUntilElementVisible(password_input);
        System.out.println("Entering password: " + password);
        password_input.clear();
        password_input.sendKeys(password);
    }

    public void submit(){

        authenticationButton.click();
    }

    public boolean verifyLoginSuccessful(String name) {

        waitUntilElementVisible(authenticationMessageElement);
        System.out.println("Authentication successful with message: " + '"' + authenticationMessageElement.getText() + '"');
        return authenticationMessageElement.isDisplayed();
    }
    public boolean verifyLoginFailed(String errorMessage) {
        waitUntilElementVisible(warningMessageElement);
       System.out.println("Authentication failed with message: " + '"' + warningMessageElement.getText()+ '"');
       return warningMessageElement.getText().equalsIgnoreCase(errorMessage);
    }
}

