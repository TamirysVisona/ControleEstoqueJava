public class Fornecedor extends Pessoa {
    private String cnpj;

    public Fornecedor(String nome, String cnpj){
        setNome(nome);
        setCnpj(cnpj);
    }

    public String getCnpj(){
        return this.cnpj;
    }

    public void setCnpj(String cnpj){
        if(cnpj == null){
            throw new IllegalArgumentException("CNPJ invalido!");
        }

        this.cnpj = cnpj;
    }
}
