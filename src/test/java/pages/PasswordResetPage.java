package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage extends BasePage{
    @FindBy(linkText = "Parola Uitata")
    private WebElement passwordResetLink;

    @FindBy(xpath = "//*[@id=\"popdown_ok\"]")
    private  WebElement AcceptCookies;

    @FindBy(xpath = "/html/body/div[2]/div[5]/div[3]/form/div[1]/table/tbody/tr/td[2]/input")
    private WebElement emailField;

    @FindBy(xpath = "//input[@value='Continuare']")
    private WebElement passwordResetSubmitButton;

    @FindBy(xpath ="//div[@class='success']" )
    private WebElement resetSuccessfulMessage;

    @FindBy(xpath = "//div[@class='warning']")
    private WebElement resetFailedMessage;

    public PasswordResetPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void resetPassword (String email){
        this.acceptCookies();
        this.passwordReset(email);
        this.enterResetEmail(email);
        this.passwordResetSubmit();
    }

    public void acceptCookies(){
        waitUntilElementVisible(AcceptCookies);
        System.out.println("Accepting cookies");
        AcceptCookies.click();
    }

    public void passwordReset(String email){
        waitUntilElementVisible(passwordResetLink);
        System.out.println("Clicking on password reset link");
        passwordResetLink.click();
    }

    public void enterResetEmail(String email){
        waitUntilElementVisible(emailField);
        System.out.println("Entering email for existing account" + email);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void passwordResetSubmit(){
        System.out.println("Submitting reset");
        passwordResetSubmitButton.click();
    }

    public boolean verifyResetSuccessful(String email){
        waitUntilElementVisible(resetSuccessfulMessage);
        System.out.println("Reset successful with message: " + resetSuccessfulMessage.getText()+ '"');
        return resetSuccessfulMessage.isDisplayed();
    }

    public boolean verifyResetFailed(String errorMessage){
        waitUntilElementVisible(resetFailedMessage);
        System.out.println("Error message displayed: " + resetFailedMessage.getText() + '"');
        return resetFailedMessage.getText().equalsIgnoreCase(errorMessage);
    }
}
