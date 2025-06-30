package representaciónLinkedList;

import java.util.LinkedList;

/**
 *
 * @author santy
 */
public class Grafo {
    int numVerts;
    static int maxVerts = 20;
    Vertice [] tablAdc;
    
    public Grafo(int mx) {
        tablAdc = new Vertice[mx];
        numVerts = 0;
        maxVerts = mx;
    }
    
    public Grafo() {
        this(maxVerts);
    }
    
    public Vertice[] vertices(){
        return tablAdc;
    }
    
    // Devuelve la lista de adyacencia del vértice v
    public LinkedList listaAdyc(int v) throws Exception {
        
        if (v < 0 || v >= numVerts){
            throw new Exception("Vértice fuera de rango");
        }
        return tablAdc[v].lad;
    }
    
    // Busca y devuelve el número de vértice, si no lo encuentra regresa -1
    public int numVertice(String nombre) {
        Vertice v = new Vertice(nombre);
        boolean encontrado = false;
        int i = 0;
        
        for (; (i < numVerts) && !encontrado;){
            encontrado = tablAdc[i].equals(v);
            
            if (!encontrado){
                i++;
            }
        }
        return (i < numVerts) ? i : -1;
    }
    
    // Crea un nuevo vértice
    public void nuevoVertice (String nombre) {
        boolean existe = numVertice(nombre) >= 0;
        
        if (!existe) {
            Vertice v = new Vertice(nombre);
            v.asigVert(numVerts);
            tablAdc[numVerts++] = v;
        }
    } 
    
    // Comprueba si dos vertices son adyacentes
    boolean adyacente(String a, String b) throws Exception{
        int v1, v2;
        v1 = numVertice(a);
        v2 = numVertice(b);
        
        if(v1 < 0 || v2 < 0) {
            throw new Exception ("El vértice no existe");
        }
        
        if (tablAdc[v1].lad.contains(new Arista(v2))) {
            return true;
        } else {
            return false;
        }
    }
    
    // Comprueba si dos vertices son adyacentes por el número de vértice
    boolean adyacente(int v1, int v2) throws Exception{
        
        if (tablAdc[v1].lad.contains(new Arista(v2))) {
            return true;
        } else {
            return false;
        }
    }
    
    
    // Crea una nueva Arista
    public void nuevoArista(String a, String b) throws Exception {
        if (!adyacente(a,b)){
            int v1 = numVertice(a);
            int v2 = numVertice(b);
            
            if(v1 < 0 || v2 < 0) {
                throw new Exception ("El vértice no existe");
            }
            
            Arista ab = new Arista(v2);
            tablAdc[v1].lad.addFirst(ab);
        }
    }
    
    // Borra una Arista ya creada
    public void borrarArista(String a, String b) throws Exception {
        int v1 = numVertice(a);
        int v2 = numVertice(b);
        
        if(v1 < 0 || v2 < 0) {
            throw new Exception ("El vértice no existe");
        }
        
        Arista ab = new Arista(v2);
        tablAdc[v1].lad.remove(ab);
    }
    
}
