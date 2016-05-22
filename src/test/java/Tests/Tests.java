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
    public void cSearchUser() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.searchObject(SEARCHNAME);
        Assert.assertTrue(steps.isSearchPageIn());
    }

    @Test
    public void dAddUser() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.addFriend();
        Assert.assertTrue(steps.isUserAddIn());
    }

    @Test
    public void eSendMessage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.sendMessage(MESSAGE);
        Assert.assertTrue(steps.isMessageSent());
    }

    @Test
    public void fSeePhoto() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeUserPhoto();
        Assert.assertTrue(steps.isPhotoSee());
    }

    @Test
    public void gSetKlass() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeUserPhoto();
        steps.setKlassToPhoto();
        Assert.assertTrue(steps.isKlassSet());
    }

    @Test
    public void hSetMark() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeUserPhoto();
        steps.setMarkToPhoto();
        Assert.assertTrue(steps.isMarkSet());
    }

    @Test
    public void iSeeNotifications() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeNotifications();
        Assert.assertTrue(steps.isNotificationSee());
    }

    @Test
    public void jLogOut() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.logOut();
        Assert.assertTrue(steps.isLogOUt());
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
