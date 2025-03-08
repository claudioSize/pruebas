package fav.com;

public class Main {
    public static void main(String[] args) {
        int[] lista = {1,2,3,4,5,6};
        int tarjeta = 10;

        Solution solution = new Solution();

        for (int listas : solution.twoSums(tarjeta,lista)){

            System.out.println(listas);

        }
    }
}