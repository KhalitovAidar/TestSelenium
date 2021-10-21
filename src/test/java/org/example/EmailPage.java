package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmailPage {

    public WebDriver driver;

    public EmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='mail-ComposeButton-Wrap js-compose-button-container']/a[@class='mail-ComposeButton js-main-action-compose']")
    private WebElement writeMessage;

    @FindBy(xpath = "//div[@class='composeYabbles']")
    private WebElement recipient;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subject;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div/div")
    private WebElement textMessage;

    @FindBy(xpath = "//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement sendMessage;

    @FindBy(xpath = "//a[@href='https://passport.yandex.ru']")
    private WebElement clickMenu;

    @FindBy(xpath = "//a[@aria-label='Выйти из аккаунта']")
    private WebElement logout;

    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[88]/div/div[1]/div[2]/a")
    private WebElement comeback;

    public void writeMessageClick(){
        writeMessage.click();
    }

    public void setRecipient(String mail){
        recipient.sendKeys(mail);
    }

    public void setSub(String sub){
        subject.sendKeys(sub);
    }

    public void setTextMessage(String elem){
        textMessage.sendKeys(elem);
    }

    public void setSendMessage(){
        sendMessage.click();
    }

    public void setComeback() {
        comeback.click();
    }

    public void clickMenu(){
        clickMenu.click();
    }

    public void logout(){
        logout.click();
    }

    public String findAmountMessages() {
        String messages;
        int elem = driver.findElements(By.cssSelector("span[title='Simbirsoft Тестовое задание']")).size();
        messages = Integer.toString(elem);
        return messages;
    }

}