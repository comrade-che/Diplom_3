import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

public class LogoutTest extends SetUpAndClose {

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    @Description("We check that after exiting the profile, the authorization page is displayed - Вход")
    public void shouldBeLogoutSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

}
