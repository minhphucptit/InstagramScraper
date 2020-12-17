/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nminh.controllers;

import java.util.Map;

/**
 *
 * @author nminh
 */
public interface Repository {
    public<K,E> Map<K,E> getData(String file);
    public <K, E> void saveData(Map<K, E> object,String file);
}
