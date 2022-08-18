package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class POMregistration extends BaseClass{
	@FindBy(id="ap_customer_name")  WebElement  Name;
	@FindBy(id="ap_email")  WebElement  Email;
	@FindBy(css="#ap_email")  WebElement  Mobile;
	@FindBy(id="ap_password")  WebElement  Password;
	@FindBy(id="ap_password_check")  WebElement  PasswordAgain;
	@FindBy(id="continue")  WebElement  Continue;
    @FindBy(linkText="Start here.") WebElement Registerpage;
    @FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[13]/div[2]/a[1]/span[1]") WebElement Signin;
	@FindBy(id="ap_email")  WebElement  Signemail;
	@FindBy(id="ap_password")  WebElement  Signpassword;

	@FindBy(id="signInSubmit")  WebElement  SigninSubmit;
	@FindBy(name="rememberMe")  WebElement  Checkbox;     
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]")  WebElement YourOrder;     
	@FindBy(xpath="//body/div[@id='a-page']/section[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")  WebElement Buyag;     
	@FindBy(xpath="//a[contains(text(),'Not Yet Shipped')]")  WebElement Notshipped;     
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/a[1]/div[1]/div[1]")  WebElement YourAddress;     
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/a[1]/div[1]/div[1]")  WebElement Secure;     
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/a[1]/div[1]/div[1]")  WebElement Payment;     
	@FindBy(xpath="//body/div[@id='a-page']/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]")  WebElement Addpayment;     
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/input[1]")  WebElement Addcard;     
	@FindBy(name="addCreditCardNumber")  WebElement  CardNumber;
	@FindBy(name="ppw-accountHolderName")  WebElement  CardName;


   public POMregistration() {
	   PageFactory.initElements(driver, this);
   }
   
   public void cardnum(String cardnum) {
	   CardNumber.sendKeys(cardnum);
	   }
   
   public void cardname(String cardname) {
	   CardName.sendKeys(cardname);
	   }
   public void Registerpage( ) {
		  Registerpage.click();
	   }

	   
   public void name(String name) {
	  Name.sendKeys(name);
   }
   public void secure() {
	   Secure.click();
	   }
   public void addcard() {
	   Addcard.click();
	   }
   public void yourorder() {
	   YourOrder.click();
	   }
   public void buyag() {
	   Buyag.click();
	   }
   public void payment() {
	   Payment.click();
	   }
   

public void addpayment() {
Addpayment.click();
}
   public void youraddess() {
	   YourAddress.click();
	   }
   public void notyetshipped() {
	   Notshipped.click();
	   }
   public void signemail(String signemail) {
	   Signemail.sendKeys(signemail);
	   }
	     

   public void mobile(String mobile) {
		  Mobile.sendKeys(mobile);
	   }
	     
   public void pass(String pass) {
	   Password.sendKeys(pass);
	   }
   public void passa(String passa) {
	   PasswordAgain.sendKeys(passa);
	   }
   public void cont() {
	   Continue.click();
   }
   
   public void sigin() {
	   Signin.click();
   }
   
   public void submit() {
	   SigninSubmit.click();
   }
   
   public void checkbox() {
	   Checkbox.click();
   }
   
   public void email(String email) {
		  Email.sendKeys(email);
	   }
   
   public void signpass(String signpass) {
	   Signpassword.sendKeys(signpass);
	   }

   public void acc() {

	   Actions action = new Actions(driver);
	       action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Your Account')]"))).click().build().perform();
	       }

}
