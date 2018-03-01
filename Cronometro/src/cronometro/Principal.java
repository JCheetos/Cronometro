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
        int a = 0 ;
        
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
        timer.scheduleAtFixedRate(timerTask, 0, 100);
        
        while(a==0){
            if (c.segundos.getValor()==10){
                timerTask.cancel();
                a=1;
            }
        }
        a=0;
        
        System.out.println("Memorias:");
        c.mostrarMemorias();
        
        System.out.println("Retrocediendo:");
        timer.scheduleAtFixedRate(timerTask2, 0, 100);
        
        while(a==0) {
            if (c.segundos.getValor()==10){
                timerTask2.cancel();
                a=1;
            }
        }
    }
    
}
