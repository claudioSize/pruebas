import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SumaParesImpares {
    public static void main(String[] args) {

        /*Se desea halla la suma de manera independiende de los numeros pares e impares
           comprendidos entre el 1 y el 100
       */

        int totalPar = 0;
        int totalImpar = 0;
        for (int i = 0; i <= 100 ; i++){

            if (i % 2 == 0){
                totalPar += i;
            }else {
                totalImpar += i;
            }

        }

        System.out.println("La suma de par es " + totalPar + " La suma de impar es " + totalImpar);

    }
}
