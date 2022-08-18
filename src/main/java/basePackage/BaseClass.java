package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	 
	 public BaseClass() {
		 try {
		 FileInputStream file = new FileInputStream("C:\\Users\\Nirmohan\\Documents\\AmazonProject\\src\\test\\java\\enivironmentvariables\\Config.properties");
	     prop.load(file);
		 }
		catch(FileNotFoundException e) {
	 e.printStackTrace();
	 }
		 catch(IOException a) {
			 a.printStackTrace();
		 }
	 }

		 public static void initiate() {
			 
		String browsername=	prop.getProperty("browser");
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 driver=new ChromeDriver(); 
			 
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(prop.getProperty("url"));
 }
		 }
