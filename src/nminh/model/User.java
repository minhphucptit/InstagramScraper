/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nminh.model;

import java.io.Serializable;

/**
 *
 * @author nminh
 */
public class User implements Serializable{
    private String name;
    private String password;
    private int id;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
}
