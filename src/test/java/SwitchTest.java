import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

public class SwitchTest extends SetUpAndClose {

    @Test
    @DisplayName("Проверь переход по клику на кнопку «Личный кабинет»")
    @Description("Checking that we get to the authorization page, where the inscription Войти is displayed")
    public void shouldBeCheckClickOnPersonalAccButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    @Description("Checking the transition from your personal account to the main page by clicking the Constructor button")
    public void shouldBeSwitchFromProfileByClickDesignerButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор через логотип")
    @Description("Checking the transition from your personal account to the main page by clicking the logo")
    public void shouldBeSwitchFromProfileByClickLogoBurger() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

}
