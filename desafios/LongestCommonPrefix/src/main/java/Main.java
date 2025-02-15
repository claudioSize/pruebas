import java.util.ArrayList;

public class Main {
    public void hola() {
        String[] listaNombres = {"flower","flow","flight"};

        ArrayList<String[]> arrayLista = new ArrayList<>();

        ArrayList<String> returne = new ArrayList<>();

        for (int i = 0; i < listaNombres.length ; i++){

            arrayLista.add(listaNombres[i].split(""));

        }
        for (int i = 0; i < arrayLista.size() ; i++){
            for (int j = i + 1 ; j < arrayLista.size(); j++){
                if (i != j){
                    String[] array = arrayLista.get(0);
                    String[] array2 = arrayLista.get(j);
                    for (int i1 = 0; i1 < array.length; i1++){
                        if (i1 < array2.length){
                            if (array[i1].equals(array2[i1])){
                                returne.add(array[i1]);
                            } else if (!array[i1].equals(array2[i1])){
                                break;
                            }
                        }
                    }
                }

            }
        }
        String prefix = String.join("",returne);
        System.out.println(prefix);

    }
}
