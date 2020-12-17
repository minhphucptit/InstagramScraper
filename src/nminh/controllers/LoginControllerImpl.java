/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nminh.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nminh.model.User;
import nminh.services.InstagramLogin;
import nminh.view.Login;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author nminh
 */
public class LoginControllerImpl implements LoginController{
    private InstagramLogin instagramLogin;
    @Override
    public WebDriver login(String name,String password,WebDriver driver ) throws Exception{
        this.instagramLogin =new InstagramLogin(driver);
        return instagramLogin.login(name, password);
    }

    @Override
    public boolean isLogined() {
        return instagramLogin.isLogined();
    }
}
