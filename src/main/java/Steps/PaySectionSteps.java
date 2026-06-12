package Steps;

import org.openqa.selenium.support.PageFactory;
import Page.PaySectionPage;
import io.qameta.allure.Step;

public class PaySectionSteps {
    private final PaySectionPage paySectionPage;

    public PaySectionSteps() {
        // Инициализируем элементы через PageFactory
        this.paySectionPage = PageFactory.initElements(SeleniumDriver.getInstance(), PaySectionPage.class);
    }

    @Step("Получить плейсхолдер поля ввода телефона")
    public String getPhonePlaceholder() {
        return paySectionPage.getPhoneField().getAttribute("placeholder");
    }
    @Step("Получить плейсхолдер поля ввода суммы")
    public String getSumPlaceholder() {
        return paySectionPage.getSumField().getAttribute("placeholder");
    }
    @Step("Получить плейсхолдер поля ввода Email")
    public String getEmailPlaceholder() {
        return paySectionPage.getEmailField().getAttribute("placeholder");
    }
    @Step("Заполнить поле телефона: {phone}")


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

    @Step("Заполнить поле суммы значением: {sum}")
    public PaySectionSteps fillSumField(String sum) {
        paySectionPage.getSumField().sendKeys(sum);
        return this;
    }

    @Step("Заполнить поле Email: {email}")
    public PaySectionSteps fillEmailField(String email) {
        paySectionPage.getEmailField().sendKeys(email);
        return this;
    }

    @Step("Нажать кнопку 'Продолжить'")
    public void clickContinue() {
        org.openqa.selenium.WebElement button = paySectionPage.getSubmitButton();
        org.openqa.selenium.JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) SeleniumDriver.getInstance();
        executor.executeScript("arguments[0].click();", button);
    }
}


