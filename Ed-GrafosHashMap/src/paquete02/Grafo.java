package paquete02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafo {

    private HashMap<String, ArrayList<Nodo>> grafo;

    // Importamos la libreria HashMap, esta estructura recibe
    // 2 parametros una llave y valor asociado a esa llave, 
    // en este caso los vertices sera de tipo String y sabemos 
    // que cada vertice se relaciona a un conjunto de vertices.
    
    private boolean dirigido;

    // Este atributo nos indicara si el grafo que construiremos 
    // sera o no dirigido ademas nos ayudara con la elimincaion
    // de aristas, vertices o creacion de aristas o vertices.
    
    public Grafo(boolean dirigido) {

        // hacemos nacer a hashmap
        grafo = new HashMap<>();
        this.dirigido = dirigido;

    }
    
    // Insercion y eliminacion de vertices y aristas
    
    // agregar aristas:
    // Para este metodo debemos conocer de donde a donde queremos
    // ir, en caso de que no existan vertices en el mapa los creara
    // automaticamente(crea independientemente de todo)
    
    public void agregarArista(String origen, String destino){
        
        // crearemos una arista que ira de origen a destino
        
        crearArista(origen, destino);
        
        // Llamaremos a un metodo que nos permitira conocer si el
        // grafo sera dirigido o no, si es este el caso:
        
        if(!dirigido){
        
            crearArista(destino,origen);
        
        }
        
    }
    
    public void crearArista(String origen, String destino){
        
        // necesitamos saber si el vertice origen ya existe o si no
        // dentro de nuestro grafo.
        
        if(!grafo.containsKey(origen)){
            
            // el conteinsKey es un metodo de la clase HashMap, se le
            // podria decir como: si el grafo contiene a origen o en
            // este caso, si el grafo no contiene a origen.
            
            // Si el grafo no contiene a origen lo vamos a crear:
   
            grafo.put(origen, new ArrayList<Nodo>());
            
            // el put es otro metodo de la clase HashMap que nos permite
            // agregar y recibe una llave (origen) un valor asociado 
            // (ArrayList<Nodo>())
            
            // ya que por Ahora el ArrayList es nulo lo creamos.
        
        }
        
        // En caso de que si exista solo accederemos a la lista:
        
        grafo.get(origen).add(new Nodo(destino,1));
        
        // usamos el .get para obtener el metodo asociado (ArrayList)
        // y luego con .add la agregamos creando ahora un Nodo que 
        // recibira como parametros el destino y un costo que por
        // ahora sera 1.
        
    }
    
    // El metodo eliminarArista sera el que elimine a la arista
    
    public void eliminarArista(String origen, String destino){
        
        // Llamamos a nuestro metodo para eliminar arista
    
        eliminarArista2(origen, destino);
        
        // Encaso de que no sea dirigido tambien eliminaremos 
        // el reciproco
        
        if(!dirigido){
        
            eliminarArista2(destino,origen);
        
        }

    }
    
    
    
    public void eliminarArista2(String origen, String destino){
        
        ArrayList<Nodo> lista = grafo.get(origen);
        
        // crearemos un ArrayList que guarde nuestro origen(nuestro
        // origen ahora sera una lista)
        
        boolean bandera = false;
        
        // con la condicional comprobaremos si la lista es distinta de null
        // y asi evitaremos que se encuentre con un error.
    
        if(lista != null){
            
            //Con el recorrido encontraremos el valor a eliminar
            
            for (int i = 0; i < lista.size() && !bandera; i++) {
                
                Nodo ac = lista.get(i);

                // Para cada elemento que sera Nodo sera igual a nuestra
                // lista en la posicion i.

                if(ac.obtenerVertice().equals(destino)){

                    // Gracias  a la condicional sabremos que eliminar

                    lista.remove(i);

                    // .remove nos ayudara a eliminar el valor y hacer 
                    // perder nuestra referencia
                    bandera = true;

                    // la bandera nos ayudara a indicar que elimino el valor.

                }
            
            }
        
        }
        
    }
    
    // Insercion y eliminacion de vertices y aristas
    
    public void agregarVertice(String v){
        
        // Para agregar nuestro vertice:
        // recibimos el vertice que decidimos agregar,a grafo.put le asignaremos
        // el vertice y crearemos un ArrayList para que nuestro elemento exista.
    
        grafo.put(v, new ArrayList<>());
    
    }
    
    public void eliminarVertice(String vertice){      
        // Creamos un ArrayList de tipo nodo que agregue a su lista los valores de
        // grafo.get(vertice)que son todos los ligares a los que llegamos.
        
        ArrayList<Nodo> lista = grafo.get(vertice); 
        // Creamos un ArrayList que guardara todos los vertices donde lleagabamos
        // sera de tipo String por que asignamos que los datos seran String
        
        ArrayList<String> destinos = new ArrayList<>();
        
        // Nuestro for mejorado funciona de la siguiente manera:
        // Asignamos nuestro tipo de dato y asignamos que se mueva sobre lista.
        
        for (Nodo n : lista) {
            
            // A nuestros destinos asignaresmos lo que tenia ese nodo asociado. 
            destinos.add(n.obtenerVertice());
            
        }
        
        // nuestro .remove se encarga de eliminar

        grafo.remove(vertice);
        
        // Nuestro for mejorado funciona de la siguiente manera:
        // Asignamos nuestro tipo de dato y asignamos que se mueva sobre destinos.
        
        for(String s : destinos){
            
            // Invocamos a eliminarAristas para eliminar posibles aristas que
            // hayan estado ligados a nuestro vertice y asi no queden colgados
            eliminarArista(s, vertice);
        
        }

    }
    
    // Recorridos:
    
    // Recorrido por amplitud
    
    public ArrayList<String> recorridoAmplitud(String vertice){
        
        ArrayList<String> orden = new ArrayList<>();
        ArrayList<String> marcado = new ArrayList<>();
        
        Queue<String> cola = new LinkedList<>();
        
        marcado.add(vertice);
        cola.add(vertice);
        
        while(!cola.isEmpty()){
            
            String actual = cola.poll();
            orden.add(actual);
            ArrayList<Nodo> vecinos = grafo.get(actual);
            
            if(vecinos != null){
            
                for(Nodo n : vecinos){
                    
                    String destino = n.obtenerVertice();
                    
                    if(!marcado.contains(destino)){
                        
                        marcado.add(destino);
                        cola.offer(destino);
                    
                    }
                
                }

            }
        
        }
    
        return orden;
    }
    
    // Recorrido por amplitud
    
    public ArrayList<String> recorridoProfundidad(String vertice){
        
        ArrayList<String> orden = new ArrayList<>();
        ArrayList<String> marcado = new ArrayList<>();
        
        Stack<String> pila = new Stack<>();
        
        marcado.add(vertice);
        pila.add(vertice);
        
        while(!pila.isEmpty()){
            
            String actual = pila.pop();
            orden.add(actual);
            ArrayList<Nodo> vecinos = grafo.get(actual);
            
            if(vecinos != null){
            
                for(Nodo n : vecinos){
                    
                    String destino = n.obtenerVertice();
                    
                    if(!marcado.contains(destino)){
                        
                        marcado.add(destino);
                        pila.push(destino);
                    
                    }
                
                }
                
            
            }
        
        }
    
        return orden;
    }

}
