
package com.pmp.dao;

public class Persona {

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _apellido
     */
    public String getApellido() {
        return _apellido;
    }

    /**
     * @param _apellido the _apellido to set
     */
    public void setApellido(String _apellido) {
        this._apellido = _apellido;
    }

    /**
     * @return the _estatura
     */
    public Double getEstatura() {
        return _estatura;
    }

    /**
     * @param _estatura the _estatura to set
     */
    public void setEstatura(Double _estatura) {
        this._estatura = _estatura;
    }

    /**
     * @return the _peso
     */
    public Double getPeso() {
        return _peso;
    }

    /**
     * @param _peso the _peso to set
     */
    public void setPeso(Double _peso) {
        this._peso = _peso;
    }


    
    public int getId() {
        return _id;
    }
    
    public void setId(int _id) {
        this._id = _id;
    }



    
    private int _id; 
    private String _nombre;
    private String _apellido;
    private Double _estatura;
    private Double _peso;    
    
}
