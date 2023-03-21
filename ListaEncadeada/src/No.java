public class No {
    private int conteudo;
    private No prox;
    //no composto de seu conteudo e referencia para o proximo no

    public No() {
        prox = null;
    }

    //metodos get e set

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int i) {
        conteudo = i;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No n) {
        prox = n;
    }
}
