public class PilhaVetor {
    private int conteudo[];
    private int topo;
    private int tamMax;

    //construtor
    public PilhaVetor(int tam) {
        tamMax = tam;
        conteudo = new int[tamMax];
        topo = -1;
    }

    //insere elemento no topo da pilha
    public void push(int valor) {
        if (cheia())
            return;
        topo++;
        conteudo[topo] = valor;
    }

    //remove elemento no topo da pilha e retorna o valor
    public int pop() {
        if (vazia())
            return -1;
        int valor = conteudo[topo];
        topo--;
        return valor;
    }

    //retorna o topo da pilha
    public int top() {
        if (vazia())
            return -1;
        return conteudo[topo];
    }

    //verifica se a pilha esta vazia
    public boolean vazia(){
        if (topo == -1)
            return true;
        else
            return false;
    }

    //verifica se a pilha esta cheia
    public boolean cheia(){
        if (topo == (tamMax-1))
            return true;
        else
            return false;
    }

    //retorna o tamanho
    public int tamanho(){
        return topo+1;
    }

    //metodos adicionais para o main
    //exibe a lista
    public void exibir() {
        if (vazia()) {
            return;
        }
        for(int i=topo;i>=0;i--) {
            System.out.println(conteudo[i]);
        }
    }


    //preenche vetor com numeros aleatorios
    public void pilhaRandom(int qtd) {
        if (qtd <= 0 || qtd > tamMax) {
            return;
        }
        for(int i=0;i<qtd;i++) {
            conteudo[i] = (int) (Math.random() * 100);
        }
        topo = qtd - 1;
    }

}
