package Steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Objects;

public class SeleniumDriver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ChromeOptions options;

    public static WebDriver getInstance() {
        if (Objects.isNull(driver.get())) {
            WebDriverManager.chromedriver().setup();

            if (options == null) {
                options = new ChromeOptions();
            }
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }
}