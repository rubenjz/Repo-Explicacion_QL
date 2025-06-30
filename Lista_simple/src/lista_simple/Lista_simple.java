package lista_simple;

class Nodo {
    int valor;
    Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void agregarAlFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
    
    public void eliminarNodo(int valor) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.valor == valor) {
                actual.siguiente = actual.siguiente.siguiente;
                System.out.println("Nodo con valor " + valor + " eliminado.");
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("Nodo con valor " + valor + " no encontrado en la lista.");
    }
}

public class Lista_simple {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);

        lista.imprimirLista(); // Salida: 1 2 3
    }
    
}
