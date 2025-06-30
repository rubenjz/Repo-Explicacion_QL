package paquete02;

/**
 *
 * @author ASUS
 */
public class Nodo {

    // debido a que mi nodo tendra un vertice y una arista crearemos 2
    // atributos que Nodo utilizara
    private String vertice;

    // El vertice puede contener cualquier tipo de dato
    private int costoV;

    // Costo hace referencia a un valor que debe poseer una arista 
    // para llegar a ese vertice 
    public Nodo(String vertice, int costo) {

        this.vertice = vertice;
        this.costoV = costo;

    }

    public void establecerVertice(String vertice) {
        this.vertice = vertice;
    }

    public void establecerCosto(int costo) {
        this.costoV = costo;
    }

    public String obtenerVertice() {
        return vertice;
    }

    public int obtenerCosto() {
        return costoV;
    }

}
