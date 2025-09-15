
public interface Pila<T>{

    void apilar(T item);

    T desapilar();

    boolean esVacia();

    void vaciar();

    T verTope();
}
