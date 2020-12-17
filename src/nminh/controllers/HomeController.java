/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nminh.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author nminh
 */
public interface HomeController {
    public int save(Set<String> imgs,String dir,String name) throws MalformedURLException, IOException;
    public void gotoProfile(String name,WebDriver driver) throws Exception;
    public<T> Set<T> getImgs(WebDriver driver) throws MalformedURLException, IOException;
    public List<String> search(String name,WebDriver driver);
}
