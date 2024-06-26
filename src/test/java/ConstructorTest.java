import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe"); //для запуска тестов в Яндекс браузере нужно раскомментировать эту строку
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    @Description("Checking if the button is selected by getting the text")
    public void shouldBeMenuBunIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    @Description("Checking if the button is selected by getting the text")
    public void shouldBeMenuSaucesIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickSaucesButton();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    @Description("Checking if the button is selected by getting the text")
    public void shouldBeMenuFillingIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesButton();
        mainPage.clickFillingsButton();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
