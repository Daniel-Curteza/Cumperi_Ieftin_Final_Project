package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage extends BasePage{
    @FindBy(linkText = "Parola Uitata")
    private WebElement passwordResetLink;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@class='button']")
    private WebElement passwordResetSubmitButton;

    @FindBy(xpath ="//div[@class='success']" )
    private WebElement resetSuccessfulMessage;

    @FindBy(xpath = "//div[@class='warning']")
    private WebElement resetFailedMessage;

    public PasswordResetPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void reset (String email){
        this.passwordReset(email);
        this.enterResetEmail(email);
        this.passwordResetSubmit();
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
        emailField.sendKeys();
    }

    public void passwordResetSubmit(){
        System.out.println("Submitting reset");
        passwordResetSubmitButton.click();
    }

    public boolean verifyResetSuccessful(){
        waitUntilElementVisible(resetSuccessfulMessage);
        System.out.println("Reset successful with message: " + resetFailedMessage.getText()+ '"');
        return resetFailedMessage.isDisplayed();
    }

    public boolean verifyResetFailed(String errorMessage){
        waitUntilElementVisible(resetFailedMessage);
        System.out.println("Error message displayed: " + resetFailedMessage.getText() + '"');
        return resetFailedMessage.getText().equalsIgnoreCase(errorMessage);
    }
}
