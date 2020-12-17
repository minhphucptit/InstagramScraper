/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nminh.model;

import java.util.Set;

/**
 *
 * @author nminh
 */
public class UserProfile {
    private int id;
    private static int sid=1000;
    private String name;
    private Set<String> imgLinks;
    private int follow,following;

    public UserProfile(String name) {
        this.id=sid++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getImgLinks() {
        return imgLinks;
    }

    public int getFollow() {
        return follow;
    }

    public int getFollowing() {
        return following;
    }
    
    
}
