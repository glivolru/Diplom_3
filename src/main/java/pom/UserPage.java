package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {

    public UserPage(WebDriver driver) {
        super(driver);
    }

    //Кнопка "Конструктор"
    private By constructorButton = By.xpath("//p[text()='Конструктор']");
    //Логотип
    private By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");
    //Кнопка "Профиль"
    private By profileButton = By.xpath("//a[@href='/account/profile']");
    //Кнопка "Выход"
    private By logoutButton = By.xpath("//li[@class='Account_listItem__35dAP']/button");

    @Step("Ожидание загрузки главной")
    public void waitForLoad() {
        waitForVisibility(profileButton);
    }

    @Step("Проверка отображения кнопки 'Профиль'")
    public boolean isProfileButtonVisible() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Клик по кнопке'Конструктор'")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по лого")
    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на кнопку 'Выйти'")
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
