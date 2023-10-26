public class Lampada {
    private double faturamento;
    private double lucro;
    private int estoque;

    public Lampada(int estoque, double valor) {
        this.estoque = estoque;
        this.faturamento = valor * estoque;
        this.lucro = faturamento * 0.7;
    }

    public void mostraDados() {
        System.out.println("Estoque: " + estoque);
        System.out.println("Faturamento: " + faturamento);
        System.out.println("Lucro: " + lucro);
    }

    public static void main(String[] args) {
        Lampada lampada = new Lampada(100, 10.0);
        lampada.mostraDados();
    }
}
