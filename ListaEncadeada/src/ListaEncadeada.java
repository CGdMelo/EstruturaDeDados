public class ListaEncadeada{
    private No head;
    private int tamanho;
    //lista composta de seu tamanho e de referencia para o No em sua primeira posicao

    //criacao da lista vazia
    public ListaEncadeada() {
        head = null;
        tamanho = 0;
    }

    //verifica se a lista esta vazia
    public boolean vazia() {
        if (tamanho == 0) {
            return true;
        } else return false;
    }

    //retorna o tamanho da lista
    public int getTamanho(){
        return tamanho;
    }

    //obtem o elemento de posicao requisitada
    public int retornaElemento(int pos) {
        No aux = head;
        int cont = 1;
        if (vazia()) return -1; // Consulta falhou
        if ((pos < 1) || (pos > tamanho))
            return -1; // Posicao invalida
        while (cont < pos){
            aux = aux.getProx();
            cont++;
        }
        return aux.getConteudo();
    }

    //altera o elemento na posicao inserida
    public void alteraElemento(int novo, int pos) {
        No aux = head;
        int cont = 1;
        if (vazia()) return; //Consulta falhou
        if ((pos < 1) || (pos > tamanho))
            return; // Posicao invalida
        //percorre lista ate pos-1
        while (cont < pos-1){
            aux = aux.getProx();
            cont++;
        }
        //muda o conteudo do no que aux aponta
        aux.getProx().setConteudo(novo);
    }

    //insere no inicio da lista
    private void insereInicio(int valor) {
        No novoNo = new No();
    // Insere novo elemento na cabeca da lista
        novoNo.setConteudo(valor);
        novoNo.setProx(head);
        head = novoNo;
        tamanho++;
    }

    //insere no meio da lista
    public void insereMeio(int valor, int pos) {
        int cont = 1;
        No novoNo = new No();
        novoNo.setConteudo(valor);
         // Localiza a pos. onde será inserido o novo nó
        No aux = head;
        while ((cont < pos-1) && (aux != null)){
            aux = aux.getProx();
            cont++;
        }
        if (aux == null) return;
        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);
        tamanho++;
    }

    //insere no fim da lista
    public void insereFim(int valor) {
        No novoNo = new No();
        novoNo.setConteudo(valor);
        // Procura o final da lista
        No aux = head;
        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        novoNo.setProx(null);
        aux.setProx(novoNo);
        tamanho++;
    }

    //define qual metodo sera usado de acordo com a posicao dada
    void insere(int pos, int dado) {
        if ((vazia()) && (pos != 1)) return;
        if (pos == 1){ // insercao no inicio da lista
            insereInicio(dado);
        }
        else if (pos == tamanho+1){ // inserção no fim
            insereFim(dado);
        }
        else{ // inserção no meio da lista
            insereMeio(pos, dado);
        }
    }

    //remove elemento no inicio
    private void removeInicio(){
        //declara no auxiliar e faz a cabeca da lista apontar para o proximo no
        No n = head;
        head = n.getProx();
        tamanho--;
    }

    //remove elemento no meio da lista
    private void removeMeio(int pos){
        No atual, anterior = null;
        int cont = 1;
        atual = head;
        while((cont < pos) && (atual != null)){
            anterior = atual;
            atual = atual.getProx();
            cont++;
        }
        if (atual == null) return;
        anterior.setProx(atual.getProx());
        tamanho--;
    }

    //define qual metodo de remocao e utilizado de acordo com a posicao requisitada
    public void remove(int pos) {
        if (vazia()) return; // Lista vazia
        // remoção do elemento da cabeça da lista
        if (pos == 1){
            removeInicio();
        }
        // remoção em outro lugar da lista
        else{
            removeMeio(pos);
        }
    }

    //exibição de todos os elementos da lista
    public void exibir(){
        if (vazia()) return;
        int cont = 1;
        No aux = head;
        while (cont <= tamanho){
            System.out.println(aux.getConteudo());
            aux = aux.getProx();
            cont++;
        }
    }
}
