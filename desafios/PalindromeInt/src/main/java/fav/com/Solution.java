package fav.com;


import java.util.Arrays;

public class Solution {
    /*
Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    } */
    public boolean isPalindrome(int x) {
        //Hago un array de string con los numeros ingresado
        String[] arr = String.valueOf(x).split("");
        int count1 = 0;
        int count2 = arr.length-1;
        //Creo 2 variables una para ver la longitud del array y otra para ir aumentando
        //Con el count2 reviso la lista de atras hacia adelante descontando 1 de este
        //Con el count1 reviso el array con orden normal
        while (count1 <= count2){
            //Si el indice del array ascendente no es igual al descendente entra y retorna falso
            if (!arr[count1].equals(arr[count2])) {
                return false;
            }
            count1++;
            count2--;
        }
        return true;
    }


}
