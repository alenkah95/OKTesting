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

    @FindBy(xpath = ".//*[@id='action_menu_friendship_request_sent_a']/span")
    private WebElement userAdd;

    //.//*[@id='nohook_modal_close']

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

    public boolean getUserAdd() {
        return userAdd.isDisplayed();
    }
}
