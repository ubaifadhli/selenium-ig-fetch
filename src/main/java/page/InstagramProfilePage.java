package page;

import org.openqa.selenium.WebDriver;

public class InstagramProfilePage extends PageObject{
    public InstagramProfilePage (WebDriver driver) {
        super(driver);
    }

    public void clickProfilePictureButton () {
        clickElementAfterClickable(locator.PROFILE_PICTURE_BUTTON);
//        clickElement(locator.PROFILE_PICTURE_BUTTON);
    }

    public boolean isProfilePictureEnabled () {
        String ariaDisabledValue = getAttributeFromElement(locator.PROFILE_PICTURE_BUTTON, ATTRIBUTE_ARIA_DISABLED);

        return ariaDisabledValue.equals("false");
    }
}
