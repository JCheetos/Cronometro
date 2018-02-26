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
                if (c.getMinutos().getValor()==1){
                timerTask.cancel();
                }
            }
        };
        TimerTask timerTask2 ;
        timerTask2 = new TimerTask() {
            @Override
            public void run() {
                c.retroceder();
                System.out.println(c.obtenerTiempo());
                if (c.getMinutos().getValor()==1){
                    timerTask2.cancel();
                }
            }
        };
        Timer timer = new Timer();      
        
        while(timerTask.status)
        timer.scheduleAtFixedRate(timerTask, 0, 100);
     
        
        
        System.out.println("Memorias:");
        c.mostrarMemorias();
        
        System.out.println("Retrocediendo:");
        timer.scheduleAtFixedRate(timerTask2, 0, 100);
        
    }
    
}
