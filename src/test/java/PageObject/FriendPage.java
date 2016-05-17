package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alena on 17.05.2016.
 */
public class FriendPage extends AbstractPage {
    private final String BASE_URL = "https://ok.ru/";

    @FindBy(xpath = ".//*[@id='hook_Block_MiddleColumnTopCard_MenuUser']/div/a[2]")
    private WebElement friendPageId;

    @FindBy (xpath = ".//*[@id='UserFriendsCatalogRB']/div/div/a[1]/div")
    private WebElement allFriends;

    public FriendPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnFriendPage() {
        friendPageId.click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public boolean getAllFriend() {
        return allFriends.isDisplayed();
    }
}
