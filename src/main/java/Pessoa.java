public class Pessoa {
    private String nome;

    public Pessoa(){

    }
    public Pessoa (String nome){
        setNome(nome);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if(nome == null){
            throw new IllegalArgumentException("Nome invalido!");
        }

        this.nome = nome;
    }
}
