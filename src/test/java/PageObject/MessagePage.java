package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alena on 22.05.2016.
 */
public class MessagePage extends AbstractPage {
    private final String BASE_URL = "https://ok.ru/profile/354527805478";

    // @FindBy(xpath = ".//*[@id='hook_ToolbarIconMessages_ToolbarMessages']/div[2]/div")
    // private WebElement messageBar;

    @FindBy(xpath = ".//*[@id='action_menu_write_message_a']/span")
    private WebElement messageBtn;

    @FindBy(id = "ok-e-m")
    private WebElement messageText;

    @FindBy(xpath = ".//*[@id='topPanelPopup_m']/div[2]/div/div[1]/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[3]")
    private WebElement sendMessageBtn;

    public MessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void sendMessage(String mText) {
        messageBtn.click();
        messageText.sendKeys(mText);
        sendMessageBtn.click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    //*[@id="hook_ToolbarIconMessages_ToolbarMessages"]/div[2]/div

}
