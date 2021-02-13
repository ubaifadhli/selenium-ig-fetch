import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.InstagramLoginPage;
import page.InstagramPostPage;
import page.InstagramProfilePage;
import page.InstagramStoryPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Playground {
    public static String INSTAGRAM_LOGIN_URL = "https://www.instagram.com/accounts/login/";

    public static void main (String[] args) {
        Properties properties = configureProperties();

        String chromeDriverPath = properties.getProperty("chromedriver.dir");
        String username = properties.getProperty("ig.username");
        String password = properties.getProperty("ig.password");

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        String CURRENT_URL = "https://www.instagram.com/p/CLD8OGclRrr/"; // POST 4 IMAGES
//        String CURRENT_URL = "https://www.instagram.com/taotsuchiya_official/"; // PROFILE WITHOUT STORY
//        String CURRENT_URL = "https://www.instagram.com/p/CLJSv-bFWc7/"; // POST 1 IMAGE

        WebDriver driver = new ChromeDriver();

//        List<String> mediasString = getStoryMedias(driver, CURRENT_URL, username, password);
        List<String> mediasString = getImages(driver, CURRENT_URL);

        System.out.println("\n");
        System.out.println("RESULTS");
        System.out.println("===============");

        for (String media : mediasString)
            System.out.println(media + "\n");

        driver.quit();
    }

    public static List<String> getStoryMedias (WebDriver driver, String url, String email, String password) {
        InstagramProfilePage instagramProfilePage = new InstagramProfilePage(driver);
        InstagramStoryPage instagramStoryPage = new InstagramStoryPage(driver);
        InstagramLoginPage instagramLoginPage = new InstagramLoginPage(driver);

        ArrayList<String> mediasString = new ArrayList<>();

        instagramLoginPage.openPageAt(INSTAGRAM_LOGIN_URL);

        instagramLoginPage.logIntoAccount(email, password);
        instagramLoginPage.sleepForSeconds(3);

        instagramProfilePage.openPageAt(url);
        instagramProfilePage.sleepForSeconds(2);

        if (instagramProfilePage.isProfilePictureEnabled()) {
            instagramProfilePage.clickProfilePictureButton();
            instagramProfilePage.sleepForSeconds(3);

            for (int i = 0; i < instagramStoryPage.getStoryCount(); i++) {
                mediasString.add(instagramStoryPage.getMediaUrl());

                instagramStoryPage.clickNextMediaButton();
                instagramStoryPage.sleepForSeconds(1);
            }

        } else {
            System.out.println("This user currently has no stories.");
        }

        return mediasString;
    }

     public static List<String> getImages (WebDriver driver, String url) {
        InstagramPostPage instagramPostPage = new InstagramPostPage(driver);
        HashSet<String> imageSet = new HashSet<>();

        instagramPostPage.openPageAt(url);
        instagramPostPage.sleepForSeconds(3);

        if (instagramPostPage.doesPostHasMultipleMedia()) {
            for (int i = 0; i < instagramPostPage.getMediaCount() - 1; i++) {
                imageSet.addAll(instagramPostPage.getCurrentImagesUrl());
                instagramPostPage.clickNextMediaButton();
                instagramPostPage.sleepForSeconds(1);
            }
        } else {
            imageSet.add(instagramPostPage.getImageUrl());
        }

        return new ArrayList<>(imageSet);
     }

     public static Properties configureProperties () {
         InputStream rootPath = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");

         Properties properties = new Properties();
         try {
             properties.load(rootPath);
         } catch (IOException e) {
             e.printStackTrace();
         }

         return properties;
     }


}
