

import java.util.Arrays;

public class ListaArreglo<T> implements Lista<T>{
    //Donde se guardaran los elementos
    private final T[] lista;
    //La cantidad de elementos dentro de la lista
    private int indice;

    @SuppressWarnings("unchecked")
    public ListaArreglo(){
        super();
        this.lista = (T[])new Object[10];
        indice = 0;

    }

    /**
     * Añade un elemento el en inicio de la lista
     * @param T un elemento del tipo generico
     */
    @Override
    public void insertarInicio(T elem){
        // Desplazar a la izquierda
        for (int i = indice; i >= 0; i--) {
            //en la poscion siguiente se agrega el elemento en la posicion que esta atras
            lista[i+1] = lista[i];
        }
        //se agrega el elemento al principio
        lista[0] = elem;
        //se incrementa la cantidad de elementos en la lista
        indice++;
    }
    /**
     * Añade un elemento al final de la lista
     * @param T un elemento del tipo generico
     */
    @Override
    public void insertarFin(T elem){
        lista[indice] = elem; // no es indice+1 ya que nos saltariamos una posicion, por que indice no se cuenta desde -1 sino desde 0
        indice++;
    }

    /**
     * Añade un elemento en la posicion especificada
     * @param T elemento de tipo generico
     * @param Int posicion en la lista en la que se añadira el elemento
     */
    @Override
    public void insertarPos(T elem, int pos){
        if(pos < 0 || pos > indice){
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }
        //Se deplazan los elementos hacia la derecha desde la ultima posicion valida (indice-1)
        //Haciendo espacio en la lista
        for(int i = indice -1 ; i >= pos; i--){
            lista[i+1] = lista[i];
        }
        lista[pos] = elem;
        indice++;
    }

    /**
     * Metodo que elimina el primer elemento de la lista y lo devuelva
     * @return T el elemento eliminado de la lista en el inicio <T>
     */
    @Override
    public T eliminarPrimero(){
        T eliminado = lista[0];

        /*
        arrancamos la iteracion saltandonos el primer elemento y lo saltamos y es como desplazar
        el arreglo hacia la derecha sustituyendo el elemento anterior por el siguiento haciendo
        el espacio al final
        */
        for(int i = 1; i < lista.length; i++){
            lista[i-1] = lista[i];
        }
        //Se limpia el ultimo elemento valido
        lista[indice-1] = null;
        //Se decrementa la cantidad de elementos de la lista
        indice--;
        return eliminado;
    }
    
    /**
     * Metodo que elimina y devuelve el ultimo elemento de la lista
     * @return El elemento en la ultima posición eliminado <T>
     */
    @Override
    public T eliminarUltimo() {
        T eliminado = lista[indice-1];
        //Se elimina el ultimo elemento 
        lista[indice-1] = null;
        //Se decrementa la cantidad de elementos
        indice--;
        return eliminado;
    }

    /**
     * Metodo que elimina y devuelve el elemento en la lista en una poscion especifica
     * @param int la posicion que se quiere eliminar de la lista
     * @return Elemento eliminado de la lista de tipo <T>
     */
    @Override
    public T eliminarPos(int pos){
        if(pos < 0 || pos >= indice){
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }
        T eliminado = lista[pos];
        //Desplazamos los elementos hacia la izquiera pisando el elemento que queremos eliminar
        for(int i = pos; i < indice-1; i++){
            lista[i] = lista[i+1];
        }
        //Borramos el ultimo elemento
        lista[indice-1] = null;
        //Se decrementa la cantidad de elementos totales
        indice--;
        return eliminado;
    }

    /**
     * Metodo para obtener el primer elemento de la lista
     * @return Primer elemento de la lista de tipo <T>
     */
    @Override
    public T obtenerPrimero() {
        return lista[0];
    }

    /**
     * Metodo para obtener el elemento en la ultima posición de la lista
     * @return Ultimo elemento de la lista de tipo <T>
     */
    @Override
    public T obtenerUltimo() {
        return lista[indice-1];
    }

    /**
     * Metodo para obtener un elemento de la lista en una posición especifica
     * @param int posicion de elemento que se quiere obtener
     * @return Elemento en la poscion especificada de tipo <T>
     */
    @Override
    public T obtenerElemPos(int pos) {
        if(pos < 0 || pos >= indice){
            throw new IndexOutOfBoundsException("Posicion inválida " + pos);
        }
        return lista[pos];
    }

    /**
     * Metodo que retorna el indice en el que se encuentra un elemeto   
     * @param T elemento que esta dentro de la lista
     * @return indice del elemento buscado (-1 si no se encontro)
     */
    @Override
    public int buscar(T item) {
        for(int i = 0; i < indice; i++){
            if(lista[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Metodo que retorna la cantidad de elemetos dentro de la lista
     * @return elementos totales dentro de la lista
     */
    @Override
    public int longitud() {
        return indice;
        
    }

    @Override
    public boolean esVacia() {
        return indice == 0;
    }

    /**
     * Metodo que imprime en consola los elementos de la lista
     */
    @Override
    public void imprimir() {
        /**
         * copy of range, metodo que copia un arreglo en un rago inicial y final
         * 1° parametro es el arreglo del que se hara copia
         * 2° parametro indice desde (incluido)
         * 3° parametro indice hasta (sin incluir)
        */
        T[] copiaLista = Arrays.copyOfRange(lista,0,indice);
        System.out.println(Arrays.toString(copiaLista));
    }

}
