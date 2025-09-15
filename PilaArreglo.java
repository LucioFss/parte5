/**
 * CLASE QUE IMPLEMENTA UN SIMULACION DE STACK MEDIANTE UNA CLASE LLAMADA ListaArreglo
 */
public class PilaArreglo<T> implements Pila<T>{

    private final ListaArreglo<T> lista; //Atravez de esta clase se implementan todas funcionalidades necesarias
    
    /**
     * Contructor de la clase
     * Se incializa la clase lista
     */
    public PilaArreglo(){
        this.lista = new ListaArreglo<>();
    }

    /**
     * Metodo que apila un elemento
     * @param T elemento que sera apilado
     */
    @Override
    public void apilar(T item) {
        lista.insertarInicio(item); //Se inserta en el principio de la lista
    }

    /**
     * Metodo que desapila un elemento y no lo retorna
     */
    @Override
    public T desapilar() {
        //Se comprueba que la lista no este vacia, apesar de que el metodo de la clase ListaArreglo ya lo haga
        if(lista.esVacia()){
            throw new IndexOutOfBoundsException("Pila vacia");
        }
        T aux = lista.obtenerPrimero();
        lista.eliminarPrimero(); //Elimina el primer elemento de la lista
        return aux;
    }

    /**
     * Metodo que devuelve true o false si la pila esta vacia
     * @return True si la pila esta vacia, false si posee elementos
     */
    @Override
    public boolean esVacia() {
        return lista.esVacia(); //Metodo de listaArreglo
    }

    /**
     * Metodo que deja sin elemento a la pila
     */
    @Override
    public void vaciar() {
        //Iteracion que elmina primeros elementos hasta que la lista es vacia
        while(!lista.esVacia()){
            lista.eliminarPrimero(); //Elimina el primer elemento de la lista
        }
    }

    /**
     * Metodo que devuelve el elemento que se encentra primero en la pila
     */
    @Override
    public T verTope(){
        return lista.obtenerPrimero(); //Se devuelve el elemento en la primera posicion de la lista
    }

    public void imprimir(){
        lista.imprimir();
    }
}
