package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alena on 22.05.2016.
 */
public class UserPage extends AbstractPage {
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

    @FindBy(id = "img_817020919846")
    private WebElement idPhoto;

    @FindBy(id = "hook_Block_KlassOverPLB")
    private WebElement klassBtn;

    @FindBy(id = "hook_Block_PopLayerViewFriendPhotoRating")
    private WebElement markBtn;


    @FindBy(xpath = ".//*[@id='action_menu_friendship_request_sent_a']/span")
    private WebElement userAdd;

    @FindBy(id = "__plpcte_targe")
    private WebElement imgPhoto;

    public UserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        //logger.info("Login page opened");
    }

    public void addUser() {
        addUserButton.click();
        closeAddFriend.click();
    }

    public void sendMessage(String mText) {
        messageBtn.click();
        messageText.sendKeys(mText);
        sendMessageBtn.click();
    }

    public void seePhoto() {
        photosBtn.click();
        idPhoto.click();
    }

    public void setKlassToPhoto() {
        klassBtn.click();
    }

    public void setMarkToPhoto() {
        markBtn.click();
    }

    public boolean getUserAdd() {
        return userAdd.isDisplayed();
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

    public boolean getMarkBtn() {
        return markBtn.isDisplayed();
    }
}
