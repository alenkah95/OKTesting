package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alena on 22.05.2016.
 */
public class UserPage extends AbstractPage {
    private final String BASE_URL = "https://ok.ru/";
    @FindBy(xpath = ".//*[@id='locationItems']/li[2]/span")
    private WebElement locationItem;

    @FindBy(xpath = ".//*[@id='gs_result_list']/div[1]/div/div/div[2]/div[1]/div[1]/a")
    private WebElement findUser;

    @FindBy(xpath = ".//*[@id='action_menu_add_friend']/a")
    private WebElement addUserButton;

    @FindBy(xpath = ".//*[@id='action_menu_friendship_request_sent_a']/span")
    private WebElement userAdd;

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
        locationItem.click();
        findUser.click();
        addUserButton.click();
    }

    public boolean getUserAdd() {
        return userAdd.isDisplayed();
    }
}
