package testLayer;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import basePackage.BaseClass;
import pompackage.POMregistration;

public class RegistrationTestCase extends BaseClass {
	POMregistration Reg;
	
	public RegistrationTestCase() {
		super();
	}
    
	@BeforeMethod
	public void initsetup() {
		initiate();
		 Reg = new POMregistration();
	}
		
@Test
public void invalidname() throws InterruptedException {
	Reg.Registerpage();
    Thread.sleep(5000);

	Reg.email("  ");
    Thread.sleep(5000);

    Reg.cont();
    Thread.sleep(10000);
    String error =driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).getText();
   
    System.out.println(error);

    Assert.assertEquals( error, "Enter your e-mail address or mobile phone number");
    
}

@Test
public void invalidnumber () throws InterruptedException {
	Reg.Registerpage();
	Reg.mobile(" ");
	 Reg.cont();
	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals( error, "Enter your e-mail address or mobile phone number");
	
}


@Test
public void validnumber () throws InterruptedException {
	Reg.Registerpage();
	Reg.mobile("2269728688");
	 Reg.cont();
	    Thread.sleep(10000);
	    String error =driver.findElement(By.id("auth-continue-announce")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals( error, "Verify mobile number");
	
}


@Test
public void validemail () throws InterruptedException {
	Reg.Registerpage();
	Reg.email("snirmohan@gmail.com");
	 Reg.cont();
	    Thread.sleep(10000);
	    String error =driver.findElement(By.id("auth-continue-announce")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals( error, "Verify email");
	
}




@Test
public void validpassword () throws InterruptedException {
	Reg.Registerpage();
	Reg.name("Nirmohan");
	Reg.mobile("snirmohan@gmail.com");
	Reg.pass("qwerty321");
	 Reg.cont();
	    Thread.sleep(10000);
	    String noerror =driver.findElement(By.xpath("//div[contains(text(),'Type your password again')]")).getText();
	   
	    System.out.println(noerror);

	    Assert.assertEquals( noerror, "Type your password again");
	
}


@Test
public void invalidpassword () throws InterruptedException {
	Reg.Registerpage();
	Reg.name("Nirmohan");
	Reg.mobile("snirmohan@gmail.com");
	Reg.pass("qwerty321");
	Reg.passa("qwertyytre");
	 Reg.cont();

	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("//div[contains(text(),'Passwords do not match')]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Passwords do not match");
	
}


@Test
public void existingacc () throws InterruptedException {
	Reg.Registerpage();
	Reg.name("Nirmohan");
	Reg.mobile("snirmohan@gmail.com");
	Reg.pass("qwerty321");
	Reg.passa("qwerty321");
	 Reg.cont();

	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("//h4[contains(text(),'Are you a returning customer?')]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Are you a returning customer?");
	
}


@Test
public void invalidsinpass () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@mail.com");
    
	 Reg.cont();

	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "We cannot find an account with that e-mail address");
	
}

@Test
public void invalidsigin () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@gmail.com");
	 Reg.cont();

      Reg.signpass("qwert");
	 Reg.submit();

	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Your password is incorrect");
	
}


@Test
public void checkbox () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@gmail.com");
	 Reg.cont();

      Reg.signpass("qwerty321");
      Reg.checkbox();
	 Reg.submit();

	    Thread.sleep(10000);
	    String error =driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Hello, Nirmohan");
	
}


@Test
public void account () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@gmail.com");
	 Reg.cont();

      Reg.signpass("qwerty321");
      Reg.checkbox();
	 Reg.submit();
    Reg.acc();
	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/h1[1]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Your Account");
	
}


@Test
public void buyagain () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@gmail.com");
	 Reg.cont();

      Reg.signpass("qwerty321");
      Reg.checkbox();
	  Reg.submit();
      Reg.acc();
      Reg.yourorder();
      Reg.buyag();
    
	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "There are no recommended items for you to buy again at this time. Check Your Orders for items you previously purchased.");
	
}





@Test
public void notshipped () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@gmail.com");
	 Reg.cont();

      Reg.signpass("qwerty321");
      Reg.checkbox();
	  Reg.submit();
      Reg.acc();
      Reg.yourorder();
      Reg.notyetshipped();
	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Looking for an order? All of your orders have shipped. View all orders");
	
}




@Test
public void address () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@gmail.com");
	 Reg.cont();

      Reg.signpass("qwerty321");
      Reg.checkbox();
	  Reg.submit();
      Reg.acc();
      Reg.youraddess();
	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("//h1[contains(text(),'Your Addresses')]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Your Addresses");
	
}




@Test
public void security () throws InterruptedException {
	Reg.sigin();
    Reg.signemail("snirmohan@gmail.com");
	 Reg.cont();

      Reg.signpass("qwerty321");
      Reg.checkbox();
	  Reg.submit();
      Reg.acc();
      Reg.secure();
	    Thread.sleep(10000);
	    String error =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/h1[1]")).getText();
	   
	    System.out.println(error);

	    Assert.assertEquals(error, "Login & security");
	
}






@AfterMethod
public void close() {
	driver.close();
}
  
}