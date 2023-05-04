import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grafo {
    int tamanho;
    int[][] matriz;
    LinkedList<Integer>[] lista;
    private int[] pai;
    private int[] cor; // branco = 0, cinza = 1, preto = 2

    public Grafo(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int n = Integer.parseInt(reader.readLine());
        this.tamanho = n;
        this.matriz = new int[n][n];
        this.lista = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            this.lista[i] = new LinkedList<>();
        }
        this.pai = new int[n];
        this.cor = new int[n];
        for (int i = 0; i < n; i++) {
            this.pai[i] = -1;
            this.cor[i] = 0;
        }

        int l = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] numeros = line.split("\t");
            int c = 0;
            for (int i = 0; i < this.tamanho; i++) {
                int valor = Integer.parseInt(numeros[i]);
                this.matriz[l][c] = valor;
                if (valor > 0) {
                    this.lista[l].add(c);
                }
                c++;
            }
            l++;
        }
        reader.close();
    }

    public void caminho(int s, int t) {
        if (s == t) {
            System.out.println(s);
            return;
        }
        cor[s] = 1;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(s);

        while (!Q.isEmpty()) {

            int u = Q.poll();
            for (int v : lista[u]) {
                if (cor[v] == 0) {
                    cor[v] = 1;
                    pai[v] = u;
                    Q.add(v);
                }
            }
            cor[u] = 2;
        }
        if (pai[t] == -1) {
            System.out.println("Não há caminho entre os vértices.");
            return;
        }
        List<Integer> caminho = new ArrayList<Integer>();
        caminho.add(t);
        while (t != s) {
            if (pai[t] == -1) {
                System.out.println("Não há caminho entre os vértices.");
                return;
            }
            t = pai[t];
            caminho.add(t);
        }

        Collections.reverse(caminho);
        for (Integer integer : caminho) {
            System.out.print(integer + " ");
        }
    }

    public void dfs() {
        Arrays.fill(this.cor, 0);
        Arrays.fill(this.pai, -1);

        Stack<Integer> S = new Stack<Integer>();
        for (int u = 0; u < this.tamanho; u++) {
            if (this.cor[u] == 0) {
                S.push(u);
                while (!S.isEmpty()) {
                    int v = S.peek();
                    if (this.cor[v] == 0) {
                        this.cor[v] = 1;
                        for (int w : this.lista[v]) {
                            if (this.cor[w] == 0) {
                                this.pai[w] = v;
                                S.push(w);
                            }
                        }
                    } else {
                        S.pop();
                        this.cor[v] = 2;
                        System.out.print(v + " ");
                    }
                }
            }
        }
    }


}