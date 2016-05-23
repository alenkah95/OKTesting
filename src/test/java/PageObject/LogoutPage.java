package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

/**
 * Created by Alena on 22.05.2016.
 */
public class LogoutPage extends AbstractPage {
    private final Logger logger = Logger.getLogger(LogoutPage.class.getName());
    private final String BASE_URL = "https://ok.ru/";

    @FindBy(xpath = ".//*[@id='mailRuToolbar']/table/tbody/tr/td[2]/a[2]")
    private WebElement exitBtn;

    @FindBy(id = "hook_FormButton_logoff.confirm_not_decorate")
    private WebElement logout;

    @FindBy(id = "enterHeader")
    private WebElement enterHeader;

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Logout page opened");
    }

    public void logout() {
        exitBtn.click();
        logout.click();

        logger.info("User Logout");
    }

    public boolean isEnterHeaderDisplay() {
        return enterHeader.isDisplayed();
    }


}
