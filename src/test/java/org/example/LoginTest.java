package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static RemoteWebDriver driver;
    public static LoginPage loginPage;
    public static EmailPage emailPage;
    public static MainPage mainPage;



    @BeforeClass
    public static void setup() throws MalformedURLException {

        DesiredCapabilities cap =  DesiredCapabilities.chrome();

        driver = new RemoteWebDriver(new URL("http://172.20.0.1:4444/wd/hub"), cap);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        emailPage = new EmailPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3 , TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));

    }

    @Test
    public void loginTest() {

        mainPage.loginBtnClick();

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("passw"));
        loginPage.clicksignin();

        String messages = emailPage.findAmountMessages();

        emailPage.writeMessageClick();
        emailPage.setRecipient(ConfProperties.getProperty("recipient"));
        emailPage.setSub("Simbirsoft Тестовое задание. Халитов");
        emailPage.setTextMessage(messages);
        emailPage.setSendMessage();
        emailPage.setComeback();

        Assert.assertEquals("3", messages);

    }

    @AfterClass
    public static void tearDown() {
        emailPage.clickMenu();
        emailPage.logout();
        driver.quit();
    }
}