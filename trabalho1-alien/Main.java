import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int caso = 1;

        File file = new File("casos-testes");
        File[] arquivos = file.listFiles();

        for(File f: arquivos){

            ListaEncadeada lista = new ListaEncadeada();
            String nomeArquivo = f.getAbsolutePath();

            try {

                FileReader fileReader = new FileReader(nomeArquivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);               
                lista.adiciona(bufferedReader.readLine());
                bufferedReader.close();
                fileReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Scanner in = new Scanner(System.in);
            System.out.println("CASO " + caso);
            lista.fusao();
            System.out.println(lista.toString());
            System.out.println(lista.getContFusoes());
            System.out.println(lista.getTempo());
            System.out.println("-------------------------------------------------------------");

            caso++;

        }

    }   
    
}
