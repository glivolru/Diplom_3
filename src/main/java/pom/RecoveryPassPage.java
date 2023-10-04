package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPassPage extends BasePage {

    public RecoveryPassPage(WebDriver driver) {
        super(driver);
    }

    //Надпись Восстановление пароля
    private By recoveryPassword = By.xpath("//h2[text()='Восстановление пароля']");
    //Кнопка Войти
    private By buttonEnter = By.xpath("//a[@href='/login']");

    @Step("Клик по кнопке 'Войти'")
    public void clickLogin() {
        driver.findElement(buttonEnter).click();
    }

    @Step("Ожидание загрузки страницы 'Восстановления пароля'")
    public void waitForLoad() {
        waitForVisibility(recoveryPassword);
    }
}
