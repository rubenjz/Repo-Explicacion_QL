package lista_cdoble;

public class Lista_Cdoble {

    public static void main(String[] args) {
        ListaCircularDobleEnlazada lista = new ListaCircularDobleEnlazada();

        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);

        lista.imprimirLista(); // Salida: 1 2 3
    }
    
}

class Nodo {
    int valor;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}

class ListaCircularDobleEnlazada {
    Nodo cabeza;

    public ListaCircularDobleEnlazada() {
        this.cabeza = null;
    }

    public void agregarAlFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            Nodo ultimo = cabeza.anterior;
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = ultimo;
            cabeza.anterior = nuevoNodo;
            ultimo.siguiente = nuevoNodo;
        }
    }

    public void imprimirLista() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = cabeza;
        do {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }
    
    public void eliminarNodo(int valor) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        boolean encontrado = false;

        do {
            if (actual.valor == valor) {
                encontrado = true;

                if (actual == cabeza && actual.siguiente == cabeza) {
                    // Único nodo en la lista
                    cabeza = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;

                    if (actual == cabeza) {
                        cabeza = actual.siguiente;
                    }
                }

                break;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (encontrado) {
            System.out.println("Nodo con valor " + valor + " eliminado.");
        } else {
            System.out.println("Nodo con valor " + valor + " no encontrado en la lista.");
        }
    }
}