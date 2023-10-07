import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.RegPage;


public class RegistrationTest extends BaseWebDriver {
    MainPage mainPage;
    LoginPage loginPage;
    RegPage regPage;

    @Before
    public void setUp() {
        initializationWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        regPage = new RegPage(driver);

        mainPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.clickRegister();
        regPage.waitForLoad();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void testRegisterNewUser() {
        String name = "Ivan";
        email = "ivanglushenkov@yandex.ru";
        password = "qwerty12345";

        regPage.fillRegistrationForm(name, email, password);
        regPage.clickRegisterButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Регистрация не прошла", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Негативная проверка минимального кол-ва символов пароля (6)")
    public void testErrorWrongPassword() {
        String name = "Ivan";
        email = "ivanglushenkov@yandex.ru";
        password = "qwert";
        regPage.fillRegistrationForm(name, email, password);
        regPage.clickRegisterButton();
        Assert.assertTrue("Ошибка не отобразилась",
                regPage.isIncorrectPasswordLabelVisible());
    }
}
