
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PersonaMod{
    
    private Connection _cn = null;
    
    public PersonaMod(){
        _cn = Conexion.cn();
        String sql = "CREATE TABLE IF NOT EXISTS Persona(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +" Nombre TEXT NOT NULL,"
                +" Apellido TEXT NOT NULL,"
                +" Estatura NUMERIC NOT NULL,"
                +" Peso NUMERIC NOT NULL);";

        try{
            Statement comando = _cn.createStatement();
            int resultado = comando.executeUpdate(sql);
        }catch(Exception e){
            System.err.print(e.getMessage());
        }
    }
    public ArrayList<Persona> obtenerPersona(){
        try{
            ArrayList Persona = new ArrayList<Persona>();
            Statement cmd = _cn.createStatement();
            ResultSet registroEnTabla = cmd.executeQuery("SELECT * FROM Persona;");
            while(registroEnTabla.next()){
                Persona Pers = new Persona();
                Pers.setId(registroEnTabla.getInt("id"));
                Pers.setNombre(registroEnTabla.getString("Nombre"));
                Pers.setApellido(registroEnTabla.getString("Apellido"));     
                Pers.setEstatura(registroEnTabla.getDouble("Estatura"));
                Pers.setPeso(registroEnTabla.getDouble("Peso"));

                
               Persona.add(Pers);
            }
            return Persona;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<Persona>();
        }
    }
    public int agregarPersona(Persona Pers){
        try{
            String sql = "INSERT INTO Persona (Nombre, Apellido, Estatura, Peso) VALUES (?,?,?,?);";
            PreparedStatement cmd = _cn.prepareStatement(sql);
            cmd.setString(1, Pers.getNombre());
            cmd.setString(2, Pers.getApellido());
            cmd.setDouble(3, Pers.getEstatura());
            cmd.setDouble(4, Pers.getPeso());

            
            int RegistrosAfectados = cmd.executeUpdate();
            cmd.close();
            return RegistrosAfectados;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
    public Persona obtenerPersona(int id){
        try{
            PreparedStatement cmd = _cn.prepareStatement("SELECT * FROM Persona WHERE id = ?;");
            cmd.setInt(1, id);
            ResultSet registro = cmd.executeQuery();
            Persona Pers = new Persona();
            while(registro.next()){
                Pers.setId(registro.getInt("id"));
                Pers.setNombre(registro.getString("Nombre"));
                Pers.setApellido(registro.getString("Apellido"));
                Pers.setEstatura(registro.getDouble("Estatura"));
                Pers.setPeso(registro.getDouble("Peso"));
                break;
            }
            return Pers;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public int actualizarPersona(Persona Pers){
        try{
            String sql = "UPDATE Persona SET  Nombre = ?, Apellido = ?, Estatura = ?, Peso = ? WHERE id = ?";
            PreparedStatement cmd = _cn.prepareStatement(sql);
            cmd.setString(1, Pers.getNombre());
            cmd.setString(2, Pers.getApellido());
            cmd.setDouble(3, Pers.getEstatura());
            cmd.setDouble(4, Pers.getPeso());
            cmd.setInt(5, Pers.getId());
            
            int regAfectados = cmd.executeUpdate();
            cmd.close();
            return regAfectados;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
    public int eliminarPersona(int id){
        try{
            String sql = "DELETE FROM Persona WHERE id=?";
            PreparedStatement cmd = _cn.prepareStatement(sql);
            cmd.setInt(1, id);
            int eliminado = cmd.executeUpdate();
            return eliminado; 
        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
