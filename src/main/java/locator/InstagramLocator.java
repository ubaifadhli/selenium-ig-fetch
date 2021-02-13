package locator;

import org.openqa.selenium.By;

public interface InstagramLocator {
    // Posts
    By POST_MEDIA_DOTS = By.xpath("//div[contains(@class, \"JSZAJ\")]//div");
    By POST_IMAGE = By.xpath("//div[contains(@class, \"eLAPa\")]//img");
    By POST_IMAGES = By.xpath("//li[contains(@class, \"Ckrof\")]//img");
    By POST_NEXT_MEDIA_BUTTON = By.xpath("//button[contains(@class, \"_6CZji\")]");
    By POST_VIDEO_BUTTON = By.xpath("//div[contains(@aria-label, \"Control\")]");


    // Story
    By STORY_MEDIA_BARS = By.xpath("//div[@class=\"_6ZEdQ\"]/child::div");
    By STORY_IMAGE = By.xpath("//img[contains(@class, \"y-yJ5\")]");
    By STORY_VIDEO = By.xpath("//video[contains(@class, \"y-yJ5\")]//source");
    By STORY_NEXT_MEDIA_BUTTON = By.xpath("//div[@class=\"coreSpriteRightChevron\"]");


    // Profile
    By PROFILE_PICTURE_BUTTON = By.xpath("//div[contains(@class, \"RR-M-\")]");

    // Login
    By LOGIN_USERNAME_INPUT = By.xpath("//input[@name=\"username\"]");
    By LOGIN_PASSWORD_INPUT = By.xpath("//input[@name=\"password\"]");
    By LOGIN_BUTTON = By.xpath("//div[text()=\"Log In\"]");

}
