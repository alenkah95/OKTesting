package PageObject;

import org.openqa.selenium.WebDriver;

/**
 * Created by Alena on 16.05.2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void openPage();
}
