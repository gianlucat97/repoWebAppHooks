package catalogoProdotti.testing;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class testSuiteHooks {

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/runner/work/repoWebAppHooks/repoWebAppHooks/geckodriver-v0.29.1-win64/geckodriver.exe");
		driver = new FirefoxDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testtestSuiteHooks() throws Exception {
	    driver.get("http://localhost:8080/catalogoProdotti/prodotti");
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-24]")).click();
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-24]")).clear();
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-24]")).sendKeys("Lavagna");
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-27]")).clear();
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-27]")).sendKeys("Materiale Scuola");
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-30]")).clear();
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-30]")).sendKeys("50");
	    driver.findElement(By.xpath("//*[@x-test-tpl-20]//*[@x-test-hook-32]")).click();
	    driver.findElement(By.xpath("//*[@x-test-tpl-35]//*[@x-test-hook-44][21]//*[@x-test-hook-50]")).click();
	    driver.findElement(By.xpath("//*[@x-test-tpl-5]//*[@x-test-hook-6]")).click();
	    driver.findElement(By.xpath("//*[@x-test-tpl-5]//*[@x-test-hook-16]")).clear();
	    driver.findElement(By.xpath("//*[@x-test-tpl-5]//*[@x-test-hook-16]")).sendKeys("30");
	    driver.findElement(By.xpath("//*[@x-test-tpl-5]//*[@x-test-hook-18]")).click();
	    driver.findElement(By.xpath("//*[@x-test-tpl-35]//*[@x-test-hook-44][21]//*[@x-test-hook-49]")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
