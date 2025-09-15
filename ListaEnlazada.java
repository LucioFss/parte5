
public class ListaEnlazada<T> implements Lista<T>{
    private Node<T> cabezal; //Primer elemento de la lista
    private int size; //Cantidad todal de elemetos de la lista

    //Constructor
    public ListaEnlazada(){
        this.cabezal = null;
        this.size = 0;
    }

    /**
     * Metodo que añade un elemento al inicio de la lista
     * @param T elemento que se añadira
     */
    @Override
    public void insertarInicio(T elem) {
        Node<T> newNode = new Node<>(elem);
        newNode.next = cabezal; //El nuevo nodo apunta al que estaba primero en el la lista
        cabezal = newNode; //Sustituimos al primer elemento por el nuevo nodo 
        size++; //Se incrementa la cantidad total elementos
        }
    
    /**
     * Metodo que añade un elemento al final de la lista 
     * @param T elemento que se añadira 
     */
    @Override
    public void insertarFin(T elem) {

        Node<T> newNode = new Node<>(elem);//Nodo a agregar
        
        //Si la lista esta vacia se agrega a la cabeza
        if(cabezal == null){
            cabezal = newNode;//Se agrega el nuevo nodo
            size++;//Se incrementa la cantidad total elementos//Se incrementa la cantidad de elementos
        }else{
            Node<T>actual = cabezal; //Nodo para recorrer las direciones de cada nodo
            
            //Se recorre la lista hasta que se encuentra un elemento siguiente nulo, por ende estamos en el ultimo nodo
            while(actual.next != null){
                actual = actual.next;//Se recorre atravez de direcciones de memoria
            }
            actual.next = newNode;//Se hace apuntar al nodo con direccion null a el nuevo nodo
            size++;//Se incrementa la cantidad total elementos
        }
    }

    /**
     * Metodo que añade un elemento a la lista en una posicion especifica
     * @param T elemento que se añadira
     * @param int posicion en la que se quiere añadir el elemento
     */
    @Override
    public void insertarPos(T elem, int pos) {
        Node<T> newNode = new Node(elem);
        //Lista vacia, entonces es el primer elemento
        if(pos == 0){
            cabezal = newNode; //Se agrega el nodo siendo el nuevo cabezal
            size++;//Se incrementa la cantidad total elementos
        }else{
            Node<T> actual = cabezal;

            int i = 0;
            while(i < pos-1){
                actual = actual.next;//Se recorre atravez de direcciones de memoria
                i++;
            }
            //Comprobacion si es el ultimo elemento de la lista
            if(actual.next == null){
                actual.next = newNode; //Se agrega el elemento al final de la lista cambiando null por este elemento
                size++;//Se incrementa la cantidad total elementos
            }else{
                //El siguiente de mi nuevo nodo sera en el que lo voy a agregar
                newNode.next = actual.next;
                //
                actual.next = newNode;
                size++;//Se incrementa la cantidad total elementos
            }
        }
    }

    /**
     * Metodo que remueve el primer elemento de la lista y lo devuelve
     * @return T el ultimo elemento de la lista
     */
    @Override
    public T eliminarPrimero() {
        if(size == 0){
            throw new IndexOutOfBoundsException("Lista vacia");
        }
        Node<T> actual = cabezal;
        
        if(actual.next == null){
            cabezal = null; // se pisa el elemento con null
            size--;//Se reduce la cantidad total de elementos
            return actual.item; //Devuelve el elemento eliminado en la primera posicion
        }else{
            Node<T> aux = actual; //Se guarda el elmento que se va a eliminar
            actual = cabezal.next; //Ahora el actual es el siguiente a el
            cabezal = actual; //Se pone a la cabeza el nuevo nodo
            size--; //Se reduce la cantidad total de elementos
            return aux.item; //Se retorna el elemento eliminado//
        }
    }

    /**
     * Meotod que remueve el ultimo elemento de la lista y lo devuelve
     * @return T el ultimo elemento de la lista
     */
    @Override
    public T eliminarUltimo() {
        //S
        if(size == 0){
            throw new IndexOutOfBoundsException("Lista vacia");
        }
        Node<T> actual = cabezal;
        Node<T> aux = new Node<>(null);
        
        if(actual.next == null){
            aux = actual; //Se guarda el elemento eliminado
            cabezal = null; //Se pisa el elemento con null
            size--; //Se reduce la cantidad total de elementos
            return aux.item; //Se retorna el elemento eliminado//
        }
        while(actual.next.next != null){
            actual = actual.next; //Se recorre atravez de direcciones de memoria
        }
        aux = actual.next; //Se guarda el elemento que se va a eliminar
        actual.next = null; //El ultimo elemento es pisado por null
        size--; //Se reduce la cantidad total de elementos
        return aux.item; //Se retorna el elemento eliminado
    }
         
