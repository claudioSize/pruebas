import java.util.ArrayList;
import java.util.Arrays;
import java.util.MissingResourceException;
import java.util.Scanner;

public class ContadorVocales {
    public static void main(String[] args) {

        //Contar las vocales de una palabra ingresada por consola

        System.out.println("Ingrese la palabra a contar sus vocales");
        Scanner key = new Scanner(System.in);
        ContadorVocales vocal = new ContadorVocales();
        vocal.vocales(key.next());

    }

    public void vocales(String palabra){

        String[] lista = palabra.split("");

        int totalA = 0;
        int totalE = 0;
        int totalI = 0;
        int totalO = 0;
        int totalU = 0;

        for (int i = 0; i < lista.length ; i++){

            if (lista[i].equals("a")){
                totalA++;
            }else if (lista[i].equals("e")){
                totalE++;
            }else if (lista[i].equals("i")){
                totalI++;
            }else if (lista[i].equals("o")){
                totalO++;
            }else if (lista[i].equals("u")){
                totalU++;
            }

        }

        System.out.println(" |a| " + totalA + " |E| " + totalE + " |e| " + totalI +" |I| " + totalO +" |O| " + totalU+" |coU| ");
    }
}
