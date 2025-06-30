package representaciónLinkedList;

import java.util.LinkedList;

/**
 *
 * @author santy
 */
public class Principal {
    public static void main(String[] args) {
        Grafo grafoLista = new Grafo(5);
        
        grafoLista.nuevoVertice("1");
        grafoLista.nuevoVertice("2");
        grafoLista.nuevoVertice("3");
        grafoLista.nuevoVertice("4");
        grafoLista.nuevoVertice("5");
        
        try {
            grafoLista.nuevoArista("1", "3");
            grafoLista.nuevoArista("1", "4");
            
            grafoLista.nuevoArista("5", "1");
            grafoLista.nuevoArista("5", "2");
            grafoLista.nuevoArista("5", "4");
            
            for (int i = 0; i < grafoLista.numVerts; i++) {
                System.out.print("["+ grafoLista.tablAdc[i].nomVertice() +"] ");
                LinkedList<Object> listaAdy = grafoLista.listaAdyc(i);
                for (Object arista : listaAdy) {
                    Arista a = (Arista) arista;
                    System.out.print("-> "+ grafoLista.tablAdc[a.getDestino()].
                            nomVertice());
                }
                System.out.println();
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
