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
public class ArbolBinarioBusquedaHabitaciones {
    
    //campos de la clase
    private NodoArbolHabitacion raiz;

    public ArbolBinarioBusquedaHabitaciones() {
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
    * Esta método se utiliza para insertar los elementos del cliente dentro del arbol binario de busqueda
     * @param cliente datos del cliente en la habitación
     * @param raiz raiz del árbol
    */
    public void insertar(Cliente cliente, NodoArbolHabitacion raiz) {
        NodoArbolHabitacion node = new NodoArbolHabitacion(cliente);
        if (estaVacio()) {
            setRaiz(node);
        } else {
            int dia = Integer.parseInt(cliente.getLlegada().substring(0, 2));
            int mes = Integer.parseInt(cliente.getLlegada().substring(3, 5));
            int año = Integer.parseInt(cliente.getLlegada().substring(6, 10));
            int diaRaiz = Integer.parseInt(raiz.getCliente().getLlegada().substring(0, 2));
            int mesRaiz = Integer.parseInt(raiz.getCliente().getLlegada().substring(3, 5));
            int añoRaiz = Integer.parseInt(raiz.getCliente().getLlegada().substring(6, 10));
            if (año < añoRaiz
                    || (año == añoRaiz && mes < mesRaiz)
                    || (año == añoRaiz && mes == mesRaiz && dia < diaRaiz)) {
                if (raiz.getLeftSon() == null) {
                    raiz.setLeftSon(node);
                } else {
                    insertar(cliente, raiz.getLeftSon());
                }
            } else {
                if (raiz.getRightSon() == null) {
                    raiz.setRightSon(node);
                } else {
                    insertar(cliente, raiz.getRightSon());
                }
            }
        }
    }//cierre del método
    
    /**
     * Este método se utiliza para ordenar todos los clientes a través del método de inorden
     * @param raiz
     * @return los datos de modo inorden
     */
    public String inOrden(NodoArbolHabitacion raiz) {
        return inOrdenRecursivo(raiz, "");
    }//cierre del método
    
    /**
     * Este es un método recursivo para meter los clientes en un string y ordernarlos de una manera inorden
     * @param raiz
     * @param resultado string vacio
     * @return los datos de modo inorden
     */
    private String inOrdenRecursivo(NodoArbolHabitacion raiz, String resultado) {
        if (raiz != null) {
            resultado = inOrdenRecursivo(raiz.getLeftSon(), resultado);
            resultado += raiz.getCliente().getCedula() + ", " + raiz.getCliente().getPrimer_nombre() + ", " + raiz.getCliente().getApellido() + ", " + raiz.getCliente().getEmail() + ", " + raiz.getCliente().getGenero() + ", " + raiz.getCliente().getLlegada() + "\n";
            resultado = inOrdenRecursivo(raiz.getRightSon(), resultado);
        }
        return resultado;
    }//cierre del método

    /**
     * @return the raiz
     */
    public NodoArbolHabitacion getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoArbolHabitacion raiz) {
        this.raiz = raiz;
    }
    
}//cierre de la clase
