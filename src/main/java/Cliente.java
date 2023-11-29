public class Cliente extends Pessoa {
    private String cpf;

    public Cliente(String nome, String cpf){
        setNome(nome);
        setCpf(cpf);
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null){
            throw new IllegalArgumentException("CPF invalido!");
        }
        this.cpf = cpf;
    }
}
