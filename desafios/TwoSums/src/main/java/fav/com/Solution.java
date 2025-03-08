package fav.com;

public class Solution {

    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
      You may assume that each input would have exactly one solution, and you may not use the same element twice.
      {1,2,3,4,5,6};
      You can return the answer in any order.*/

    public int[] twoSums(int tarjet, int[] list){

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < list.length-1; i++) {
            for (int j = 1+i; j < list.length; j++) {
                int sum = list[i] + list[j];
                if (sum == tarjet) {
                    num1 = i;
                    num2 = j;
                    break;
                }
            }
        }
        int[] elements = {num1,num2};
        return elements;
    }

}
