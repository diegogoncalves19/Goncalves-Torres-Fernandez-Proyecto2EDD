/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Esta clase define las funciones para realizar el check out de un cliente
 * @author Jesús Fernandez
 * @version 24/03/2024
 */
public class FuncionCheckOut {

    //campos de la clase
    
    /**
     * Este método es para realizar el check out de la persona, leyendo sus datos y después cambiando los datos en los CSV
     * @param cedulaescogida cedula del cliente
     * @param correoescogido correo del cliente
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void RealizarCheckOut(String cedulaescogida, String correoescogido) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src//archivos//estado.csv"));
        String line;
        String clientes = "";
        while((line = reader.readLine()) != null){
            clientes = clientes + line + "\n";
        }
        String[] estado = clientes.split("\n");
        
        BufferedReader reader2 = new BufferedReader(new FileReader("src//archivos//historico.csv"));
        String line2;
        String historial = "";
        while((line2 = reader2.readLine()) != null){
            historial = historial + line2 + "\n";
        }
        
        String nuevo_reservas = "";
        String clientecheckout = "";
        int i = 1;
        
        while(i < estado.length) {
            String[] valor = estado[i].split(";");
            String correo = valor[3];
            if (correo.equals(correoescogido)) {
                
                clientecheckout += cedulaescogida + ";" + valor[1] + ";" + valor[2] + ";" + valor[3] + ";" + valor[4] + ";" + valor[6] + ";" + valor[0];
                
            }else{
                
                nuevo_reservas += estado[i] + "\n";
                        
            }
            i++;
        }
        
        String nuevo_historico = historial + clientecheckout;
        
        File viejo_archivo1 = new File("src//archivos//estado.csv");
        viejo_archivo1.delete();
        File nuevo_archivo1 = new File("src//archivos//estado.csv");
        
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(nuevo_archivo1))) {
            writer1.write(nuevo_reservas);
        }
        
        File viejo_archivo2 = new File("src//archivos//historico.csv");
        viejo_archivo2.delete();
        File nuevo_archivo2 = new File("src//archivos//historico.csv");
        
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(nuevo_archivo2))) {
            writer2.write(nuevo_historico);
        }
        
        JOptionPane.showMessageDialog(null, "Su check-out ha sizo realizado.");
    }//cierre del método
}//cierre de la clase
