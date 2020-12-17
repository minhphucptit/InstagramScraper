package nminh.services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfile {
  private WebDriver driver;
  //private By byclickRightBtn = By.xpath("//a[contains(@class,'coreSpriteRightPaginationArrow')]");
  private By byimg           = By.cssSelector("section article img");
  
	public UserProfile(WebDriver driver) {
		this.driver = driver;
	}
	
	public Set<String> getImgs() {
		Set<String> srcList = new HashSet<>();
		WebDriverWait wait = new WebDriverWait(driver,15);
		int run=1,size=0,check=1;
		while(run==1) {
			System.out.println("Dowloading....");
		try {
		    JavascriptExecutor js = ((JavascriptExecutor)this.driver);
		    js.executeScript("window.scrollBy(0,1300)");
		    Thread.sleep(1500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(this.byimg));
			List<WebElement> imgs = this.driver.findElements(byimg);
			for(int i = 0 ; i < imgs.size() ; i++) {
			  String res = imgs.get(i).getAttribute("src");
			  srcList.add(res);
			}
		    if(size==srcList.size()) check++;
		    if(check>2) run=0;
		    size=srcList.size();
		}catch(Exception e) {
			System.out.println("you aren't following this one or no image");
			run=1;
		}
		}
		return srcList;
	}

    public WebDriver getDriver() {
        return driver;
    }
        
}
