import java.util.Stack;

public class StackBalance{
    
    /**
     * Metodo que evalua si una operacion esta bien balanceada
     * Lo hace mediante una pila
     * @param operation
     * @return True o false, si la operacion esta correctamente balanceada
     */
    public static boolean isBalance(String operation){
        if(operation == null || operation.isBlank()){
            throw new NullPointerException("Ingreso no valido");
        }

        Stack<Character> pilaChar = new Stack<>();

        char[] letras = new char[operation.length()];
        for(int i = 0; i <letras.length; i++){
            letras[i] = operation.charAt(i);
        }

        for(int i = 0; i<letras.length; i++){
            char signo = letras[i];
            if(signo == '(' || signo == '[' || signo == '{'){
                pilaChar.push(signo);
            }
        }

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