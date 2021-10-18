package org.example;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    @BeforeClass
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("loginpage"));

    }

}
