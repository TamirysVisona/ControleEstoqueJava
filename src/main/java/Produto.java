import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private int quantidadeEstoque, estoqueMinimo, estoqueMaximo;
    private float precoUnitario;
    private List<String> historico;

    public Produto(String nome, int qtdeEstoque, float precoUnit, int estoqueMin, int estoqueMax){
        this.nome = nome;
        this.quantidadeEstoque = qtdeEstoque;
        this.estoqueMinimo = estoqueMin;
        this.estoqueMaximo = estoqueMax;
        this.precoUnitario = precoUnit;
        this.historico = new ArrayList<>();
    }

    public void registrarHistorico(String transacao){
        historico.add(transacao);
    }

    public List<String> exibirHistorico(){
        return this.historico;
    }

    public void debitarEstoque(int quantidade){
        if(verificarEstoqueInsuficiente(quantidade)){
            throw new IllegalArgumentException("Quantidade insuficiente!");
        }
        this.quantidadeEstoque = this.quantidadeEstoque - quantidade;
    }

    public void creditarEstoque(int quantidade){
        if(verificarEstoqueExcedente(quantidade)){
            throw new IllegalArgumentException("Quantidade máxima atingida!");
        }
        this.quantidadeEstoque = this.quantidadeEstoque + quantidade;
    }

    public boolean verificarEstoqueBaixo(){
        if(this.quantidadeEstoque < estoqueMinimo){
            registrarHistorico("Estoque baixo");
            return true;
        }
        return false;
    }
    public boolean verificarEstoqueInsuficiente(int quantidade){
        if(this.quantidadeEstoque < quantidade){
            registrarHistorico("Estoque insuficiente");
            return true;
        }
        return false;
    }

    public boolean verificarEstoqueExcedente(int quantidade){
        if((this.quantidadeEstoque + quantidade) > this.estoqueMaximo){
            registrarHistorico("Estoque excedente!");
            return true;
        }
        return false;
    }

    public float calcularValorVenda(int quantidade){
        registrarHistorico("Valor venda " + (this.precoUnitario * quantidade));
        return (this.precoUnitario * quantidade);
    }

    public void vender(Venda venda){
        if(!venda.vender(venda.getProduto(), venda.getQuantidade())){
            throw new IllegalArgumentException("Venda não realizada!");
        }
        registrarHistorico("Venda do produto " + venda.getProduto().nome);
    }

    public void comprar(Compra compra){
        if(!compra.comprar(compra.getProduto(), compra.getQuantidade())){
            throw new IllegalArgumentException("Compra não realizada");
        }
        registrarHistorico("Compra do produto " + compra.getProduto().nome);
    }

    public int getQuantidadeEstoque(){
        return this.quantidadeEstoque;
    }
}
