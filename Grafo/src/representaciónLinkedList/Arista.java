package representaciónLinkedList;

/**
 *
 * @author santy
 */
public class Arista {
    int destino;
    double peso;
    
    public Arista(int d) {
        destino = d;
    }
    
    public Arista(int d, double p) {
        this(d);
        peso = p;
    }
    
    public int getDestino(){
        return destino;
    }
    
    public boolean equals(Object n) {
        Arista a = (Arista)n;
        return destino == a.destino;
    }
    
}
