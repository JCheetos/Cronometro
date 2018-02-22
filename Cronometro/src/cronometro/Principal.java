/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;

import cronometro.logica.Cronometro;



/**
 *
 * @author Estudiantes
 */
public class Principal {

    
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        int o=0;
        for (int i = 0 ; i <864000; i++){
            c.avanzar();
            System.out.println(c.obtenerTiempo());
            if(i%100 == 0){
                c.guardarMemoria(o);
                o++;
            }
        }
        System.out.println();
        System.out.println("Memorias: ");
        c.mostrarMemorias();
        
    }
}
