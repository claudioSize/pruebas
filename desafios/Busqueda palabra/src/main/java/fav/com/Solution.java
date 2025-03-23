package fav.com;

import java.util.Arrays;

public class Solution {
    /*Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
*/


                            //LeetCode        code
        public int strStr(String haystack, String needle) {
            if (haystack.length() < needle.length()) return -1;
            //Creo un una variable para almacenar el largo del string clave
            int nLen = needle.length();
            //Creo una variable para almacenar el largo del array de comparacion
            //Menos el largo de la variable que se busca para no pasarme en el bucle
            int hayPn = haystack.length()-needle.length();
            for (int i = 0; i < hayPn+1; i++) {
                //Creo un sub string de la variable haystack para poder comparar con el string clave
                //voy desde el indice i hasta el largo de la variable por eso voy sumando uno al largo del string
                if (haystack.substring(i,nLen).equals(needle)) {
                    return i;
                }
                nLen++;
            }

            return -1;

        }

}
