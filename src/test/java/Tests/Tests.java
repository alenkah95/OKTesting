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
    private final String MESSAGE = "TEST";

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
    public void dSearchUser() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.searchObject(SEARCHNAME);
        Assert.assertTrue(steps.isSearchPageIn());
    }

    @Test
    public void eAddUser() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.addFriend();
        Assert.assertTrue(steps.isUserAddIn());
    }

    @Test
    public void fSendMessage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.sendMessage(MESSAGE);
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
