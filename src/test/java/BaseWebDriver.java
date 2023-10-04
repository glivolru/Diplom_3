import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pens.PensUser;
import pom.MainPage;
import serialization.SerializationUser;
import static api.Api.BURGER_URL;

public class BaseWebDriver {
    String email;
    String password;
    private final String chromeBrowser = "Chrome";
    private final String yandexBrowser = "Yandex";
    protected WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void initializationWebDriver() {
        WebDriverManager.chromedriver().setup();
        selectBrowser(yandexBrowser);
        mainPage = new MainPage(driver);
        driver.get(BURGER_URL);
        driver.manage().window().maximize();
    }

    public void selectBrowser(String browser) {
        if (browser.equals(yandexBrowser)) {
            driver = new ChromeDriver();
        } else if (browser.equals(chromeBrowser)) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        String accessToken = SerializationUser.loginUser(new PensUser(email, password)).then().extract().path("accessToken");
        if (accessToken != null) {
            SerializationUser.deleteUser(accessToken);
        }
        driver.quit();
    }
}
