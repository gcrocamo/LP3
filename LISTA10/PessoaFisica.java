public class PessoaFisica extends Contato {
    private String cpf;
    private Data aniversario;

    public PessoaFisica(String nome, String cpf, String endereco, Data aniversario, String telefone, String email) {
        super(nome, endereco, telefone, email);
        this.cpf = cpf;
        this.aniversario = aniversario;
    }

    @Override
    public String getIdentificador() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Pessoa Física: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco +
               "\nAniversário: " + aniversario.toStringLong() + "\nTelefone: " + telefone +
               "\nE-mail: " + email + "\n";
    }
}