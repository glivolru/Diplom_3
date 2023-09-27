import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_obj.LoginPage;
import page_obj.MainPage;
import page_obj.RecoveryPassPage;
import page_obj.RegPage;
import pens.PensUser;
import serialization.SerializationUser;


public class LoginTest extends BaseWebDriver {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegPage regPage;
    private PensUser pensUser;

    @Before
    public void setUp() {
        initializationWebDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        regPage = new RegPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");

        String name = "Ivan";
        email = "ivanglushenkov@yandex.ru";
        password = "qwerty12345";
        pensUser = new PensUser(email, password, name);
        SerializationUser.createUser(pensUser);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginOnMainPage() {
        mainPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testLoginByPersonalButton() {
        mainPage.clickPersonal();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход на странице регистрации")
    public void testLoginOnRegistrationPage() {
        mainPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.clickRegister();
        regPage.waitForLoad();
        regPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход на странице восстановления пароля")
    public void testLoginOnResetPasswordPage() {
        RecoveryPassPage recoveryPassPage = new RecoveryPassPage(driver);

        mainPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.clickReset();
        recoveryPassPage.waitForLoad();
        recoveryPassPage.clickLogin();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не отобразилась", mainPage.isOrderButtonVisible());
    }
}
