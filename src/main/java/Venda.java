public class Venda extends Transacao {
    private Cliente cliente;
    private Produto produto;
    public Venda (String dataVenda, Cliente cliente, Produto produto, int qtdeVendida){
        setDataTransacao(dataVenda);
        this.cliente = cliente;
        this.produto = produto;
        setQuantidade(qtdeVendida);
    }

    public boolean vender(Produto produto, int qtdeVendida){
        if(produto.verificarEstoqueInsuficiente(qtdeVendida)){
            return false;
        }
        produto.debitarEstoque(qtdeVendida);
        produto.calcularValorVenda(qtdeVendida);
        produto.verificarEstoqueBaixo();
        return true;
    }

    public Produto getProduto(){
        return this.produto;
    }
}