    /**
     * Metodo que remueve, en una poscicion especifica, un elemento de la lista y lo devuelve
     * @param int posicion del elemento
     * @return T elemento eliminado en la poscicion
     */
    @Override
    public T eliminarPos(int pos) {
        //Comprobacion de lista vacia
        if(size == 0){
            throw new IndexOutOfBoundsException("Lista vacia"); //Exepcion si la lista esta vacia
        }

        //Comprobacion de indice no valido
        if(pos < 0 || pos>size-1){
            throw new IndexOutOfBoundsException("indice no valido: " + pos); //Exepcion si el indice no es valido
        }
        Node<T> actual = cabezal;
        Node<T> aux = new Node<>(null);
        //evaluacion de eliminar en la primera posicion
        if(pos == 0){
            //Se evalua si la lista posee un unico elemento o almenos 2
            if(cabezal.next != null){
                aux = cabezal; //Se guarda el elemento en la primera posicion
                cabezal = cabezal.next; //reemplazamos el elemento en la posicion actual por su siguiente
                size--; //Se reduce la cantidad total de elementos
                return aux.item; //Se retorna el elemento eliminado//
            }else{
                //Se garda el elemento en el cabezal, se elimina y se retorna
                aux = cabezal; //guadamos el elemento para luago retornalo
                cabezal = null; //El elemento en el cabezal se reemplaza null eliminandolo
                size--; //Se reduce la cantidad total de elementos
                return aux.item; //Se retorna el elemento eliminado
            }
        }else{
            int i = 0;
            //Se recorre hasta 2 antes del elemento que queremos eliminar
            while(i <= pos-2 && actual.next.next != null){
                actual = actual.next; //Se recorre atravez de direcciones de memoria
                i++;
            }
            aux = actual.next; //Se guarda el elmento eliminado
            actual.next = actual.next.next; //El elemeto en que estoy ahora se salta uno y apunta a ese
            size--; //Se reduce la cantidad total de elementos
            return aux.item; //Se retorna el elemento eliminado
        }
    }

    /**
     * Metodo que devuelve el primer elemento de la lista
     * @return T ultimo elemento de la lista
     */
    @Override
    public T obtenerPrimero() {
        //Comprobacion de lista vacia
        if(size == 0){
            throw new IndexOutOfBoundsException("Lista vacia"); //Exepcion si la lista esta vacia
        }
        return cabezal.item; //Devolver el elemento en el cabezal
    }

    /**
     * Metodo que devuelve el ultimo elemento de la lista
     * @return T ultimo elemento de la lista
     */
    @Override
    public T obtenerUltimo() {
        //Comprobacion de lista vacia
        if(size == 0){
            throw new IndexOutOfBoundsException("Lista vacia"); //Exepcion si la lista esta vacia
        }
        Node<T> actual = cabezal;
        //Recorrer toda la lista
        while(actual.next!= null){
            actual = actual.next; //Se recorre atravez de direcciones de memoria
        }
        return actual.item; //Devuelve el elemento en la ultima posicion
    }

    /**
     * Metodo que devuelve un elemento de la lista en una posicion especifica
     * @param int posicion en la que se quiere obtener
     * @return T elemento en la posicion especifico
     */
    @Override
    public T obtenerElemPos(int pos) {
       //Comprobacion de lista vacia
        if(size == 0){
            throw new IndexOutOfBoundsException("Lista vacia"); //Exepcion si la lista esta vacia
        }
        
        //Comprobacion de indice no valido
        if(pos < 0 || pos>size-1){
            throw new IndexOutOfBoundsException("indice no valido: " + pos); //Exepcion si el indice no es valido
        }
        Node<T> actual = cabezal;
        
        for(int i = 0; i < pos; i++){
            actual = actual.next; //Se recorre atravez de direcciones de memoria
        }
        return actual.item; //Se retorna el elemento en esa posicion
    }

    /**
     * Metodo que busca un elemento en la lista y dice si esta o no
     * @return True si el elemento esta en la lista, False si no
     */
    @Override
    public int buscar(T item) {
        //Comprobacion de lista vacia
        if(size == 0){
            throw new IndexOutOfBoundsException("Lista vacia"); //Exepcion si la lista esta vacia
        }
        Node<T> actual = cabezal;
        int i = 0;
        //Recorrer toda la lista
        while (actual.next != null){
            //Comparacion del elemento antes de pasar al siguiente
            if(actual.item.equals(item)){
                return i; //Indice del elemento encotrado
            }
            actual = actual.next;//Se recorre atravez de direcciones de memoria
            i++;
        }
        return -1; //No se encontro
    }

    /**
     * Metodo que devuelve el tamaño actual de la lista
     * @return int cantidad de elementos totales de la lista
     */
    @Override
    public int longitud() {
        return size; //Se devuelve la cantidad total de elementos en la lista
    }

    /**
     * Metodo que evalua si la lista esta vacia o no
     * @return True si la lista no tiene elementos, False si tiene
     */
    @Override
    public boolean esVacia() {
        return size == 0 && cabezal == null;
    }
    
    /**
     * Metodo que imprime toda la lista como un string en la 
     */
    @Override
    public void imprimir() {
        Node<T>actual = cabezal;
        //Recorrer toda la lista
        while(actual != null){
            System.out.print("["+actual.item+"]"); //Item que posee el nodo
            actual = actual.next; //Se recorre atravez de direcciones de memoria
        }
        System.out.print("["+"null"+"]\n"); //Es la direccion a la que apunta el ultimo elemento

    }
}
