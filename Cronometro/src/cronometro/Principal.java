/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;

import cronometro.logica.Cronometro;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Estudiantes
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cronometro c = new Cronometro();
        
        TimerTask timerTask ;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                c.avanzar();
                System.out.println(c.obtenerTiempo());
            }
        };
        TimerTask timerTask2 ;
        timerTask2 = new TimerTask() {
            @Override
            public void run() {
                c.retroceder();
                System.out.println(c.obtenerTiempo());
            }
        };
        Timer timer = new Timer();      
        
        
        for (int i = 0; i < 1000; i++) {
            timer.scheduleAtFixedRate(timerTask, 0, 100);
            if(i % 100 == 0){
                c.guardarMemoria();
            }
        }
        
        System.out.println("Memorias:");
        c.mostrarMemorias();
        
        System.out.println("Retrocediendo:");
        
        for (int i = 0; i < 1000; i++) {
            timer.scheduleAtFixedRate(timerTask2, 0, 100);
        }
        
    }
    
}
