package Steps;

import PageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Alena on 16.05.2016.
 */
public class Steps {
    private final Logger logger = Logger.getLogger(Steps.class.getName());
    private WebDriver driver;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver() {
        driver.quit();
    }

    public void loginOK(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName());
    }

    public void goToMyPage() {
        MyPage myPage = new MyPage(driver);
        myPage.clickOnMyPage();
    }

    public boolean isMyPageIn() {
        MyPage myPage = new MyPage(driver);
        return (myPage.getAboutMyInfo());
    }

    public void goToFriendPage() {
        FriendPage friendPage = new FriendPage(driver);
        friendPage.clickOnFriendPage();
    }

    public boolean isFriendPageIn() {
        FriendPage friendPage = new FriendPage(driver);
        return (friendPage.getAllFriend());
    }

    public void searchObject(String searchoO) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(searchoO);
    }

    public boolean isSearchPageIn() {
        SearchPage searchPage = new SearchPage(driver);
        return (searchPage.getUserSearch());
    }

    public void addSearchFriend() {
        UserPage userPage = new UserPage(driver);
        userPage.addUser();
    }

    public boolean isUserAddIn() {
        UserPage userPage = new UserPage(driver);
        return (userPage.getUserAdd());
    }
}

