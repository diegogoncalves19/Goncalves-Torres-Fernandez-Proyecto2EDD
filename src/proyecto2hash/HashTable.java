/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hash;

/**
 * Esta clase define los datos de la hash table
 * @author Diego Goncalves
 * @version 20/03/2024
 */
public class HashTable {
    
    //campos de la clase
    public int tamano;
    public String[] llaves;
    public String[] valores;
    
    public HashTable(int tamano) {
        this.tamano = tamano;
        this.llaves = new String[tamano];
        this.valores = new String[tamano];
    }
    
    /**
     * Este método es para encontrar y mostrar el valor del key que se desea
     * @param llave nombre del cliente
     * @return null
     */
    public String getValor(String llave){
        int hash = hash(llave);
        while(llaves[hash] != null){
            if(llaves[hash].equals(llave)){
                return valores[hash];
            }
            hash = (hash+1)%tamano;
        }
        return null;
    }//cierre del método
    
    /**
     * Este método es para establecer los datos del key y del valor dentro del hash table
     * @param llave nombre del cliente
     * @param valor número de habitación
     */
    public void setValor(String llave, String valor){
        int hash = hash(llave);
        while (llaves[hash] != null && !llaves[hash].equals(llaves)){
            hash = (hash + 1) % tamano;
        }
        llaves[hash] = llave;
        valores[hash] = valor;
    }//cierre del método
    
    /**
     * Este método es una fórmula que se utiliza para calcular el índice del key dentro del hash table
     * @param llave nombre del cliente
     * @return índice del key dentro del hash table
     */
    private int hash(String llave){
        int hash = 0;
        for (int i = 0; i < llave.length(); i++) {
            hash = (31 * hash + llave.charAt(i)) % tamano;
        }
        return hash;
    }//cierre del método
    
}//cierre de la clase
