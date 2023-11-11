public class SegmentoReta {
    private Ponto2D pontoInicial;
    private Ponto2D pontoFinal;
    private float dimensao;

    public SegmentoReta(Ponto2D pontoInicial, Ponto2D pontoFinal) {
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
        this.dimensao = calculaDimensao();
    }

    public float calculaDimensao() {
        return pontoInicial.distancia(pontoFinal);
    }

    public void imprimeSegmentoReta() {
        System.out.println("O segmento de reta inicia no ponto (" + pontoInicial.getX() + ", " + pontoInicial.getY() + ") e finaliza no ponto (" + pontoFinal.getX() + ", " + pontoFinal.getY() + ") com dimensão " + dimensao);
    }
}