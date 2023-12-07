public abstract class Contato {
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected String email;

    public Contato(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public abstract String getIdentificador();
}