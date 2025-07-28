package org.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class=\"col-sm-8\"]/div/h2")
    public static WebElement txtGetInTouch;
    @FindBy(name = "name")
    public static WebElement inputName;
    @FindBy(name = "email")
    public static WebElement inputEmail;
    @FindBy(name="subject")
    public static WebElement inputSubject;
    @FindBy(name="message")
    public static WebElement inputMessage;
    @FindBy(name = "upload_file")
    public static WebElement inputFile;
    @FindBy(name = "submit")
    public static WebElement btnSubmit;
    @FindBy(xpath = "//div[@class=\"col-sm-8\"]/div/div[@class=\"status alert alert-success\"]")
    public static WebElement txtSuccess;

    public void enterMessage(String name,String email,String subject,String message){
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputSubject.sendKeys(subject);
        inputMessage.sendKeys(message);
    }
    public void uploadFile(String path){
        inputFile.sendKeys(path);
    }
    public void clickOnSubmit(){
        btnSubmit.click();
    }
    public void pressOkOfTheAlert(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }


}
