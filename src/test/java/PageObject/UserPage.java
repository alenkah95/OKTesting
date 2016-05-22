package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

/**
 * Created by Alena on 22.05.2016.
 */
public class UserPage extends AbstractPage {
    private final Logger logger = Logger.getLogger(LoginPage.class.getName());
    private final String BASE_URL = "https://ok.ru/profile/354527805478";

    @FindBy(xpath = ".//*[@id='action_menu_add_friend']/a")
    private WebElement addUserButton;

    @FindBy(id = "nohook_modal_close")
    private WebElement closeAddFriend;

    @FindBy(xpath = ".//*[@id='action_menu_write_message_a']/span")
    private WebElement messageBtn;

    @FindBy(id = "ok-e-m")
    private WebElement messageText;

    @FindBy(xpath = ".//*[@id='topPanelPopup_m']/div[2]/div/div[1]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[3]")
    private WebElement sendMessageBtn;

    @FindBy(xpath = ".//*[@id='hook_Block_MiddleColumnTopCard_MenuFriend']/div/a[3]")
    private WebElement photosBtn;

    @FindBy(id = "img_815980485158")
    private WebElement idPhoto;

    @FindBy(id = "hook_Block_KlassOverPLB")
    private WebElement klassBtn;

    @FindBy(xpath = "//*[@id='hook_Block_PopLayerViewFriendPhotoRating']/a[2]")
    private WebElement markBtn;

    @FindBy(xpath = "//*[@id='action_menu_friendship_request_sent_a']/span")
    private WebElement userAdd;

    @FindBy(xpath = "//*[@id='hook_Block_PopLayerViewFriendPhotoRating']/span[2]")
    private WebElement setMark;

    @FindBy(xpath = "//*[@id='__plpcte_target']")
    private WebElement imgPhoto;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("User page opened");
    }

    public void addUser() {
        addUserButton.click();
        closeAddFriend.click();
        logger.info("User id added");
    }

    public void sendMessage(String mText) {
        messageBtn.click();
        messageText.sendKeys(mText);
        sendMessageBtn.click();
        logger.info("Messsage is send");
    }

    public void seePhoto() {
        photosBtn.click();
        idPhoto.click();
        logger.info("Photo See");
    }

    public void setKlassToPhoto() {
        klassBtn.click();
        logger.info("Klass");
    }

    public void setMarkToPhoto() {
        //markBtn.click();
        logger.info("Mark 5");
    }

    public boolean getUserAdd() {
        return closeAddFriend.isDisplayed();
    }

    public boolean getMessageText() {
        return messageText.isDisplayed();
    }

    public boolean getImgPhoto() {
        return imgPhoto.isDisplayed();
    }

    public boolean getKlassBtn() {
        return klassBtn.isDisplayed();
    }

    public boolean getSetMark() {
        return setMark.isDisplayed();
    }
}
