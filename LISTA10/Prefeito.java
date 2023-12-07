public class Prefeito extends Politico {
    private String cidadeGovernada;

    public Prefeito(String nome, long id, Data nasc, String siglaPartido, int numeroPartido, String cidadeGovernada) {
        super(nome, id, nasc, siglaPartido, numeroPartido);
        this.cidadeGovernada = cidadeGovernada;
    }

    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += "\nCidade Governada: " + cidadeGovernada;
        return resultado;
    }
}