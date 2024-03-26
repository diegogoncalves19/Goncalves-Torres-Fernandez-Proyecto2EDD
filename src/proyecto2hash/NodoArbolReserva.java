/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hash;

/**
 * Esta clase define el nodo para el ABB de la busqueda de reservaciones
 * @author Edgar Torres
 * @version 22/03/2024
 */
public class NodoArbolReserva {

    //campos de la clase
    private Reserva reserva;
    private NodoArbolReserva rightSon,leftSon;

    public NodoArbolReserva(Reserva reserva) {
        this.reserva = reserva;
        this.rightSon = this.leftSon = null;
    }

    /**
     * @return the reserva
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * @return the rightSon
     */
    public NodoArbolReserva getRightSon() {
        return rightSon;
    }

    /**
     * @param rightSon the rightSon to set
     */
    public void setRightSon(NodoArbolReserva rightSon) {
        this.rightSon = rightSon;
    }

    /**
     * @return the leftSon
     */
    public NodoArbolReserva getLeftSon() {
        return leftSon;
    }

    /**
     * @param leftSon the leftSon to set
     */
    public void setLeftSon(NodoArbolReserva leftSon) {
        this.leftSon = leftSon;
    }
    
}//cierre de la clase
