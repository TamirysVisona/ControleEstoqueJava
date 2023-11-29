import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    @Test
    void deveRealizarVenda(){
        Produto produto = new Produto("Caneta", 100, 5.00f, 100, 2000);
        Cliente cliente = new Cliente("Maria", "00001");

        Venda venda = new Venda("29/11/2023",  cliente, produto, 10);

        produto.vender(venda);

        assertEquals(3, produto.exibirHistorico().size());
    }

    @Test
    void deveNegarVenda(){
        Produto produto = new Produto("Caneta", 100, 5.00f, 100, 2000);
        Cliente cliente = new Cliente("Maria", "00001");

        Venda venda = new Venda("29/11/2023",  cliente, produto, 101);

        try {
            produto.vender(venda);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("Venda não realizada!", e.getMessage());
        }
    }

}