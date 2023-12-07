public class Pessoa {
    private String nome;
    private long id;
    private Data nascimento;

    Pessoa(String n, int i, Data d) {
        nome = n;
        id = i;
        nascimento = d;
    }

    @Override
    public String toString() {
        String resultado;
        resultado = "Nome: " + nome + "\nIdentidade: " + id + "\n";
        if (this.nascimento != null)
            resultado += "Data de Nascimento: " + nascimento.toStringLong();

        return resultado;
    }

    public double calculaEmprestimo() {
        return 1000.0;
    }
}