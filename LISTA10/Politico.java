public class Politico extends Pessoa {
    private String siglaPartido;
    private int numeroPartido;

    public Politico(String nome, long id, Data nasc, String siglaPartido, int numeroPartido) {
        super(nome, id, nasc);
        this.siglaPartido = siglaPartido;
        this.numeroPartido = numeroPartido;
    }

    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += "\nSigla do Partido: " + siglaPartido + "\nNúmero do Partido: " + numeroPartido;
        return resultado;
    }
}