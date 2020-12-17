package nminh.services;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstagramHomePage {
  private final WebDriver driver;
  private final By bySearchBox  = By.tagName("input");
  private final By usernameLink = By.xpath("//body/div[@id='react-root']/section[1]/nav[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/a[1]/div[1]");
  private final By links        = By.className("yCE8d");
  private WebDriverWait wait;
  public InstagramHomePage(WebDriver driver) {
	  this.driver = driver;
          wait = new WebDriverWait(this.driver,10);
  }
  
  public void gotoUserProfile(String name) throws Exception{
	try{
           driver.findElement(this.bySearchBox).clear();
           driver.findElement(this.bySearchBox).sendKeys(name);
           Thread.sleep(1000);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(this.usernameLink));
           driver.findElement(usernameLink).click();
        }catch(Exception e){
        }
  }

  public List<String> getLinks(String name) throws InterruptedException,ExceptionInInitializerError{
      List<String> list=new ArrayList<>();
      wait.until(ExpectedConditions.visibilityOfElementLocated(this.bySearchBox));
      this.driver.findElement(this.bySearchBox).clear();
      this.driver.findElement(this.bySearchBox).sendKeys(name);
      Thread.sleep(1000);
      List<WebElement> elements=driver.findElements(links);
      for(int i=0;i<elements.size();i++){
          String[] s=elements.get(i).getAttribute("href").trim().split("/");
          list.add(s[s.length-1]);
      }
      System.out.println(list.toString());
      return list;
  }
    public WebDriver getDriver() {
        return driver;
    }
}
