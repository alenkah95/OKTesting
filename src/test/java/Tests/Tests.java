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
    private final String SEARCHNAME = "Alena Khudnitskaya";
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

    @Test(description = "Search user by name")
    public void bSearchUser() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.searchObject(SEARCHNAME);
        Assert.assertTrue(steps.isSearchPageIn());
    }

    @Test(description = "Add user to friends")
    public void cAddUser() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.addFriend();
        Assert.assertTrue(steps.isUserAddIn());
    }

    @Test(description = "Send message to user")
    public void dSendMessage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.sendMessage(MESSAGE);
        Assert.assertTrue(steps.isMessageSent());
    }

    @Test(description = "See user photo")
    public void eSeePhoto() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeUserPhoto();
        Assert.assertTrue(steps.isPhotoSee());
    }

    @Test(description = "Set Klass to user photo")
    public void fSetKlass() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeUserPhoto();
        steps.setKlassToPhoto();
        Assert.assertTrue(steps.isKlassSet());
    }

    @Test(description = "Set Mark to user photo")
    public void gSetMark() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeUserPhoto();
        steps.setMarkToPhoto();
        Assert.assertTrue(steps.isMarkSet());
    }

    @Test(description = "Go to MyPage")
    public void hMyPage() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.goToMyPage();
        Assert.assertTrue(steps.isMyPageIn());
    }

    @Test(description = "See my notifications")
    public void iSeeNotifications() {
        steps.loginOK(USERNAME, PASSWORD);
        steps.seeNotifications();
        Assert.assertTrue(steps.isNotificationSee());
    }

    @Test(description = "Logout from OK")
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
