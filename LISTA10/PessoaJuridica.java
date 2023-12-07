public class PessoaJuridica extends Contato {
    private String cnpj;
    private double faturamento;

    public PessoaJuridica(String nome, String cnpj, String endereco, double faturamento, String telefone, String email) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.faturamento = faturamento;
    }

    @Override
    public String getIdentificador() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Jurídica: " + nome + "\nCNPJ: " + cnpj + "\nEndereço: " + endereco +
               "\nFaturamento: R$ " + faturamento + "\nTelefone: " + telefone +
               "\nE-mail: " + email + "\n";
    }
}