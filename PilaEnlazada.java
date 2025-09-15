/**
 * CLASE QUE IMPLEMENTA FUNCIONALIDADES DE PILAS MEDIANTE LA CLASE ListaEnlazada
 */
public class PilaEnlazada<T> implements Pila<T>{
    
    private final ListaEnlazada<T> lista; //Declaracion de la lista

    /**
     * Constructor
     * Se inicializa la lista que implementa todos los metodos requeridos
     */
    public PilaEnlazada(){
        this.lista = new ListaEnlazada<>();

    }

    /**
     * Metodo que añade un elemento al tope
     */
    @Override
    public void apilar(T item){
        lista.insertarInicio(item); //Se agrega el elemento en la primera posicion de la lista
    }

    /**
     * Metodo que elimina el elemento en el tope y lo devuelve
     * @return T elemento en el tope
     */
    @Override
    public T desapilar(){
        //Se comprueba si la lista esta vacia
        if(lista.esVacia()){
            throw new IndexOutOfBoundsException("Pila vacia"); //Exepcion de indice fuera de alcance
        }
        T aux = lista.obtenerPrimero(); //Se obtiene el elemento en la primera posicion de la lista
        lista.eliminarPrimero(); //Se elimina el elemento en el tope
        return aux; //Se retorna el elemento eliminado;
    }

    /**
     * Metodo que devuelve si es verdadero o falso que la pila no tiene elementos 
     * @return True si la pila no tiene elementos o False si tiene elementos
     */
    @Override
    public boolean esVacia(){
        return lista.esVacia(); //Metodo que devuelve si la lista posee o no elementos
    }

    /**
     * Elimina todos los elementos de la pila
     */
    @Override
    public void vaciar(){
        //Iteracion que elimina elementos hasta que la lista queda vacia
        while(!lista.esVacia()){
            lista.eliminarPrimero(); //Se elimina el elemento en el tope
        }
    }

    /**
     * Metodo que devuelve el elemento que se encuentra en el tope de la pila
     * @return T elemento en el tope
     */
    @Override
    public T verTope(){
        return lista.obtenerPrimero(); //Devuelve el primer elemento de la lista
    }

    public void imprimir(){
        lista.imprimir();
    }
}
