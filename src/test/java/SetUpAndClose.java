import api.User;
import api.UserSteps;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static constants.RandomData.*;

public class SetUpAndClose {

    public WebDriver driver;
    public UserSteps userSteps;
    public String accessToken;
    public User user;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe"); //для запуска тестов в Яндекс браузере нужно раскомментировать эту строку
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new User(RANDOM_EMAIL, RANDOM_PASS, RANDOM_NAME);
        userSteps = new UserSteps();
        ValidatableResponse validatableResponse = userSteps.createUser(user);
        accessToken = userSteps.getAccessToken(validatableResponse);
    }

    @After
    public void close() {
        userSteps.deletingUsersAfterTests(accessToken);
        driver.quit();
    }
}
