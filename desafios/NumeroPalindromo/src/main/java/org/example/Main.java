package org.example;

public class Main {
    public static void main(String[] args) {

        //Se ingresar un numero y si es palindromo dar true y si no lo es false

        Main main = new Main();
        main.isPalindrome(12314);

    }
    public boolean isPalindrome(int x){

        //Convierto el entero en string y lo ingreso a un array separando cada numero
        String[] strNum = String.valueOf(x).split("");

        boolean boleano = false;

        if (strNum.length > 1){
            //Recorro el array hasta la mitad de su largo para recorrerlo de atras hacia delante y hacer la comparacion
            for (int i = 0; i < strNum.length/2; i++) {

                //Si no es igual de adelante hacia atras y de atras hacia delante devuelve false
                if (!strNum[i].equals(strNum[strNum.length-i-1])){
                    boleano = false;
                    break;
                }
                boleano = true;
            }
        }else {
            boleano = true;
        }

        return boleano;
    }
}