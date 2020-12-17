/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nminh.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nminh.services.InstagramHomePage;
import nminh.services.InstagramLogin;
import nminh.services.UserProfile;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author nminh
 */
public class HomeControllerImpl implements HomeController{
    
    private  UserProfile user;
    private InstagramHomePage homePage;
    public HomeControllerImpl() {
    }
    
    @Override
    public void gotoProfile(String name,WebDriver driver) throws Exception{
        this.homePage=new InstagramHomePage(driver);
        homePage.gotoUserProfile(name);
    }
    
    @Override
    public Set<String> getImgs(WebDriver driver){
        this.user=new UserProfile(driver);
        return user.getImgs();
    }
    
    
    @Override
    public List<String> search(String name,WebDriver driver){
        this.homePage=new InstagramHomePage(driver);
        try {
            return homePage.getLinks(name);
        } catch (InterruptedException ex) {
            Logger.getLogger(HomeControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //@Override
    //public void disable(){
    //    homePage.disableNotification();
    //}
    @Override
    public int save(Set<String> imgs,String dir,String name) throws MalformedURLException, IOException{
        Object[] obj=imgs.toArray();
	for(int i = 0; i < obj.length; i++) {
	    URL url = new URL(obj[i].toString());
	    InputStream in = url.openStream();
	    OutputStream out = new BufferedOutputStream(new FileOutputStream(dir+"\\"+name+i+".jpg"));
	    for(int b;(b = in.read()) !=- 1;) {
	        out.write(b);
	    }
	    out.close();
	    in.close();
	 } 
        return obj.length;
    }
}
