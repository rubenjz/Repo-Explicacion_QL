
package arbolbinariobusqueda;

/**
 * @author HP CORE I5
 */

class Metodos {
    public class Node{
        int valor; //value
        Node izq;//left
        Node der;//right
        
        Node (int valor){
            this.valor = valor;
            der = null;
            izq = null;
        } 
    }
    
    //ARBOL BINARIO DE BUSQUEDA 
    public class ABB {
        Node raiz; //root
        
        public void add(int valor){
            raiz = addRecursive(raiz,valor);
        }
        
        private Node addRecursive(Node current, int valor){
        if (current == null){
            return new Node(valor);
        }
        if (valor < current.valor){
            current.izq = addRecursive(current.izq,valor);
        }else if(valor > current.valor){
            current.der = addRecursive(current.der,valor);
        }else{
            //VALOR YA EXISTENTE
            return current;
        }
        return current;//PARA DEVOLVER LA RAIZ
        } 
        
        private Node deleteRecursive(Node current, int valor){
            if(current == null){
                return null;
            }
            if (valor == current.valor){
                //when the node is leaf node 
                if(current.izq == null && current.der == null){
                    return null;
                }
                //the case when the node has one child
                if (current.der == null){
                    return current.izq;
                }
                if (current.izq == null) {
                    return current.der;
                }
                int smallestValue = findSmallestValue(current.der);
                current.valor = smallestValue;
                current.der = deleteRecursive(current.der,smallestValue);
                return current;
            }
            if (valor < current.valor) {
                current.izq = deleteRecursive(current.izq,valor);
                return current; 
            }
            current.der = deleteRecursive(current.der,valor);
            return current;
        }
        
        private int findSmallestValue(Node raiz){
            return raiz.izq == null ? raiz.valor : findSmallestValue(raiz.izq);
        }
        
        public void delete(int valor){
            raiz = deleteRecursive(raiz,valor);
        }
        
        
        
        public void PreOrden(Node nodo){
            if(nodo != null){
                System.out.println(" "+ nodo.valor);
                PreOrden(nodo.izq);
                PreOrden(nodo.der);
            }
        }
        
        public void InOrden(Node nodo){
            if (nodo != null){
                InOrden(nodo.izq);
                System.out.println(" "+ nodo.valor);
                InOrden(nodo.der);
            }
        }
        
        public void PostOrden (Node nodo){
            if(nodo != null){
                PostOrden(nodo.izq);
                PostOrden(nodo.der);
                System.out.println(" "+ nodo.valor);
          
          }
        }
        
    }
    
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ArbolBinarioBusqueda {

    public static void main(String[] args) {
        //ABB bt = new ABB();
        Metodos.ABB bt = new Metodos().new ABB();
        bt.add(4);
        bt.add(6);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
       
        
        
        System.out.println("Recorrido PreOrden:");
        bt.PreOrden(bt.raiz);
        
        System.out.println("\nRecorrido InOrden:");
        bt.InOrden(bt.raiz);

        System.out.println("\nRecorrido PostOrden:");
        bt.PostOrden(bt.raiz);

        // Eliminar un valor del árbol
        bt.delete(8);

        System.out.println("\nRecorrido InOrden después de eliminar 8:");
        bt.InOrden(bt.raiz);
    }
}
