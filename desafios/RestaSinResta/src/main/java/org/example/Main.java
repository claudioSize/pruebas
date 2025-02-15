package org.example;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        System.out.println(main.division(8,5));

    }
    public int restaSinresta(int num, int resta){

        int resto = 0;

        while(num > resta){
            resta++;
            resto++;
        }
        return resto;
    }
    public int multiplicar(int num1, int num2){

        int total = 0;

        for (int i = 0; i < num1; i++) {

            total += num2;

        }
        return total;
    }
    public int division(int num1, int num2){

        int total = 0;

        while (num1 >= num2){
            num1-= num2;
            total++;
        }

        return total;

    }
}