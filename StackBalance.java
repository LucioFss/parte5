
import java.util.Stack;

public class StackBalance{
    
    /**
     * Metodo que evalua si una operacion esta bien balanceada
     * Lo hace mediante una pila
     * @param operation
     * @return True o false, si la operacion esta correctamente balanceada
     */
    public static boolean isBalanceStack(String operation){
        //Evaluacion de operacion a evalua no valida
        if(operation == null || operation.isBlank()){
            throw new NullPointerException("Ingreso no valido");
        }

        Stack<Character> pilaChar = new Stack<>(); //Pila que guardara los signos ( { [

        /*
         * Se agregan los signos de apertura al la pila, tambien si el signo es de cierre 
         * y la pila vacia es que este no tiene apertura, tambien si el signo de cierre
         * no coincide con el signo de apertura en el tope es que los signos estan desordenados
         */
        for(int i = 0; i<operation.length(); i++){
            char signo = operation.charAt(i);
            if(signo == '(' || signo == '[' || signo == '{'){
                pilaChar.push(signo);
                
            //Se verifica a continuacion que aparezca primero un cierre antes que una apertuda
            //Si es verdadero entonces el balance no esta ordenado
            }else if(signo == ')' || signo == '}' || signo == ']'){
                //Pila vacia y se encontro un signo de cierre, entonces no esta ordenado el balanceo
                if (pilaChar.isEmpty()) {
                    return false; // hay un ) sin (
                }
                /*
                 * Se comparan los tipos de cierre con el tope
                 * la logica es que basicamente vamos comparando el signo que tomamos que es un cierre
                 * con un el que supuestamente deberia cerrar y deberia estar en el tope
                 */
                char tope = pilaChar.pop(); //Elemento que esta en el tope que es un signo de apertura
                if(signo == ')' && tope != '('|| //Comparacion parentesis
                   signo == '}' && tope != '{'|| //Comparacion llaves
                   signo == ']' && tope != '['){ //Comparacion corchetes
                    //Se retorna falso si hay signos sin cerrar y en concecuencia no coinciden
                    return false;
                   }
            }
        }
        return pilaChar.empty();
    }

    /**
     * Mismo emetodo que el anterior pero ahora con una implementacion atravez de PilaArreglo implementada por mi
     */
    public static boolean isBalancePilaArreglo(String operation){
        //Evaluacion de operacion a evalua no valida
        if(operation == null || operation.isBlank()){
            throw new NullPointerException("Ingreso no valido");
        }

        PilaArreglo<Character> pila = new PilaArreglo<>();

        for(int i = 0; i < operation.length(); i++){
            char signo = operation.charAt(i);
            if(signo == '(' || signo == '{' || signo == '['){
                pila.apilar(signo);
            }else if(signo == ')' || signo == '}' || signo == '}'){
                if(pila.esVacia()){
                    return false;
                }
                char tope = pila.desapilar();
                if(signo == ')' && tope != '(' ||
                   signo == '}' && tope != '{' ||
                   signo == ']' && tope != '['){
                    return false;
                   }
            }
        }
        return pila.esVacia();
    }
       

    public static void main(String[] args){
        /*
        System.out.println(isBalance("(3+4) * 8"));
        System.out.println(isBalance("(( 3 + 4 ) * 8 "));
        System.out.println(isBalance(")3+4( * 8"));
        */
        PilaArreglo<Integer> pila1 = new PilaArreglo<>();
        pila1.apilar(12);
        pila1.apilar(13);
        pila1.imprimir();
        System.out.println(pila1.verTope());
        System.out.println(pila1.esVacia());
        pila1.desapilar();
        pila1.imprimir();
        pila1.vaciar();
        pila1.imprimir();
        
        PilaEnlazada<String> pila2 = new PilaEnlazada<>();
        pila2.apilar("Camila");
        pila2.apilar("Celene");
        pila2.imprimir();
        System.out.println(pila2.verTope());
        System.out.println(pila2.esVacia());
        pila2.desapilar();
        pila2.imprimir();
        pila2.vaciar();
        pila2.imprimir();

        
        System.out.println(isBalancePilaArreglo("(3+4) * 8"));
        System.out.println(isBalancePilaArreglo("(( 3 + 4 ) * 8 "));
        System.out.println(isBalancePilaArreglo(")3+4( * 8"));
        
    }

}