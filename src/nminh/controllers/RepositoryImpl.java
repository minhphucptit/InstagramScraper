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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nminh
 */
public class RepositoryImpl implements Repository{

    @Override
    public <K, E> Map<K, E> getData(String s) {
        File file=new File(s);
        Map<K,E> list=new LinkedHashMap<>();
        try {
            file.createNewFile();
            ObjectInputStream os;
            try (FileInputStream fis = new FileInputStream(file)) {
                os = new ObjectInputStream(fis);
                list=(Map<K,E>)os.readObject();
            }
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(RepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;  
    }

    @Override
    public <K, E> void saveData(Map<K, E> object, String s) {
        File file=new File(s);
        try{
            file.createNewFile();
            ObjectOutputStream os;
            try(FileOutputStream fos=new FileOutputStream(file)){
               os=new ObjectOutputStream(fos);
               os.writeObject(object);
               os.close();
            } 
        }catch (FileNotFoundException ex) {
                Logger.getLogger(RepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
