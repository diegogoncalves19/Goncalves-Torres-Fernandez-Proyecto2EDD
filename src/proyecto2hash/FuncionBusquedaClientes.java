/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Esta clase define las funciones para buscar la habitación del cliente deseado
 * @author Diego Goncalves
 * @version 24/03/2024
 */
public class FuncionBusquedaClientes {
    
    //campos de la clase
    
    /**
     * Este método es para crear el hash table donde se va a insertar los datos
     * @return el hashtable
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public HashTable CrearHashTable() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src//archivos//estado.csv"));
        String line;
        String clientes = "";
        while((line = reader.readLine()) != null){
            clientes = clientes + line + "\n";
        }
        String[] estado = clientes.split("\n");
        HashTable hashtable = new HashTable(400);
        int i = 1;
        while(i < estado.length) {
            String[] valor = estado[i].split(";");
            hashtable.setValor(valor[1].toLowerCase() + " " + valor[2].toLowerCase(), valor[0]);
            i++;
        }   
        return hashtable;
    }//cierre del método
    
    /**
     * Este método es para mostrar la habitación del cliente escogido
     * @param nombre nombre del cliente
     * @param apellido apellido del cliente
     * @return null
     * @throws java.io.IOException
     */
    public String MostrarHabitación(String nombre, String apellido) throws IOException{
        HashTable hashtable2 = CrearHashTable();
        String nombre_completo = nombre + " " + apellido;
        
        if (hashtable2.getValor(nombre_completo) == null) {
            JOptionPane.showMessageDialog(null, "Este usuario no está registrado");
        }else{
            JOptionPane.showMessageDialog(null, "Su habitación es la número " + hashtable2.getValor(nombre_completo));
        }
        
        return null;
    }//cierre del método
}//cierre de la clase
