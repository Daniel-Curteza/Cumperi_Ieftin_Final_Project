package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    String name="qwerty";

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/h2")
    private WebElement client_existent;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/form/div/input[1]")
    private WebElement email_input;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/form/div/input[2]")
    private WebElement password_input;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/form/div/input[3]")
    private WebElement authenticationButton;

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/div[1]/span")
    private WebElement connected;

    Actions actions;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void login (String email, String password){
        waitUntilElementVisible(client_existent);
        this.enterEmail(email);
        this.enterPassword(password);
        this.submit();
    }

    public void enterEmail(String email){
        waitUntilElementVisible(email_input);
        email_input.clear();
        email_input.sendKeys(email);
    }

    public void enterPassword(String password){
        waitUntilElementVisible(password_input);
        email_input.clear();
        email_input.sendKeys(password);
    }

    public void submit(){
        wait.until(ExpectedConditions.elementToBeClickable(authenticationButton));
        authenticationButton.click();
    }

    public boolean loginSuccessful () {
        return connected.isDisplayed();

    }
}

