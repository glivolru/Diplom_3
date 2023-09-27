import api.Api;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pens.PensUser;
import serialization.SerializationUser;


public class BaseWebDriver {
    WebDriver driver;
    String email;
    String password;

    public void initializationWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/ivanglushenkov/Downloads/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(Api.BURGER_URL);
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
