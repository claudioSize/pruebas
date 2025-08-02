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
    //Nueva solucion 
     public int[] repeatNumber(int[][] list) {
         int missNum = 1;
         int repetNum = 1;
         List<Integer> list1 = new ArrayList<>();
         Set<Integer> listSet = new HashSet<>();

         for (int i = 0; i < list.length; i++) {
             for (int j = 0; j < list[i].length; j++) {
                 list1.add(list[i][j]);
                 listSet.add(list[i][j]);
             }
         }
         for (int i = 1; i < list1.size(); i++) {
             if (list1.get(i-1).equals(list1.get(i))) {
                 repetNum = list1.get(i);
             }
         }
         int count = 1;
         List<Integer> set = new ArrayList<>(listSet);
         for (int i = 0; i < set.size(); i++) {
             if (set.get(i) == count) {
                 count++;
             }else {
                 missNum = count;
                 return new int[]{repetNum, missNum};
             }
         }
         missNum = count;
         return new int[]{repetNum, missNum};
     }


}

