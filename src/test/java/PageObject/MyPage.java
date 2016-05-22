package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

/**
 * Created by Alena on 17.05.2016.
 */
public class MyPage extends AbstractPage {
    private final Logger logger = Logger.getLogger(LoginPage.class.getName());
    private final String BASE_URL = "https://ok.ru/";

    @FindBy(xpath = ".//*[@id='hook_Block_MiddleColumnTopCardUser']/div/div/div[1]/div/span[1]/a/span")
    private WebElement myPageId;

    @FindBy(id = "ntf_toolbar_button")
    private WebElement notificationsBtn;

    @FindBy(id = "hook_Block_NotificationsLayerTitle")
    private WebElement notificationsTitle;

    @FindBy(id = "aboutPanel")
    private WebElement aboutMy;

    public MyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
//        logger.info("My page opened");
    }

    public void clickOnMyPage() {
        myPageId.click();
        logger.info("My page opened");
    }

    public void seeNotifications() {
        notificationsBtn.click();
        logger.info("Notification see");
    }
    public boolean getAboutMyInfo() {
        return aboutMy.isDisplayed();
    }

    public boolean getNotificationsTitle() {
        return (notificationsTitle.isDisplayed());
    }
}
