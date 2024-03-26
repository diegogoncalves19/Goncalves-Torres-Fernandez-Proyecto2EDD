/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2hash;

import interfaces.Inicio;
import java.io.IOException;

/**
 * Esta es la clase main donde se muestra la interfaz
 * @author Diego Goncalves
 * @version 25/03/2024
 */
public class MostrarInterfaz {
    
    //campos de la clase

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Inicio inicio = new Inicio();
        inicio.show(true);
    }
    
}//cierre de la clase
