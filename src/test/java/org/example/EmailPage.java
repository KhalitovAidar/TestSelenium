package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.List;

public class EmailPage {

    public WebDriver driver;

    public EmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    List<WebElement> elem = driver.findElements(By.linkText("Simbirsoft Тестовое задание"));

}
