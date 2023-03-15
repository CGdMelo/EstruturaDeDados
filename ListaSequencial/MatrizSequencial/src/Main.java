import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o tamanho desejado do vetor que incluirá a lista: ");
        int tamanho = in.nextInt();
        ListaArray lista = new ListaArray(tamanho);
        System.out.println("Foi criada uma lista vazia em um vetor de tamanho " + tamanho);
        char opcao;
        do {
            System.out.println("""
                    Selecione uma opcao:
                    a: verifica se a lista esta vazia
                    b: verifica se a lista esta cheia
                    c: obter tamanho da lista
                    d: obter elemento de um indice
                    e: obter posicao de um indice
                    f: inserir elemento em um indice
                    g: remover elemento de um indice
                    h: preencher vetor com numeros aleatorios
                    i: exibir lista
                    x: encerrar""");
            opcao = in.next().charAt(0);
            //scaneia primeiro char
            switch (opcao) {
                case 'a':
                    if (lista.vazia()) {
                        System.out.println("A lista esta vazia");
                    } else System.out.println("A lista nao esta vazia");
                    break;
                case 'b':
                    if (lista.cheia()) {
                        System.out.println("A lista esta cheia");
                    } else System.out.println("A lista nao esta cheia");
                    break;
                case 'c':
                    System.out.println("Tamanho atual da lista: " + lista.getTamanho());
                    break;
                case 'd':
                    int pos = in.nextInt();
                    System.out.println("Elemento do indice " + pos + ": " + lista.getElemento(pos));
                    break;
                case 'e':
                    int id = in.nextInt();
                    System.out.println("Posicao do elemento " + id + ": " + lista.getElemento(id));
                    break;
                case 'f':
                    System.out.println("Insira elemento que deseja adicionar: ");
                    id = in.nextInt();
                    System.out.println("Insira posicao onde deseja inserir-lo: ");
                    pos = in.nextInt();
                    lista.inserirElemento(pos, id);
                    break;
                case 'g':
                    System.out.println("Insira indice de elemento que deseja remover: ");
                    id = in.nextInt();
                    lista.removerElemento(id);
                    break;
                case 'h':
                    System.out.println("Insira quantos elementos aleatorios deseja inserir: ");
                    int qtd = in.nextInt();
                    lista.listaRandom(qtd);
                    break;
                case 'i':
                    lista.exibir();
                    break;
            }
        } while (opcao != 'x');
    }
}