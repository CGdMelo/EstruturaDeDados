import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        System.out.println("Foi criada uma lista vazia");
        char opcao;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                   Selecione uma opcao:
                   a: verifica se a lista esta vazia
                   b: obter tamanho da lista
                   c: obter elemento de um indice
                   d: modifica elemento de um indice
                   e: inserir elemento em um indice
                   f: remover elemento de um indice
                   g: exibir lista
                   x: encerrar""");
            opcao = sc.next().charAt(0);
            //scaneia primeiro char
            switch (opcao) {
                case 'a':
                    if (lista.vazia()) {
                        System.out.println("A lista esta vazia");
                    } else System.out.println("A lista nao esta vazia");
                    break;
                    case 'b':
                        System.out.println("Tamanho atual da lista: " + lista.getTamanho());
                        break;
                    case 'c':
                        System.out.println("insira o indice: ");
                        int pos = sc.nextInt();
                        System.out.println("Conteudo na posicao " + ": " + lista.retornaElemento(pos));
                    case 'd':
                        System.out.println("Insira elemento que deseja adicionar: ");
                        int novo = sc.nextInt();
                        System.out.println("Insira posicao onde deseja inserir-lo: ");
                        pos = sc.nextInt();
                        lista.alteraElemento(novo, pos);
                        break;
                    case 'e':
                        System.out.println("Insira elemento que deseja adicionar: ");
                        int valor = sc.nextInt();
                        System.out.println("Insira posicao onde deseja inserir-lo: ");
                        pos = sc.nextInt();
                        lista.insere(pos, valor);
                        break;
                    case 'f':
                        System.out.println("Insira posicao que deseja remover: ");
                        pos = sc.nextInt();
                        lista.remove(pos);
                        break;
                    case 'g':
                        lista.exibir();
                        break;
            }
        } while (opcao != 'x');
    }
}