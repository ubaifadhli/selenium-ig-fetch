package page;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class InstagramPostPage extends PageObject{
    public InstagramPostPage(WebDriver driver) {
        super(driver);
    }

    public boolean doesPostHasMultipleMedia () {
        return doesElementExist(locator.POST_MEDIA_DOTS);
    }

    public int getMediaCount () {
        return getElementsSize(locator.POST_MEDIA_DOTS);
    }

    public String getImageUrl () {
        return getAttributeFromElement(locator.POST_IMAGE, ATTRIBUTE_SOURCE);
    }

    public void clickNextMediaButton () {
        clickElement(locator.POST_NEXT_MEDIA_BUTTON);
    }

    public List<String> getCurrentImagesUrl () {
        return getElementsAttribute(locator.POST_IMAGES, ATTRIBUTE_SOURCE);
    }
}
