package fav.com;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        * Buscar los numeros faltantes y repetidos en una matriz que va del 1 al 9
        *
        *
        *
        *
        *
        *
        *
        * */
        Solution solution = new Solution();

        int[][] matriz = {
                {1,2,3},
                {4,5, 6},
                {6,7, 9}
        };

        System.out.println(solution.lista(matriz));
    }
}