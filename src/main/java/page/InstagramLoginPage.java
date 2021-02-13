package page;

import org.openqa.selenium.WebDriver;

public class InstagramLoginPage extends PageObject{

    public InstagramLoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIntoAccount (String username, String password) {
        fillInputAfterInteractable(locator.LOGIN_USERNAME_INPUT, username);
        fillInputAfterInteractable(locator.LOGIN_PASSWORD_INPUT, password);
//        fillInput(locator.PROFILE_LOGIN_USERNAME_INPUT, username);
//        fillInput(locator.PROFILE_LOGIN_PASSWORD_INPUT, password);

        clickElementAfterClickable(locator.LOGIN_BUTTON);
//        clickElement(locator.PROFILE_LOGIN_BUTTON);
    }
}
