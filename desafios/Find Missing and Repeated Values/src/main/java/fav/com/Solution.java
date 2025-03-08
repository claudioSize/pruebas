package fav.com;

import java.util.*;

public class Solution {

    public List<Integer> lista(int[][] list){

        List<Integer> response = new ArrayList<>();
        List<Integer> listSort = new ArrayList<>();
        Set<Integer> listSet = new HashSet<>();

        for (int i = 0; i < list.length; i++) {
            int[] arr = list[i];
            for (int j = 0; j < arr.length; j++) {
                listSort.add(arr[j]);
            }
        }
        Collections.sort(listSort);

        int count = -1;

        for (int i = 1; i < listSort.size(); i++) {
            count++;
            if ( listSort.get(count) == listSort.get(i)) {
                response.add(listSort.get(i));
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

        response.add(count);
        return response;
    }




}
