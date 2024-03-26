/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hash;


/**
 * Esta clase define el nodo para el ABB del registro de habitaciones
 * @author Edgar Torres
 * @version 22/03/2024
 */
public class NodoArbolHabitacion {
    
    //campos de la clase
    private Cliente cliente;
    private NodoArbolHabitacion rightSon,leftSon;

    public NodoArbolHabitacion(Cliente cliente) {
        this.cliente = cliente;
        this.rightSon = this.leftSon = null;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the rightSon
     */
    public NodoArbolHabitacion getRightSon() {
        return rightSon;
    }

    /**
     * @param rightSon the rightSon to set
     */
    public void setRightSon(NodoArbolHabitacion rightSon) {
        this.rightSon = rightSon;
    }

    /**
     * @return the leftSon
     */
    public NodoArbolHabitacion getLeftSon() {
        return leftSon;
    }

    /**
     * @param leftSon the leftSon to set
     */
    public void setLeftSon(NodoArbolHabitacion leftSon) {
        this.leftSon = leftSon;
    }
    
}//cierre de la clase
