/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nminh.controllers;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author nminh
 */
public interface LoginController {
    public WebDriver login(String name,String password,WebDriver driver ) throws Exception;
    public boolean isLogined();
}
