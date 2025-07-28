package tests;

import org.pages.ContactUsPage;
import org.pages.HomePage;
import org.testdata.ContactUsData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.pages.ContactUsPage.txtGetInTouch;
import static org.pages.ContactUsPage.txtSuccess;

public class ContactUsTest extends BaseTest {
    ContactUsPage contactUsPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp(){
        contactUsPage=new ContactUsPage(driver);
        homePage=new HomePage(driver);
        homePage.clickOnContactUsLink();
    }
    @Test
    public void verifyContactUsPage(){
        //Verify Get in touch text
        softAssert.assertEquals(txtGetInTouch.getText(),"GET IN TOUCH","Expected 'GET IN TOUCH' text is not available");

        //Fill contact us form
        String subject="Contacting Ecommerce Team";
        String message="This is a message to the Team";
        contactUsPage.enterMessage(ContactUsData.firstName(),ContactUsData.email(),subject,message);
        contactUsPage.uploadFile(ContactUsData.inputFilePath());
        contactUsPage.clickOnSubmit();
        contactUsPage.pressOkOfTheAlert();

        //Verify success message
        softAssert.assertEquals(txtSuccess.getText(),"Success! Your details have been submitted successfully.","Expected successful message is not available");
        softAssert.assertAll();
    }
}
