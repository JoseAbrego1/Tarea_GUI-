package com.pmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static Connection _cn = null;
    
    private Conexion(){
        
    } 
    
    public static Connection cn(){
        try{
            if(_cn == null){
                Class.forName("org.sqlite.JDBC");
                _cn = DriverManager.getConnection("jdbc:sqlite:Personas.db");
            }
            return _cn;
        }catch(Exception e){
            System.err.println("Error "+e.getMessage());
            return null;
        }
    }
}
