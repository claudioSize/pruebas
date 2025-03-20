package fav.com;

import java.util.*;

public class SolutionToLeetCode {

    public int[] findMissingAndRepeatedValues(int[][] grid) {


        int number1 = 0;
        List<Integer> listSort = new ArrayList<>();
        Set<Integer> listSet = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            int[] arr = grid[i];
            for (int j = 0; j < arr.length; j++) {
                listSort.add(arr[j]);
            }
        }
        Collections.sort(listSort);

        int count = -1;

        for (int i = 1; i < listSort.size(); i++) {
            count++;
            if ( listSort.get(count) == listSort.get(i)) {
                number1 = listSort.get(i);
            }

        }

        for (int i = 0; i < listSort.size(); i++) {
            listSet.add(listSort.get(i));
        }

        ArrayList<Integer> lista = new ArrayList<>(listSet);
        count = 0;
        for (int i = 1; i < 10; i++) {
            if (!lista.contains(i)) {
                count = i;
                break;
            }else {
                count = lista.get(lista.size()-1)+2;
            }
        }


        int[] response = {number1,count};

        return response;
    }
}
