package representacionMatriz;

import java.util.Scanner;

/**
 *
 * @author santy
 */

public class Principal {
    public static void main(String[] args) {
        Grafo g = new Grafo(5,false);
        
        g.addVertices("A");
        g.addVertices("B");
        g.addVertices("C");
        g.addVertices("D");
        g.addVertices("E");
        
        g.addArista("A","A");
        g.addArista("A","B");
        g.addArista("A","D");
        g.addArista("B","C");
        g.addArista("B","E");
        g.addArista("C","E");
        g.addArista("D","E");
        
        g.printMatriz();
        
        g.deleteArista("B","E");
        // g.deleteArista("E","B");
        g.deleteArista("A","E");
        
        g.printMatriz();
    }
    
}
