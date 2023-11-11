public class Triangulo {
    private Ponto2D ponto1;
    private Ponto2D ponto2;
    private Ponto2D ponto3;

    public Triangulo(Ponto2D ponto1, Ponto2D ponto2, Ponto2D ponto3) {
        this.ponto1 = ponto1;
        this.ponto2 = ponto2;
        this.ponto3 = ponto3;
    }

    public void imprimeTriangulo() {
        System.out.println("O triângulo é definido pelos pontos (" + ponto1.getX() + ", " + ponto1.getY() + "), (" + ponto2.getX() + ", " + ponto2.getY() + ") e (" + ponto3.getX() + ", " + ponto3.getY() + ")");
    }

    public boolean isTrianguloRetangulo() {
        float distancia12 = ponto1.distancia(ponto2);
        float distancia23 = ponto2.distancia(ponto3);
        float distancia31 = ponto3.distancia(ponto1);

        return Math.abs(distancia12*distancia12 + distancia23*distancia23 - distancia31*distancia31) < 0.001 ||
               Math.abs(distancia12*distancia12 + distancia31*distancia31 - distancia23*distancia23) < 0.001 ||
               Math.abs(distancia23*distancia23 + distancia31*distancia31 - distancia12*distancia12) < 0.001;
    }

    public boolean isTrianguloIsosceles() {
        float distancia12 = ponto1.distancia(ponto2);
        float distancia23 = ponto2.distancia(ponto3);
        float distancia31 = ponto3.distancia(ponto1);

        return Math.abs(distancia12 - distancia23) < 0.001 ||
               Math.abs(distancia12 - distancia31) < 0.001 ||
               Math.abs(distancia23 - distancia31) < 0.001;
    }

    public boolean isTrianguloEquilatero() {
        float distancia12 = ponto1.distancia(ponto2);
        float distancia23 = ponto2.distancia(ponto3);
        float distancia31 = ponto3.distancia(ponto1);

        return Math.abs(distancia12 - distancia23) < 0.001 &&
               Math.abs(distancia12 - distancia31) < 0.001;
    }
}