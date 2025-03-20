package fav.com;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        //Array tipo lifo last in firt out
        Stack<Character> stack = new Stack<>();

        //Se convierte el string en un array de char
        for (char x : s.toCharArray()) {
            //Cuando un chart coincide con esta se inserta en el stack y como es un else if no sigue evaluando para abajo
            if (x == '(') {
                //Si el parentesis corresponde se inserta el parentesis contrario
                stack.push(')');
            } else if (x == '{') {
                stack.push('}');
            } else if (x == '[') {
                stack.push(']');
                //Aqui esta lo importante cuando se hace .pop en un stack este indice queda en memoria  y se puede usar ya sea como
                //Variable o como aqui comparamos si el .pop coincide con el x de la iteracion siguiente si no coincide se retorna falso
                //ahora si son igual sigue pero si los 2 indices seguidos son ejemplo "(" "(" ingresa al stack ")"")" y coincide el x dos veces es true
                //Asi si alguno no es igual retorna falso solo retornara falso si por ejemplo "(" "[" se inserta "]"")" y el x es x1 = "]" x2 = "}" false
            } else if (stack.isEmpty() || stack.pop() != x) {

                return false;
            }

        }


        return stack.isEmpty();

    }
}
