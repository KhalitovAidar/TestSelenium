package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/a[1]")
    private WebElement accountbtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[1]/a")
    private WebElement mailbtn;

    public void clickaccountbtn(){
        accountbtn.click();
    }

    public void clickmailbtn(){
        mailbtn.click();
    }
}
