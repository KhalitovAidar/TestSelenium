package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.List;

public class EmailPage {

    public WebDriver driver = new ChromeDriver();;

    public EmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    int messages = driver.findElements(By.linkText("Simbirsoft Тестовое задание")).size();
    String elem = Integer.toString(messages);

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[3]/div[2]/div[1]/div/div/div/a")
    private WebElement writemessage;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div/span/div/div[1]")
    private WebElement whoget;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div/div/div[2]/div/input")
    private WebElement subject;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div/div")
    private WebElement textmessage;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    private WebElement sendmessage;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[3]/div/div/div/div/div[3]/button[1]")
    private WebElement sendmessage2;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[2]/div/div/div[3]/div/div/a[1]")
    private WebElement clickmenu;

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[2]/div/div/div[3]/div/div/div/ul/ul/li[6]/a")
    private WebElement logout;

    public void writemessageclick(){
        writemessage.click();
    }

    public void setWhoget(String mail){
        whoget.sendKeys(mail);
    }

    public void setSubject(String subject){
        whoget.sendKeys(subject);
    }

    public void setTextmessage(String elem){
        textmessage.sendKeys(elem);
    }

    public void setSendmessage(){
        sendmessage.click();
    }

    public void setSendmessage2() {
        sendmessage2.click();
    }

    public void clickmenu(){
        clickmenu.click();
    }

    public void logout(){
        logout.click();
    }

}
