import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        ListaEncadeada lista = new ListaEncadeada();

        String nomeArquivo = "ct_2000000.txt";

        try {
            // Cria um FileReader para abrir o arquivo
            FileReader fileReader = new FileReader(nomeArquivo);

            // Cria um BufferedReader para leitura eficiente
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // Loop para ler o arquivo linha por linha
            lista.adiciona(bufferedReader.readLine());

            // Fecha o BufferedReader e o FileReader após a leitura
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Scanner in = new Scanner(System.in);
    

        // System.out.println(lista.toString());
        // System.out.println(lista.getContFusoes());
        lista.fusao();
        
        System.out.println(lista.getContFusoes());
    }   
    
}
