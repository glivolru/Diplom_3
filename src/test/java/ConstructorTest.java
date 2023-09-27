import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_obj.MainPage;


public class ConstructorTest extends BaseWebDriver {
    MainPage mainPage;

    @Before
    public void setUp() {
        initializationWebDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    public void testActiveSauceInConstructor() {
        mainPage.clickSauce();
        Assert.assertTrue("Не зашел в Соусы", mainPage.isSauceActive());
    }

    @Test
    @DisplayName("Перехода в раздел 'Начинки'")
    public void testActiveFillingInConstructor() {
        mainPage.clickFilling();
        Assert.assertTrue("Не зашел в Начинки", mainPage.isFillingActive());
    }

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void testActiveBunInConstructor() {
        mainPage.clickFilling();
        mainPage.clickBun();
        Assert.assertTrue("Не зашел в Булки", mainPage.isBunActive());
    }
}

