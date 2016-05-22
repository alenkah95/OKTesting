package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alena on 22.05.2016.
 */
public class LogoutPage extends AbstractPage {
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

    public void logout() {
        exitBtn.click();
        logout.click();
    }

    public boolean getEnterHeader() {
        return enterHeader.isDisplayed();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
