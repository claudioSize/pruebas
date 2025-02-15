package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Se pide recibir un string con parentesis y ver si se cierra o no ejemplo ():true , [}:false

        Main m = new Main();
        System.out.println(m.isValid("{}()(())"));

    }
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            // Reemplaza todas las ocurrencias de "()" en la cadena 's' con una cadena vacía
            s = s.replace("()", "");
            // Reemplaza todas las ocurrencias de "[]" en la cadena 's' con una cadena vacía
            s = s.replace("[]", "");
            // Reemplaza todas las ocurrencias de "{}" en la cadena 's' con una cadena vacía
            s = s.replace("{}", "");
        }
             // Devuelve true si la cadena 's' está vacía, de lo contrario devuelve false
        return s.isEmpty();

    }
}