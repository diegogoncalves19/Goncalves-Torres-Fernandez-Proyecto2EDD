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
 * Esta clase define las funciones para buscar el historial de la habitación deseada
 * @author Edgar Torres
 * @version 24/03/2024
 */
public class FuncionHistorialHabitacion {
    
    //campos de la clase
    
    /**
     * Este método es para buscar las personas que estuvieron en la habitación deseada y meterlas en el ABB
     * @param habitacionescogida habitación para buscar
     * @return null
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public String BuscarHistorialHabitacion(String habitacionescogida) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src//archivos//historico.csv"));
        String line;
        String historial = "";
        while((line = reader.readLine()) != null){
            historial = historial + line + "\n";
        }
        String[] habitaciones = historial.split("\n");
        int i = 1;
        ArbolBinarioBusquedaHabitaciones arbol2 = new ArbolBinarioBusquedaHabitaciones();
        while(i < habitaciones.length) {
            String[] habitacion = habitaciones[i].split(";");
            String numhab = habitacion[6];
            if (numhab.equals(habitacionescogida)) {
                Cliente cliente = new Cliente("Cédula: " + habitacion[0], "Nombre: " + habitacion[1], "Apellido: " + habitacion[2], "Correo: " + habitacion[3], "Genero: " + habitacion[4], habitacion[5]);
                arbol2.insertar(cliente, arbol2.getRaiz());
            }
            i++;
        }
        
        String listahabitaciones = arbol2.inOrden(arbol2.getRaiz());
        JOptionPane.showMessageDialog(null, "La lista de clientes que estuvieron en esta habitación son: \n" + listahabitaciones);
        return null;
    }//cierre del método
    
}//cierre de la clase
