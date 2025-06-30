package representaciónLinkedList;

import java.util.LinkedList;

/**
 *
 * @author santy
 */
public class Vertice {
    String nombre;
    int numVertice;
    LinkedList<Object> lad;
    
    
    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
        lad = new LinkedList();
    }
    
    // Devuelve verdadero si dos vertices se llaman igual
    public boolean equals(Object d) {
        Vertice dos = (Vertice) d;
        return nombre.equals(dos.nombre);
    }
    
    // Indica el número que identificará este vértice
    public void asigVert(int n) {
        numVertice = n;
    }
    
    // Devuelve el nombre del vértice
    public String nomVertice() {
        return nombre;
    }
    
    // Imprime el nombre y número de vértice
    @Override
    public String toString() {
        return nombre + " (" + numVertice + ")";
    }
    
}
