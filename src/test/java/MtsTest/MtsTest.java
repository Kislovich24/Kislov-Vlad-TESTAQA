package MtsTest;

import Steps.PaySectionSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import Steps.SeleniumDriver;

@Epic("Тестирование сайта МТС")
@Feature("Проверка формы оплаты")
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
    @Owner("Кислов Владислав")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка плейсхолдеров и отправки платежной формы Услуг")
    @Description("Тест проверяет корректность названий плейсхолдеров, а также появление ошибок валидации.")
    @Link(name = "Сайт МТС", url = "https://mts.by")
    public void testMtsPaymentForm() {
        PaySectionSteps paySteps = new PaySectionSteps();{
            paySteps = new PaySectionSteps();
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

            // 3. Проверяем, что форма отправилась (URL изменился)
            Assertions.assertNotEquals(BASE_URL, driver.getCurrentUrl(),
                    "Страница не изменилась после нажатия кнопки Продолжить");
        }

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

        // Возвращаем драйвер обратно на основную страницу
        driver.switchTo().defaultContent();

        // 3. Проверяем, что форма отправилась (URL изменился)
        Assertions.assertNotEquals(BASE_URL, driver.getCurrentUrl(),
                "Страница не изменилась после нажатия кнопки Продолжить");

    }
}
