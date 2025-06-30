package paquete01;

import java.util.ArrayList;
import paquete02.Grafo;

public class Ejecutor {

    public static void main(String[] args) {

        Grafo g = new Grafo(true);

        g.agregarArista("2", "0");
        g.agregarArista("0", "6");
        g.agregarArista("6", "3");
        g.agregarArista("0", "5");
        g.agregarArista("5", "6");
        g.agregarArista("0", "1");
        g.agregarArista("1", "4");
        g.agregarArista("4", "6");

        ArrayList<String> recorridoA = g.recorridoAmplitud("2");
        // ArrayList<String> recorridoB = g.recorridoAmplitud("B");
        // ArrayList<String> recorridoC = g.recorridoAmplitud("C");

        System.out.println("Recorrido en Amplitud");

        System.out.println(recorridoA);
        // System.out.println(recorridoB);
        // System.out.println(recorridoC);

        ArrayList<String> recorridoAd = g.recorridoProfundidad("2");
        // ArrayList<String> recorridoBd = g.recorridoProfundidad("B");
        // ArrayList<String> recorridoCd = g.recorridoProfundidad("C");

        System.out.println("\nRecorrido en Profundidad");

        System.out.println(recorridoAd);
        // System.out.println(recorridoBd);
        // System.out.println(recorridoCd);

    }

}
