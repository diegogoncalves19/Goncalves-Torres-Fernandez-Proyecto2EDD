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
 * Esta clase define las funciones para realizar el check in de un cliente
 * @author Jesús Fernandez
 * @version 25/03/2024
 */
public class FuncionCheckIn {
    
    //campos de la clase

    /**
     * Este método es para realizar el check in de la persona, leyendo sus datos y después cambiando los datos en los CSV
     * @param cedulaescogida cedula del cliente
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void RealizarCheckIn(String cedulaescogida) throws FileNotFoundException, IOException{
        BufferedReader reader1 = new BufferedReader(new FileReader("src//archivos//reservas.csv"));
        String line1;
        String listareservas = "";
        while((line1 = reader1.readLine()) != null){
            listareservas = listareservas + line1 + "\n";
        }
        String[] reservas = listareservas.split("\n");
        
        BufferedReader reader2 = new BufferedReader(new FileReader("src//archivos//estado.csv"));
        String line2;
        String listaclientes = "";
        while((line2 = reader2.readLine()) != null){
            listaclientes = listaclientes + line2 + "\n";
        }
        String[] clientes = listaclientes.split("\n");
        
        BufferedReader reader3 = new BufferedReader(new FileReader("src//archivos//habitaciones.csv"));
        String line3;
        String listahabitaciones = "";
        while((line3 = reader3.readLine()) != null){
            listahabitaciones = listahabitaciones + line3 + "\n";
        }
        String[] habitaciones = listahabitaciones.split("\n");
        
        String nuevo_reservas = "";
        String clientecheckin = "";
        String habitacionesagarradas = "";
        int i = 1;
        int j = 1;
        int k = 1;
        
        while(k < clientes.length){
            String[] valor3 = clientes[k].split(";");
            habitacionesagarradas += valor3[0] + "\n";
            k++;
        }
                
        while(i < reservas.length) {
            String[] valor = reservas[i].split(";");
            String cedula = valor[0];
            if (cedula.equals(cedulaescogida) == true) {
                
                while(j < habitaciones.length){
                    String[] valor2 = habitaciones[j].split(";");
                    String tiphab = valor2[1];
                    String numhab = valor2[0];
                    String tiphabcliente = valor[5];

                    if (tiphab == null ? tiphabcliente == null : tiphab.equals(tiphabcliente)) {
                        
                        if (habitacionesagarradas.contains(numhab)) {
                            System.out.println("No está.");
                        }else{
                            JOptionPane.showMessageDialog(null, "Su número de habitación es " + numhab + ". Espero que disfrute su estadía!");
                                
                            clientecheckin += numhab + ";" + valor[1] + ";" + valor[2] + ";" + valor[3] + ";" + valor[4] + ";" + valor[6] + ";" + valor[7];
                            break;
                        }
                    }
                    j++;
                }
                
            }
            else{
                
                nuevo_reservas += reservas[i] + "\n";
                        
            }
            i++;
        }
        
        String nuevo_estado = listaclientes + clientecheckin;
        File viejo_archivo1 = new File("src//archivos//estado.csv");
        viejo_archivo1.delete();
        File nuevo_archivo1 = new File("src//archivos//estado.csv");
        
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(nuevo_archivo1))) {
            writer1.write(nuevo_estado);
        }
        
        File viejo_archivo2 = new File("src//archivos//reservas.csv");
        viejo_archivo2.delete();
        File nuevo_archivo2 = new File("src//archivos//reservas.csv");
        
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(nuevo_archivo2))) {
            writer2.write(nuevo_reservas);
        }        
                
    }//cierre del método
}//cierre de la clase
