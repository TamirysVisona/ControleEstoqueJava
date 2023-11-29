public class Transacao {
    private String dataTransacao;
    private int quantidade;

    public Transacao(){
    }

    public Transacao(String dataTransacao, Produto produto, int qtde){
        this.dataTransacao = dataTransacao;
        this.quantidade = qtde;
    }
    public String getDataTransacao() {
        return this.dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
