package representacionMatriz;

/**
 *
 * @author santy
 */
public class Grafo {
    private String[] vertices;
    private int[][] matrizAdyacencia;
    private boolean dirigido;

    public Grafo(int numVer, boolean d) {
        vertices = new String [numVer];
        matrizAdyacencia = new int[numVer][numVer];
        dirigido = d;
    }
    
    public void addVertices(String v) {
        boolean bd = true;
        
        for(int i = 0; i < vertices.length && bd; i++) {
            if(vertices[i] == null) {
                vertices[i] = v;
                bd = false;
            }
        }
    }
    
    public void addArista(String origen, String destino) {
        int i = obtenerIndice(origen);
        int j = obtenerIndice(destino);
        
        if(i >= 0 && j >= 0) {
            matrizAdyacencia[i][j]++;
            
            if(!dirigido) {
                matrizAdyacencia[j][i]++;
            }
        }
    }
    
    public void deleteArista(String origen, String destino) {
        int i = obtenerIndice(origen);
        int j = obtenerIndice(destino);
        
        if(i >= 0 && j >= 0 && existeArista(origen, destino)) {
            matrizAdyacencia[i][j] = 0;
            System.out.println("La arista entre "+ origen +" y "+ destino +" ha"
                    + "sido eliminada");
            
            if(!dirigido) {
                matrizAdyacencia[j][i] = 0;
            }
        }else {
            System.out.println("No existe una arista que conecte el vértice "+
                    origen +" con el vértice "+ destino);
        }
    }
    
    private int obtenerIndice (String v) {
        int indice = -1;
        boolean bd = true;
        
        for(int i = 0; i < vertices.length && bd; i++) {
            String aux = vertices[i];
            
            if(aux.equals(v)) {
                indice = i;
                bd = false;
            }
        }
        
        return indice;
    }
    
    private boolean existeArista(String origen, String destino) {
        int i = obtenerIndice(origen);
        int j = obtenerIndice(destino);
        
        if(i >= 0 && j >= 0 && matrizAdyacencia[i][j] > 0) {
            return true;
            
            /*if(!dirigido) {
                matrizAdyacencia[j][i] = 0;
            }*/
        }else {
            return false;
        }
    }

    public void printMatriz() {
        System.out.println("\nMatriz de Adyacencia del Grafo:");
        System.out.print("  ");
        
        for(int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i]+ " ");
        }
        
        System.out.println("");
        
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            System.out.print(vertices[i]+ " ");
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
}
