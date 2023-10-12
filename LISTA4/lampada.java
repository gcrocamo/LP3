//teste

public class Lampada {
    private double faturamento;
    private double lucro;
    private int estoque;

    public void qtdEstoque(int quantidade) {
        estoque = quantidade;
    }

    public void qtdFaturada(double valor) {
        faturamento = valor * estoque;
    }

    public void qtdLucro() {
        lucro = faturamento * 0.7;
    }

    public void mostraDados() {
        System.out.println("Estoque: " + estoque);
        System.out.println("Faturamento: " + faturamento);
        System.out.println("Lucro: " + lucro);
    }

    public static void main(String[] args) {
        Lampada lampada = new Lampada();
        lampada.qtdEstoque(100);
        lampada.qtdFaturada(10.0);
        lampada.qtdLucro();
        lampada.mostraDados();
    }
}