import java.util.Scanner;

public class Ponto2D {
    private final int x;
    private final int y;

    public Ponto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void imprimirPonto() {
        System.out.println("(" + x + ", " + y + ")");
    }

    public boolean isEixoX() {
        return x == 0;
    }

    public boolean isEixoY() {
        return y == 0;
    }

    public boolean isEixos() {
        return (x == 0 || y == 0);
    }

    public int quadrante() {
        if (x == 0 || y == 0) {
            return 0; // Sobre algum eixo
        } else if (x > 0 && y > 0) {
            return 1; // Primeiro quadrante
        } else if (x < 0 && y > 0) {
            return 2; // Segundo quadrante
        } else if (x < 0 && y < 0) {
            return 3; // Terceiro quadrante
        } else {
            return 4; // Quarto quadrante
        }
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float distancia(Ponto2D ponto) {
        float distancia = (float) Math.sqrt(((ponto.getX() - x) * (ponto.getX() - x)) + ((ponto.getY() - y) * (ponto.getY() - y)));
        return distancia;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a coordenada X do primeiro ponto: ");
        int x1 = scanner.nextInt();
        System.out.print("Digite a coordenada Y do primeiro ponto: ");
        int y1 = scanner.nextInt();
        Ponto2D ponto1 = new Ponto2D(x1, y1);

        System.out.print("Digite a coordenada X do segundo ponto: ");
        int x2 = scanner.nextInt();
        System.out.print("Digite a coordenada Y do segundo ponto: ");
        int y2 = scanner.nextInt();
        Ponto2D ponto2 = new Ponto2D(x2, y2);

        System.out.println("Ponto 1:");
        ponto1.imprimirPonto();
        System.out.println("Ponto 2:");
        ponto2.imprimirPonto();

        System.out.println("Distância entre os pontos: " + ponto1.distancia(ponto2));
        System.out.println("Ponto 1 está no eixo X? " + ponto1.isEixoX());
        System.out.println("Ponto 1 está no eixo Y? " + ponto1.isEixoY());
        System.out.println("Ponto 1 está em algum eixo? " + ponto1.isEixos());
        System.out.println("Quadrante do Ponto 1: " + ponto1.quadrante());

        scanner.close();
    }
}
