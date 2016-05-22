package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alena on 17.05.2016.
 */
public class SearchPage extends AbstractPage {
    private final String BASE_URL = "https://ok.ru/search";

    @FindBy(id = "query_usersearch")
    private WebElement searchField;

    //@FindBy(id = "lsBtn")
    //private WebElement searchButton;

    @FindBy(xpath = ".//*[@id='locationItems']/li[2]/span")
    private WebElement locationItem;

    @FindBy(id = "gs_result_list")
    private WebElement searchUser;



    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        //logger.info("Login page opened");
    }

    public void search(String searchobject) {
        searchField.sendKeys(searchobject);
        //searchButton.click();
        locationItem.click();
    }

    public boolean getUserSearch() {
        return searchUser.isDisplayed();
    }
}
