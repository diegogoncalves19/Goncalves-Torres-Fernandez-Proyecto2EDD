/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hash;

/**
 * Esta clase es un arbol binario utilizado para insertar el registro de las habitaciones
 * @author Edgar Torres
 * @version 22/03/2024
 */
public class ArbolBinarioBusquedaReservacion {

    //campos de la clase
    private NodoArbolReserva raiz;

    public ArbolBinarioBusquedaReservacion() {
        this.raiz = null;
    }

    /**
     * Este método es para ver si el arbol binario de busqueda está vacio o no
     * @return revisar si la raíz está vacia o no
     */
    public boolean estaVacio() {
        return getRaiz() == null;
    }//cierre del método
    
    /**
    * Esta método se utiliza para insertar los elementos de la reserva dentro del arbol binario de busqueda
     * @param reserva datos de la reserva del cliente
     * @param raiz raiz del árbol
    */
    public void insertar(Reserva reserva, NodoArbolReserva raiz) {
        NodoArbolReserva nodo = new NodoArbolReserva(reserva);
        if (estaVacio()) {
            setRaiz(nodo);
        } else {
            int dia = Integer.parseInt(reserva.getLlegada().substring(0, 2));
            int mes = Integer.parseInt(reserva.getLlegada().substring(3, 5));
            int año = Integer.parseInt(reserva.getLlegada().substring(6, 10));
            int diaRaiz = Integer.parseInt(raiz.getReserva().getLlegada().substring(0, 2));
            int mesRaiz = Integer.parseInt(raiz.getReserva().getLlegada().substring(3, 5));
            int añoRaiz = Integer.parseInt(raiz.getReserva().getLlegada().substring(6, 10));
            if (año < añoRaiz
                    || (año == añoRaiz && mes < mesRaiz)
                    || (año == añoRaiz && mes == mesRaiz && dia < diaRaiz)) {
                if (raiz.getLeftSon() == null) {
                    raiz.setLeftSon(nodo);
                } else {
                    insertar(reserva, raiz.getLeftSon());
                }
            } else {
                if (raiz.getRightSon() == null) {
                    raiz.setRightSon(nodo);
                } else {
                    insertar(reserva, raiz.getRightSon());
                }
            }
        }
    }//cierre del método
    
    /**
     * Este método se utiliza para ordenar todos las reservas a través del método de inorden
     * @param raiz
     * @return los datos de modo inorden
     */
    public String inOrden(NodoArbolReserva raiz) {
        return inOrdenRecursivo(raiz, "");
    }//cierre del método
    
    /**
     * Este es un método recursivo para meter las reservas en un string y ordernarlos de una manera inorden
     * @param raiz
     * @param resultado string vacio
     * @return los datos de modo inorden
     */
    private String inOrdenRecursivo(NodoArbolReserva raiz, String resultado) {
        if (raiz != null) {
            resultado = inOrdenRecursivo(raiz.getLeftSon(), resultado);
            resultado += raiz.getReserva().getCedula() + ", " + raiz.getReserva().getPrimer_nombre() + ", " + raiz.getReserva().getApellido() + ", " + raiz.getReserva().getEmail() + ", " + raiz.getReserva().getGenero() + ", " + raiz.getReserva().getTipo_hab() + ", " + raiz.getReserva().getCelular() + ", " + raiz.getReserva().getLlegada() + ", " + raiz.getReserva().getSalida() + "\n";
            resultado = inOrdenRecursivo(raiz.getRightSon(), resultado);
        }
        return resultado;
    }//cierre del método

    /**
     * @return the raiz
     */
    public NodoArbolReserva getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoArbolReserva raiz) {
        this.raiz = raiz;
    }
}//cierre de la clase
