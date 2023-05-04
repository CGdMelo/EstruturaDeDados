import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o grafo que queira utilizar:" +
                " 1-pcv4.txt" +
                " 2-pcv10.txt" +
                " 3-pcv50.txt" +
                " 4-pcv177.txt");
        int escolha = sc.nextInt();
        Grafo gr = new Grafo("pcv4.txt");
        switch (escolha) {
            case 1 -> gr = new Grafo("pcv4.txt");
            case 2 -> gr = new Grafo("pcv10.txt");
            case 3 -> gr = new Grafo("pcv50.txt");
            case 4 -> gr = new Grafo("pcv177.txt");
            default ->  System.exit(1);
        }
        System.out.println("escolha a operação:" +
                " 1- caminho entre dois vertices" +
                " 2- dfs");
        escolha = sc.nextInt();
        switch(escolha) {
            case 1:
                System.out.println("insira o vertice em qual queira iniciar: ");
                int s = sc.nextInt();
                System.out.println("insira o vertice que queira achar: ");
                int t = sc.nextInt();
                gr.caminho(s, t);
                break;
            case 2:
                gr.dfs();
            default:
                System.exit(1);
        }
    }

    
}