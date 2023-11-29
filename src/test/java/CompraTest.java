import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompraTest {

    @Test
    void deveRealizarCompra(){
        Produto produto = new Produto("Caneta", 100, 5.00f, 100, 2000);
        Fornecedor fornecedor = new Fornecedor("Papelaria", "00001");

        Compra compra = new Compra("29/11/2023", produto, fornecedor,1900, 5.00f);

        produto.comprar(compra);

        assertEquals(1, produto.exibirHistorico().size());
    }

    @Test
    void deveNegarCompra(){
        Produto produto = new Produto("Caneta", 100, 5.00f, 100, 2000);
        Fornecedor fornecedor = new Fornecedor("Papelaria", "00001");

        Compra compra = new Compra("29/11/2023", produto, fornecedor, 2000, 5.00f);
        try{
            produto.comprar(compra);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Compra não realizada", e.getMessage());
        }
    }
}