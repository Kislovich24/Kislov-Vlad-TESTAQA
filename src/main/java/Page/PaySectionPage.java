package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaySectionPage {

    @FindBy(id = "connection-phone")
    private WebElement phoneField;

    @FindBy(id = "connection-sum")
    private WebElement sumField;

    @FindBy(id = "connection-email")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement submitButton;

    public WebElement getPhoneField() { return phoneField; }
    public WebElement getSumField() { return sumField; }
    public WebElement getEmailField() { return emailField; }
    public WebElement getSubmitButton() { return submitButton; }
}
