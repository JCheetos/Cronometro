/*
 * Cronometro.java
 * Copyright (c) 2018 Valentina Tobo 20172020063, Camilo Torres 20172020067, Johan Mendez 20172020070
 */
package cronometro.logica;

import java.util.ArrayList;

/**
 * La clase Cronometro define y maneja las variables necesarias para el
 * funcionamiento completo del cronometro
 *
 * @author Valentina Uscategui Tobo - 20172020063
 * @author Camilo Torres Rodriguez - 20172020067
 * @author Johan Mendez Vega - 20172020070
 */
public class Cronometro {

    private UnidadTiempo decimas;
    private UnidadTiempo segundos;
    private UnidadTiempo minutos;
    private UnidadTiempo horas;

    private ArrayList<Memoria> memorias;

    /**
     * Constructor de la clase
     */
    public Cronometro() {
        decimas = new UnidadTiempo(10);
        segundos = new UnidadTiempo(60);
        minutos = new UnidadTiempo(60);
        horas = new UnidadTiempo(24);
        memorias = new ArrayList<Memoria>();
    }

    /**
     * La funcion se encarga de retornar el valor de las decimas del objeto tipo
     * Cronometro del cual es llamada
     */
    public UnidadTiempo getDecimas() {
        return decimas;
    }

    /**
     * La funcion se encarga de definir el valor de las decimas del objeto tipo
     * Cronometro del cual es llamada
     */
    public void setDecimas(UnidadTiempo decimas) {
        this.decimas = decimas;
    }

    /**
     * La funcion se encarga de retornar el valor de los segundos del objeto
     * tipo Cronometro del cual es llamada
     */
    public UnidadTiempo getSegundos() {
        return segundos;
    }

    /**
     * La funcion se encarga de definir el valor de los segundos del objeto tipo
     * Cronometro del cual es llamada
     */
    public void setSegundos(UnidadTiempo segundos) {
        this.segundos = segundos;
    }

    /**
     * La funcion se encarga de retornar el valor de los minutos del objeto tipo
     * Cronometro del cual es llamada
     */
    public UnidadTiempo getMinutos() {
        return minutos;
    }

    /**
     * La funcion se encarga de definir el valor de los minutos del objeto tipo
     * Cronometro del cual es llamada
     */
    public void setMinutos(UnidadTiempo minutos) {
        this.minutos = minutos;
    }

    /**
     * La funcion se encarga de retornar el valor de las horas del objeto tipo
     * Cronometro del cual es llamada
     */
    public UnidadTiempo getHoras() {
        return horas;
    }

    /**
     * La funcion se encarga de definir el valor de las horas del objeto tipo
     * Cronometro del cual es llamada
     */
    public void setHoras(UnidadTiempo horas) {
        this.horas = horas;
    }

    /**
     * Este metodo ejecuta el avance de las decimas, luego revisa se ejecuta una
     * serie de condicionales para ajustar el valor del cronometro, al avanzar
     * segundos, minutos o horas. La razon por la cual las condicionales se
     * revisan en base a cero es debido a que al avanzar las unidades de tiempo,
     * estas tienen un tope, tras el cual son revertidas a cero, al detectar
     * esto el cronometro debe avanzar en la siguiente casilla.
     */
    public void avanzar() {
        decimas.avanzar();
        if (decimas.getValor() == 0) {
            segundos.avanzar();
            if (segundos.getValor() == 0) {
                minutos.avanzar();
                if (minutos.getValor() == 0) {
                    horas.avanzar();
                }
            }
        }
    }

    /**
     * Este metodo ejecuta el retroceso de las decimas, luego revisa se ejecuta
     * una serie de condicionales para ajustar el valor del cronometro, al
     * retroceder segundos, minutos o horas. La razon por la cual las
     * condicionales se revisan en base al tope menos uno es debido a que al
     * retroceder las unidades de tiempo, estas son revertidas al valor del tope
     * menos una unidad al ser menores que cero, al detectar esto el cronometro
     * debe retroceder en la siguiente casilla.
     */
    public void retroceder() {
        decimas.retroceder();
        if (decimas.getValor() == decimas.getTope() - 1) {
            segundos.retroceder();
            if (segundos.getValor() == segundos.getTope() - 1) {
                minutos.retroceder();
                if (minutos.getValor() == minutos.getTope() - 1) {
                    horas.retroceder();
                }
            }
        }
    }

    /**
     * Este metodo muestra las decimas, segundos, minutos y horas en el momento
     * en que es llamado, en un formato con sentido logico.
     */
    public String obtenerTiempo() {
        return horas.obtenerValorFormateado() + " : "
                + minutos.obtenerValorFormateado() + " : "
                + segundos.obtenerValorFormateado() + " : "
                + decimas.obtenerValorFormateado();
    }

    /**
     * Este metodo guarda el tiempo actual, en un espacio de un vector, para ser
     * mostrado en otro momento.
     */
    public void guardarMemoria() {
        Memoria m = new Memoria();

        m.setValorDecimas(decimas.getValor());
        m.setValorSegundos(segundos.getValor());
        m.setValorMinutos(minutos.getValor());
        m.setValorHoras(horas.getValor());

        memorias.add(m);

    }

    /**
     * Este metodo se usa como parte del metodo de visualizacion de las memorias
     * de tiempo guardadas hasta el momento en la interfaz grafica. Este metodo
     * define un formato adecuado tipo String para las memorias guardadas, para
     * asivisualizarse de manera ordenada en la interfaz grafica.
     */
    public String mostrarMemoriasGUI() {
        String a = "";
        for (Memoria memoria : memorias) {
            a = (a + memoria.obtenerTiempo() + "\n");
        }
        return a;
    }
}
