package page;

import org.openqa.selenium.WebDriver;

public class InstagramStoryPage extends PageObject{

    public InstagramStoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isStillOnPage () {
        return getCurrentUrl().contains("stories");
    }

    public int getStoryCount () {
        return getElementsSize(locator.STORY_MEDIA_BARS);
    }

    public void clickNextMediaButton () {
        clickElement(locator.STORY_NEXT_MEDIA_BUTTON);
    }

    private boolean isCurrentStoryAVideo () {
        return doesElementExist(locator.STORY_VIDEO);
    }

    public String getMediaUrl () {
        if (isCurrentStoryAVideo())
            return getAttributeFromElement(locator.STORY_VIDEO, ATTRIBUTE_SOURCE);
        else
            return getAttributeFromElement(locator.STORY_IMAGE, ATTRIBUTE_SOURCE);
    }
}
