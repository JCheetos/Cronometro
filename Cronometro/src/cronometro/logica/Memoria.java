/*
 * Cronometro.java
 * Copyright (c) 2018 Valentina Tobo 20172020063, Camilo Torres 20172020067, Johan Mendez 20172020070
 */
package cronometro.logica;

/**
 * La clase Memoria define y maneja las variables necesarias para el
 * funcionamiento completo de las memorias
 * @author Valentina Uscategui Tobo - 20172020063 
 * @author Camilo Torres Rodriguez - 20172020067 
 * @author Johan Mendez Vega - 20172020070
 */
public class Memoria {

    private UnidadTiempo decimas;
    private UnidadTiempo segundos;
    private UnidadTiempo minutos;
    private UnidadTiempo horas;
/**
     * Constructor de la clase
     */
    public Memoria() {
        decimas = new UnidadTiempo(10);
        segundos = new UnidadTiempo(60);
        minutos = new UnidadTiempo(60);
        horas = new UnidadTiempo(24);
    }
/**
     * La funcion se encarga de definir el valor de las decimas dentro del espacio del vector de memorias.
     * @param valor int
     */
    public void setValorDecimas(int valor) {
        decimas.setValor(valor);
    }
/**
     * La funcion se encarga de definir el valor de los segundos dentro del espacio del vector de memorias.
     * @param valor int
     */
    public void setValorSegundos(int valor) {
        segundos.setValor(valor);
    }
/**
     * La funcion se encarga de definir el valor de los minutos dentro del espacio de vector memorias.
     * @param valor int
     */
    public void setValorMinutos(int valor) {
        minutos.setValor(valor);
    }
/**
     * La funcion se encarga de definir el valor de las horas dentro del espacio de vector memorias.
     * @param valor int
     */
    public void setValorHoras(int valor) {
        horas.setValor(valor);
    }
/**
     * La funcion se encarga de retornar el valor del tiempo en un formato con sentido.
     */
    public String obtenerTiempo() {
        return horas.obtenerValorFormateado() + " : "
                + minutos.obtenerValorFormateado() + " : "
                + segundos.obtenerValorFormateado() + " : "
                + decimas.obtenerValorFormateado();
    }

}
