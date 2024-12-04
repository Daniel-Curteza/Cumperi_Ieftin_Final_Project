package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.BaseTest;

public class ResetPage extends BaseTest {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement = resetEmailField;
}
