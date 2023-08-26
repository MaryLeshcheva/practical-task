package positive_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    private static ChromeOptions co;

    @BeforeAll
    public static void init() {
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "\\src\\test\\resources\\chromedriver.exe";

        co = new ChromeOptions();
        co.setBinary(chromeDriverPath);
    }

    @BeforeEach
    public void openMainPage() {
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/");
    }

    @AfterEach
    public void close() {
        driver.quit();
        System.out.print("Test is closed");
    }

}
