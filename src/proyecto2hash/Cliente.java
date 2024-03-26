/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hash;

/**
 * Esta clase define el registro del cliente en el histórico
 * @author Edgar Torres
 * @version 22/03/2024
 */
public class Cliente {
    //campos de la clase
    private String cedula;
    private String primer_nombre;
    private String apellido;
    private String email;
    private String genero;
    private String llegada;

    public Cliente(String cedula, String primer_nombre, String apellido, String email, String genero, String llegada) {
        this.cedula = cedula;
        this.primer_nombre = primer_nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the primer_nombre
     */
    public String getPrimer_nombre() {
        return primer_nombre;
    }

    /**
     * @param primer_nombre the primer_nombre to set
     */
    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the llegada
     */
    public String getLlegada() {
        return llegada;
    }

    /**
     * @param llegada the llegada to set
     */
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }
    
}//cierre de la clase
