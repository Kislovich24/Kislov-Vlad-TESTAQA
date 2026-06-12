package Steps;

import org.openqa.selenium.support.PageFactory;
import Page.PaySectionPage;

public class PaySectionSteps {
    private final PaySectionPage paySectionPage;

    public PaySectionSteps() {
        // Инициализируем элементы через PageFactory
        this.paySectionPage = PageFactory.initElements(SeleniumDriver.getInstance(), PaySectionPage.class);
    }

    public String getPhonePlaceholder() {
        return paySectionPage.getPhoneField().getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return paySectionPage.getSumField().getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return paySectionPage.getEmailField().getAttribute("placeholder");
    }

    public PaySectionSteps fillPhoneField(String phone) {
        paySectionPage.getPhoneField().sendKeys(phone);
        return this;
    }

    public PaySectionSteps fillSumField(String sum) {
        paySectionPage.getSumField().sendKeys(sum);
        return this;
    }

    public PaySectionSteps fillEmailField(String email) {
        paySectionPage.getEmailField().sendKeys(email);
        return this;
    }

    public void clickContinue() {
        org.openqa.selenium.WebElement button = paySectionPage.getSubmitButton();
        org.openqa.selenium.JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) SeleniumDriver.getInstance();
        executor.executeScript("arguments[0].click();", button);
    }
}


