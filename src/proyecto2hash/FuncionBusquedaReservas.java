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
 * @author Edgar Torres
 * @version 24/03/2024
 */
public class FuncionBusquedaReservas {
    
    //campos de la clase
    
    /**
     * Este método es para buscar las reservas que están en el archivo y meterlas en el ABB
     * @param cedulacliente cedula del cliente deseado
     * @return null
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public String BuscarReservas(String cedulacliente) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src//archivos//reservas.csv"));
        String line;
        String listareservas = "";
        while((line = reader.readLine()) != null){
            listareservas = listareservas + line + "\n";
        }
        String[] reservas = listareservas.split("\n");
        int i = 1;
        ArbolBinarioBusquedaReservacion arbol1 = new ArbolBinarioBusquedaReservacion();
        while(i < reservas.length) {
            String[] reserva = reservas[i].split(";");
            String reservacedula = reserva[0];
            if (reservacedula.equals(cedulacliente)) {
                Reserva reservaarbol = new Reserva("Cédula: " + reserva[0], "Nombre: " + reserva[1], "Apellido: " + reserva[2], "Correo: " + reserva[3], "Género: " + reserva[4], "Tipo de habitación: " + reserva[5], "Celular: " + reserva[6], "Llegada: " + reserva[7], "Salida: " + reserva[8]);
                arbol1.insertar(reservaarbol, arbol1.getRaiz());
            }
            i++;
        }
        
        String reservacliente = arbol1.inOrden(arbol1.getRaiz());
        JOptionPane.showMessageDialog(null, "La reserva del cliente que busca es \n" + reservacliente);
        return null;
    }//cierre del método
}//cierre de la clase
