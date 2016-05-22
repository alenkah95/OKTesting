package Tests;

import Steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Alena on 16.05.2016.
 */
public class Tests {
    private final String USERNAME = "alenkah95Testing";
    private final String PASSWORD = "alenkah95";
    private final String SEARCHNAME = "Алёна Худницкая";

    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Login to OK")
    public void aLogin() {
        steps.loginOK(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
    }

    @Test(description = "Go to MyPage")
    public void bMyPage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.goToMyPage();
        Assert.assertTrue(steps.isMyPageIn());
    }

    @Test
    public void cFriendPage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.goToFriendPage();
        Assert.assertTrue(steps.isFriendPageIn());
    }

    @Test
    public void dSearchPage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.searchObject(SEARCHNAME);
        Assert.assertTrue(steps.isSearchPageIn());
    }

    @Test
    public void eUserPage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.searchObject(SEARCHNAME);
        steps.addSearchFriend();
        Assert.assertTrue(steps.isUserAddIn());
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
