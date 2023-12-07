public class Governador extends Politico {
    private String estadoGovernado;

    public Governador(String nome, long id, Data nasc, String siglaPartido, int numeroPartido, String estadoGovernado) {
        super(nome, id, nasc, siglaPartido, numeroPartido);
        this.estadoGovernado = estadoGovernado;
    }

    @Override
    public String toString() {
        String resultado = super.toString();
        resultado += "\nEstado Governado: " + estadoGovernado;
        return resultado;
    }
}