public class PilhaEncadeada{
    private No topo;
    private int tamanho;

    //construtor
    public PilhaEncadeada(){
        topo = null;
        tamanho = 0;
    }

    //verifica se a pilha esta vazia
    public boolean vazia () {
        if (tamanho == 0)
            return true;
        else
            return false;
    }

    //retorna tamanho da pilha
    public int getTamanho() {
        return tamanho;
    }

    //retorna o conteudo do topo da pilha
    public int top(){
        if (vazia()){
            return -1;
        }
        return topo.getConteudo();
    }

    //insere elemento no topo da pilha
    public void push(int valor) {
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setProx(topo);
        topo = novoNo;
        tamanho++;
    }

    //remove elemento do topo da pilha e retorna o valor
    public int pop () {
        if (vazia())
            return -1; // pilha vazia
        No p = topo;
        int valor = p.getConteudo();
        topo = p.getProx();
        tamanho--;
        return valor;
    }

    //metodo adicional para o main
    //exibe a pilha
    public void exibir(){
        if (vazia()) return;
        int cont = 1;
        No aux = topo;
        while (cont <= tamanho){
            System.out.println(aux.getConteudo());
            aux = aux.getProx();
            cont++;
        }
    }
}