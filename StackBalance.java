import java.util.Stack;

public class StackBalance{
    
    /**
     * Metodo que evalua si una operacion esta bien balanceada
     * Lo hace mediante una pila
     * @param operation
     * @return True o false, si la operacion esta correctamente balanceada
     */
    public static boolean isBalance(String operation){
        //Evaluacion de operacion a evalua no valida
        if(operation == null || operation.isBlank()){
            throw new NullPointerException("Ingreso no valido");
        }

    
        Stack<Character> pilaChar = new Stack<>(); //Pila que guardara los signos ( { [
        
        char[] letras = new char[operation.length()]; //Arreglo que guadara cada caracter de la operacion
        //Se agrega cada caracter al arreglo
        for(int i = 0; i <letras.length; i++){
            //CharAt obtiene un caracter del indice especificado
            letras[i] = operation.charAt(i);
        }

        /*
         * Se agregan los signos de apertura al la pila, tambien si el signo es de cierre 
         * y la pila vacia es que este no tiene apertura, tambien si el signo de cierre
         * no coincide con el signo de apertura en el tope es que los signos estan desordenados
         */
        for(int i = 0; i<letras.length; i++){
            char signo = letras[i];
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

        /*
         * Se comparan los signos de apertura en la pila, con los de cierre, al final de la 
         * iteracion la pila deberia estar vacia, lo que denota que haya la misma cantidad
         * de signos de cierre y de apertura
         */
        for(int j = 0; j < letras.length; j++){
            char signo = letras[j];
            if(signo == ')' || signo == ']' || signo == '}'){
                pilaChar.pop();
            }
        }

        return pilaChar.empty();
    }

    public static void main(String[] args){
        System.out.println(isBalance("(3+4) * 8"));
        System.out.println(isBalance("(( 3 + 4 ) * 8 "));
        System.out.println(isBalance(")3+4( * 8"));
    }

}