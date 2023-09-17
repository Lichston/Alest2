import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ListaEncadeada lista = new ListaEncadeada();
        lista.adiciona("DNANDANDANDANADNDDDAN");
        System.out.println(lista.toString());
        lista.fusao();
        System.out.println(lista.toString());
        System.out.println(lista.getContFusoes());

    }
    
}
