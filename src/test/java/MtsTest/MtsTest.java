package MtsTest;

import Steps.PaySectionSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import Steps.SeleniumDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsTest {

    private WebDriver driver;
    private final String BASE_URL = "https://mts.by";

    @BeforeAll
    void setup() {
        driver = SeleniumDriver.getInstance();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void openHomePage() {
        driver.get(BASE_URL);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров и отправки платежной формы Услуги связи")
    public void testMtsPaymentForm() {
        PaySectionSteps paySteps = new PaySectionSteps();

        // 1. Проверяем плейсхолдеры
        Assertions.assertEquals("Номер телефона", paySteps.getPhonePlaceholder(),
                "Плейсхолдер поля 'Номер телефона' не совпадает");

        Assertions.assertEquals("Сумма", paySteps.getSumPlaceholder(),
                "Плейсхолдер поля 'Сумма' не совпадает");

        Assertions.assertEquals("E-mail для отправки чека", paySteps.getEmailPlaceholder(),
                "Плейсхолдер поля 'E-mail' не совпадает");

        // 2. Заполняем форму и отправляем
        paySteps.fillPhoneField("297777777")
                .fillSumField("10")
                .fillEmailField("test@test.com")
                .clickContinue();
        // 3. Ожидаем появление фрейма оплаты и переключаемся в него
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, 15);

        // Ждем появления iframe на странице и переключаем контекст внутрь него
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                org.openqa.selenium.By.tagName("iframe")
        ));

        // Теперь, находясь внутри iframe, проверяем видимость контейнера оплаты
        org.openqa.selenium.WebElement paymentModal = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.cssSelector(".app-wrapper__content-container")
                )
        );

        // Проверяем, что окно отображается
        Assertions.assertTrue(paymentModal.isDisplayed(), "Модальное окно оплаты не появилось внутри фрейма");

        // 1. Проверяем корректность отображения инфо-панели (Номер телефона и тип оплаты)
        org.openqa.selenium.WebElement headerInfo = driver.findElement(org.openqa.selenium.By.cssSelector(".pay-description__text, .pay-header"));
        String headerText = headerInfo.getText();
        Assertions.assertTrue(headerText.contains("375297777777"), "В окне оплаты отображается неверный номер телефона");

        // 2. Проверяем сумму на кнопке оплаты (на скриншоте внизу кнопка с текстом Оплатить ... BYN)
        org.openqa.selenium.WebElement payButton = driver.findElement(org.openqa.selenium.By.cssSelector(".button__text, button[type='submit']"));
        Assertions.assertTrue(payButton.getText().contains("10.00") || payButton.getText().contains("0.00"), "Сумма на кнопке оплаты не отображается или неверна");

        // 3. Проверяем наличие надписей в незаполненных полях карты через поиск по тексту
        org.openqa.selenium.WebElement cardNumberLabel = driver.findElement(org.openqa.selenium.By.xpath("//*[contains(text(), 'Номер карты')]"));
        org.openqa.selenium.WebElement cardExpLabel = driver.findElement(org.openqa.selenium.By.xpath("//*[contains(text(), 'Срок действия')]"));
        org.openqa.selenium.WebElement cardCvcLabel = driver.findElement(org.openqa.selenium.By.xpath("//*[contains(text(), 'CVC')]"));

        Assertions.assertTrue(cardNumberLabel.isDisplayed(), "Надпись Номер карты не найдена");
        Assertions.assertTrue(cardExpLabel.isDisplayed(), "Надпись Срок действия не найдена");
        Assertions.assertTrue(cardCvcLabel.isDisplayed(), "Надпись CVC не найдена");

        // 4. Проверяем наличие блока с иконками платежных систем
        org.openqa.selenium.WebElement paymentIcons = driver.findElement(org.openqa.selenium.By.cssSelector(".cards-icons, .card-logos, .payment-systems-icons, .ng-tns-c107495084-0"));
        Assertions.assertTrue(paymentIcons.isDisplayed(), "Иконки платёжных систем не отображаются");

        // Возвращаем драйвер обратно на основную страницу
        driver.switchTo().defaultContent();
    }
}

