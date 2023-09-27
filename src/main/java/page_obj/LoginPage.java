package page_obj;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Вход
    private By titleEnter = By.xpath("//h2[text()='Вход']");
    //Email
    private By emailField = By.xpath("//input[@name='name']");
    //Пароль
    private By passwordField = By.xpath("//input[@name='Пароль']");
    //Войти
    private By loginButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx " +
            "button_button_size_medium__3zxIa']");
    //Кнопка "Зарегистироваться"
    private By registerButton = By.xpath("//a[@href='/register']");
    //Кнопка "Восстановить пароль"
    private By recoverPasswordButton = By.xpath("//a[@href='/forgot-password']");
    //Лого
    private By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");

    @Step("Ожидание загрузки страницы авторизации")
    public void waitForLoad() {
        waitForVisibility(titleEnter);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    @Step("Заполнение полей авторизации")
    public void fillLoginForm(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на 'Восстановить пароль'")
    public void clickReset() {
        driver.findElement(recoverPasswordButton).click();
    }

    @Step("Проверка отображения 'Войти'")
    public boolean isEnterLabelVisible() {
        return driver.findElement(titleEnter).isDisplayed();
    }
}
