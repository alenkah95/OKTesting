package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;


/**
 * Created by Alena on 16.05.2016.
 */


public class LoginPage extends AbstractPage {


    private final Logger logger = Logger.getLogger(LoginPage.class.getName());
    private final String BASE_URL = "https://ok.ru/";

    @FindBy(id = "field_email")
    private WebElement inputLogin;

    @FindBy(id = "field_password")
    private WebElement inputPassword;

    @FindBy(xpath = ".//*[@id='loginContentBlock']/form/div[4]/input")
    private WebElement linkEnter;

    @FindBy(xpath = ".//*[@id='hook_Block_MiddleColumnTopCardUser']/div/div/div[1]/div/span[1]/a/span")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

    public void login(String username, String password) {

        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        linkEnter.click();

        logger.info("Login performed");
    }


    public boolean getLoggedInUserName() {
        return linkLoggedInUser.isDisplayed();
    }
}
