

public interface Lista<T> {
    
    //Metodo de agregar elementos
    void insertarInicio(T elem);
    void insertarFin(T elem);
    void insertarPos(T elem, int pos);

    //metodos de eliminar elementos
    T eliminarPrimero(); //elimina y devuelve el primer elemento de la lista
    T eliminarUltimo(); //elimina y devuelve el ultimo elemento de la lista
    T eliminarPos(int pos);//elimina el elemento en la posicion de especificada y lo devuelve

    //Metodos para obtener elementos
    T obtenerPrimero(); //precondición: La lista no es Vacia.
    T obtenerUltimo(); //precondición: La lista no es Vacia.
    T obtenerElemPos(int pos); //precondicion: pos es una posicion valida

    //Metodos auxiliares
     int buscar(T item); //Retorna la posicion en la que se encuentra un elemento o-1 en caso que no se encuentre.
     int longitud(); //Retorna la cantidad de elementos que actualmente almacena la lista
     boolean esVacia(); //Retorna la verdadero si la lista no contiene elementos, falso en caso contrario.
     void imprimir(); //Imprime por pantalla los elementos de la lista

}   
