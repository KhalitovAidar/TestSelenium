package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    public static EmailPage emailPage;

    @BeforeClass
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        emailPage = new EmailPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("loginpage"));

    }

    @Test
    public void loginTest() {

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("passw"));
        loginPage.clicksignin();


        profilePage.clickaccountbtn();
        profilePage.clickmailbtn();

        int messages = driver.findElements(By.linkText("Simbirsoft Тестовое задание")).size();
        String elem = Integer.toString(messages);


        emailPage.writemessageclick();
        emailPage.setWhoget(ConfProperties.getProperty("whoget"));
        emailPage.setTextmessage(elem);
        emailPage.setSendmessage();
        emailPage.setSubject(ConfProperties.getProperty("subject"));
        emailPage.setSendmessage2();
        emailPage.clickmenu();
    }

    @AfterClass
    public static void tearDown() {
        emailPage.clickmenu();
        emailPage.logout();
        driver.quit();
    }
}
