import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Escolha entre:
                1-Pilha como vetor
                2-Pilha como lista encadeada""");
        int tipo = in.nextInt();
        switch (tipo) {
            case 1:
                System.out.println("Digite o tamanho desejado do vetor que incluirá a pilha: ");
                int tamanho = in.nextInt();
                PilhaVetor pilhaVetor = new PilhaVetor(tamanho);
                System.out.println("Foi criada uma pilha vazia em um vetor de tamanho " + tamanho);
                char opcao;
                do {
                    System.out.println("""
                    Selecione uma opcao:
                    a: verifica se a pilha esta vazia
                    b: inserir elemento no topo
                    c: remover elemento do topo e retornar valor
                    d: ler o topo da pilha
                    e: retorna tamanho da pilha
                    f: preencher vetor com numeros aleatorios
                    g: exibir pilha
                    x: encerrar""");
                    opcao = in.next().charAt(0);
                    //scaneia primeiro char
                    switch (opcao) {
                        case 'a' -> {
                            if (pilhaVetor.vazia()) {
                                System.out.println("A pilha esta vazia");
                            } else System.out.println("A pilha nao esta vazia");
                        }
                        case 'b' -> {
                            System.out.println("Insira elemento que deseja adicionar: ");
                            int id = in.nextInt();
                            pilhaVetor.push(id);
                        }
                        case 'c' -> System.out.println("Valor removido: " + pilhaVetor.pop());
                        case 'd' -> System.out.println("Topo da pilha: " + pilhaVetor.top());
                        case 'e' -> System.out.println("Tamanho atual da pilha: " + pilhaVetor.tamanho());
                        case 'f' -> {
                            System.out.println("Insira quantos elementos aleatorios deseja inserir: ");
                            int qtd = in.nextInt();
                            pilhaVetor.pilhaRandom(qtd);
                        }
                        case 'g' -> pilhaVetor.exibir();
                    }
                } while (opcao != 'x');
                break;
            case 2:
                PilhaEncadeada pilhaEncadeada = new PilhaEncadeada();
                System.out.println("Foi criada uma pilha vazia");
                do {
                    System.out.println("""
                   Selecione uma opcao:
                    a: verifica se a pilha esta vazia
                    b: inserir elemento no topo
                    c: remover elemento do topo e retornar valor
                    d: ler o topo da pilha
                    e: retorna tamanho da pilha
                    f: exibir pilha
                    x: encerrar""");
                    opcao = in.next().charAt(0);
                    //scaneia primeiro char
                    switch (opcao) {
                        case 'a' -> {
                            if (pilhaEncadeada.vazia()) {
                                System.out.println("A pilha esta vazia");
                            } else System.out.println("A pilha nao esta vazia");
                        }
                        case 'b' -> {
                            System.out.println("Insira elemento que deseja adicionar: ");
                            int valor = in.nextInt();
                            pilhaEncadeada.push(valor);
                        }
                        case 'c' -> System.out.println("Valor removido: " + pilhaEncadeada.pop());
                        case 'd' -> System.out.println("Valor no topo da pilha: " + pilhaEncadeada.top());
                        case 'e' -> System.out.println("Tamanho atual da pilha: " + pilhaEncadeada.getTamanho());
                        case 'f' -> pilhaEncadeada.exibir();
                    }
                } while (opcao != 'x');
        }
    }
}