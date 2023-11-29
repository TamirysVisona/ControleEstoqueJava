public class Compra extends Transacao {
    private float precoUnit;
    private Produto produto;
    private Fornecedor fornecedor;
    public Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, float precoUnit){
        setDataTransacao(dataCompra);
        this.precoUnit = precoUnit;
        this.produto = produto;
        this.fornecedor = fornecedor;
        setQuantidade(qtdeCompra);
    }

    public boolean comprar(Produto produto, int qtdeCompra){
        if(produto.verificarEstoqueExcedente(qtdeCompra)){
            return false;
        }
        return true;
    }

    public Produto getProduto(){
        return this.produto;
    }
}
