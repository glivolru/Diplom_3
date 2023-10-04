import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.UserPage;
import pom.RegPage;
import pens.PensUser;
import serialization.SerializationUser;

public class UserTest extends BaseWebDriver {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegPage regPage;
    private UserPage personalPage;
    private PensUser pensUser;

    @Before
    public void setUp() {
        initializationWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        regPage = new RegPage(driver);
        personalPage = new UserPage(driver);

        String name = "Ivan";
        email = "ivanglushenkov@yandex.ru";
        password = "qwerty12345";
        pensUser = new PensUser(email, password, name);
        SerializationUser.createUser(pensUser);

        mainPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
    }

    @Test
    @DisplayName("Переход по клику в «Личный кабинет».")
    public void testEnterPersonalAccount() {
        mainPage.clickPersonal();
        personalPage.waitForLoad();
        Assert.assertTrue("Перехода в ЛК нет", personalPage.isProfileButtonVisible());
    }

    @Test
    @DisplayName("Переход из ЛК в конструктор по кнопке «Конструктор»")
    public void testEnterConstructorByConstructorButton() {
        mainPage.clickPersonal();
        personalPage.waitForLoad();
        personalPage.clickConstructor();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не выполнен", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Переход из ЛК в конструктор по клику на логотип")
    public void testEnterConstructorByLogo() {
        mainPage.clickPersonal();
        personalPage.waitForLoad();
        personalPage.clickLogo();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не выполнен", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Выхода по кнопке 'Выход'")
    public void testLogoutByButtonLogout() {
        mainPage.clickPersonal();
        personalPage.waitForLoad();
        personalPage.clickLogout();
        loginPage.waitForLoad();
        Assert.assertTrue("Выхода нет", loginPage.isEnterLabelVisible());
    }
}
