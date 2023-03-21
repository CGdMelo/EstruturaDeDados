public class ListaArray {
    private int conteudo[];
    //vetor que conterá a lista
    private int tamAtual;
    //tamanho atual da lista
    private int tamMax;
    //tamanho maximo do vetor

    //construtor que inicializa lista recebendo tamanho maximo do vetor
    public ListaArray(int tam) {
        tamMax = tam;
        tamAtual = 0;
        conteudo = new int[tamMax];
    }

    //metodos:
    //verifica lista vazia
    public boolean vazia() {
        if (tamAtual == 0) return true;
        else return false;
    }

    //verifica lista cheia
    public boolean cheia() {
        if (tamAtual == tamMax) return true;
        else return false;
    }

    public int getTamanho() {
        return tamAtual;
    }

    //obtém elemento de um indice requisitado
    public int getElemento(int indice) {
        int elemento;
        if ((indice > tamAtual) || (indice) <= 0)
            return -1;
        elemento = conteudo[indice - 1];
        return elemento;
    }

    //obtem posicao de elemento requisitado
    public int getPosicao(int elemento) {
        for (int i = 0; i < tamAtual; i++) {
            if (conteudo[i] == elemento) {
                return (i + 1);
            }
        }
        return -1;
    }

    //insere elemento em indice da lista
    public void inserirElemento(int indice, int elemento) {
        if (cheia() || (indice > tamAtual + 1) || (indice <= 0)) {
            return;
        }
        for (int i = tamAtual; i >= indice; i--) {
            conteudo[i] = conteudo[i - 1];
        }
        conteudo[indice - 1] = elemento;
        tamAtual++;
    }

    //remove elemento em indice da lista
    public void removerElemento(int indice) {
        if ((indice > tamAtual) || (indice <= 0)) {
            return;
        }
        for (int i = indice - 1; i < tamAtual - 1;i++) {
            conteudo[i] = conteudo[i + 1];
        }
        tamAtual--;
    }

    //metodos adicionais para o main
    //exibe a lista
    public void exibir() {
        if (vazia()) {
            return;
        }
        for(int i=0;i<tamAtual;i++) {
            System.out.println(conteudo[i]);
        }
    }

    //preenche vetor com numeros aleatorios
    public void listaRandom(int qtd) {
        if (qtd <= 0 || qtd > tamMax) {
            return;
        }
        for(int i=0;i<qtd;i++) {
            conteudo[i] = (int) (Math.random() * 100);
        }
        tamAtual = qtd;
    }
}
