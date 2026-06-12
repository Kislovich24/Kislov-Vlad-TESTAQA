import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsTest {

    private WebDriver driver;
    private final String BASE_URL = "https://mts.by";

    @BeforeAll
    void setUp() {
        driver = SeleniumDriver.getInstance();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void openHomePage() {
        driver.get(BASE_URL);

        try {
            WebElement cookieBtn = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            if (cookieBtn.isDisplayed()) {
                cookieBtn.click();
            }
        } catch (Exception ignored) {}
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("1. Проверить название указанного блока")
    public void checkSectionTitle() {
        WebElement title = driver.findElement(By.xpath("//h2[normalize-space()='Онлайн пополнение без комиссии']"));
        assertTrue(title.isDisplayed(), "Заголовок блока не найден");
    }

    @Test
    @DisplayName("2. Проверить наличие логотипов платёжных систем")
    public void checkPaymentLogos() {
        List<WebElement> logos = driver.findElements(By.xpath(
                "//div[contains(@class, 'pay__partners')]//img | //div[contains(@class, 'payment__logos')]//img"
        ));
        assertTrue(!logos.isEmpty(), "Логотипы платёжных систем не отображаются");
    }

    @Test
    @DisplayName("3. Проверить работу ссылки «Подробнее о сервисе»")
    public void checkMoreInfoLink() {
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        link.click();

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("payment") || currentUrl.contains("help"), "Некорректный переход по ссылке");
    }

    @Test
    @DisplayName("4. Заполнить поля и проверить работу кнопки «Продолжить»")
    public void checkSubmitPhonePayment() {
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));

        phoneInput.sendKeys("297777777");
        sumInput.sendKeys("5");
        emailInput.sendKeys("test@example.com");

        assertTrue(submitButton.isEnabled(), "Кнопка 'Продолжить' недоступна");
        submitButton.click();

        String resultUrl = driver.getCurrentUrl();
        assertNotEquals(BASE_URL, resultUrl, "Форма не была отправлена");
    }
}
