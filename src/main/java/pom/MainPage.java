package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Кнопка "Войти в аккаунт"
    private By logInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private By personalAccountButton = By.linkText("Личный Кабинет");
    //Кнопка "Булки"
    private By buttonBunActive = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Кнопка "Булки" задизаблена
    private By buttonBunInactive = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Кнопка"Соусы"
    private By buttonSauceActive = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Кнопка"Соусы" задизаблена
    private By buttonSauceInactive = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Кнопка "Начинки"
    private By buttonFillingActive = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //Кнопка "Начинки" задизаблена
    private By buttonFillingInactive = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    //"Соберите бургер"
    private By titleMakeBurger = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");
    //Кнопка "Оформить заказ"
    private By placeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    @Step("Клик на кнопку 'Войти в аккаунт' на главной")
    public void clickLogin() {
        driver.findElement(logInAccountButton).click();
    }

    @Step("Ожидание загрузки главной")
    public void waitForLoad() {
        waitForVisibility(titleMakeBurger);
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isOrderButtonVisible() {
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    @Step("Клик на кнопку 'Личный кабинет'")
    public void clickPersonal() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик на 'Соусы'")
    public void clickSauce() {
        driver.findElement(buttonSauceInactive).click();
    }

    @Step("Проверка состояния кнопки 'Соусы'")
    public boolean isSauceActive() {
        return driver.findElement(buttonSauceActive).isDisplayed();
    }

    @Step("Клик на 'Начинки'")
    public void clickFilling() {
        driver.findElement(buttonFillingInactive).click();
    }

    @Step("Проверка состояния кнопки 'Начинки'")
    public boolean isFillingActive() {
        return driver.findElement(buttonFillingActive).isDisplayed();
    }

    @Step("Клик на 'Булки'")
    public void clickBun() {
        driver.findElement(buttonBunInactive).click();
    }

    @Step("Проверка состояния кнопки 'Булки'")
    public boolean isBunActive() {
        return driver.findElement(buttonBunActive).isDisplayed();
    }

}
