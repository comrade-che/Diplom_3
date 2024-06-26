import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.PasswordRecoveryPage;
import pageobject.RegistrationPage;

public class EntranceTest extends SetUpAndClose {

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    @Description("Login verification using the SignIn button on the main page with subsequent authorization")
    public void shouldBeLoginThroughSignInButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    @Description("Login verification using the Personal account button on the main page with subsequent authorization")
    public void shouldBeLoginThroughPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    @Description("Login verification in the registration form with subsequent authorization")
    public void shouldBeLoginThroughTheButtonInTheRegistrationForm() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        registrationPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    @Description("Login verification in the password recovery form with subsequent authorization")
    public void shouldBeLoginFromRecoveryPage() {
        PasswordRecoveryPage passRecoveryPage = new PasswordRecoveryPage(driver);
        passRecoveryPage.open();
        passRecoveryPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());

    }
}
