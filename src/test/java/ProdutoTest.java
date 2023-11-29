import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveDebitarEstoque(){
        Produto produto = new Produto("Caneta", 1000, 5.00f, 100, 2000);
        produto.debitarEstoque(10);

        assertEquals(990, produto.getQuantidadeEstoque());
    }

    @Test
    void deveDarEstoqueInsuficiente(){
        Produto produto = new Produto("Caneta", 1000, 5.00f, 100, 2000);
        try{
            produto.debitarEstoque(1001);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Quantidade insuficiente!", e.getMessage());
        }
    }

    @Test
    void deveCreditarEstoque(){
        Produto produto = new Produto("Caneta", 1000, 5.00f, 100, 2000);
        produto.creditarEstoque(1000);

        assertEquals(2000, produto.getQuantidadeEstoque());
    }

    @Test
    void deveDarEstoqueExcedido(){
        Produto produto = new Produto("Caneta", 100, 5.00f, 100, 2000);

        try{
            produto.creditarEstoque(2000);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Quantidade máxima atingida!", e.getMessage());
        }
    }

    @Test
    void deveVerificarEstoqueBaixo(){
        Produto produto = new Produto("Caneta", 99, 5.00f, 100, 2000);
        assertEquals(true, produto.verificarEstoqueBaixo());
    }

    @Test
    void deveCalcularValor(){
        Produto produto = new Produto("Caneta", 1000, 5.00f, 100, 2000);

        assertEquals(50, produto.calcularValorVenda(10));
    }

    @Test
    void deVerificarLista(){
        Produto produto = new Produto("Caneta", 99, 5.00f, 100, 2000);
        produto.verificarEstoqueBaixo();

        assertEquals(1, produto.exibirHistorico().size());
    }
}