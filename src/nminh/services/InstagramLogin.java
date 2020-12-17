package nminh.services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class InstagramLogin {
   private final WebDriver driver;
   private final By byUsername = By.xpath("//input[@name='username']");
   private final By byPassword = By.xpath("//input[@name='password']");
   private final By byLogin    = By.xpath("//button");
   private final By byArlet    =By.xpath("//p[@id='slfErrorAlert']");
   WebDriverWait wait ;
   public InstagramLogin(WebDriver driver) {
	   this.driver = driver;
           wait= new WebDriverWait(driver,15);
   }
   public WebDriver login(String username, String password) throws  Exception{
           wait.until(ExpectedConditions.visibilityOfElementLocated(this.byUsername));
	   driver.findElement(byUsername).sendKeys(username);
           wait.until(ExpectedConditions.visibilityOfElementLocated(this.byPassword));
	   driver.findElement(byPassword).sendKeys(password);	   
	   driver.findElement(byLogin).submit();
	   return this.driver;
   }
   public boolean isLogined(){
       try{
           Thread.sleep(500);
           driver.findElement(byArlet);
           return false;
       }catch(Exception e){
           return true;
       }
  }
}
