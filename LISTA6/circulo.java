public class Esfera {
    private double coordX;
    private double coordY;
    private double raio;

    public Esfera() {
        this(0, 0, 1);
    }

    public Esfera(double raio) {
        this(0, 0, raio);
    }
    
    public Esfera(double coordX, double coordY) {
        this(coordX, coordY, 1);
    }
    public Esfera(double coordX, double coordY, double raio) {
        validarEsfera(raio);
        this.coordX = coordX;
        this.coordY = coordY;
        this.raio = raio;
    }

    private boolean validarEsfera(double raio) {
        if (raio > 0)
            return true;
        throw new IllegalArgumentException("Invalid raio.");
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public void setRaio(double raio) {
        validarEsfera(raio);
        this.raio = raio;
    }

    public double getCoordX() {
        return this.coordX;
    }

    public double getCoordY() {
        return this.coordY;
    }

    public double getRaio() {
        return this.raio;
    }

    public void imprimirEsfera() {
        System.out.println("(" + this.coordX + ", " + this.coordY + ", " + this.raio + ")");
    }

    public boolean isInnerPoint(Ponto2D ponto) {
        Ponto2D centro = new Ponto2D(this.coordX, this.coordY);
        return ponto.distancia(centro) <= this.raio;
    }

    public double area() {
        return Math.PI * this.raio * this.raio;
    }

    public double perimeter() {
        return 2 * Math.PI * this.raio;
    }

    public boolean isBiggerThan(Esfera esfera) {
        return this.area() > esfera.area();
    }

    public static void main(String[] args) {
        Esfera esfera3 = new Esfera(0, 0, 3);
        Esfera esfera4 = new Esfera(0, 0, 1);
        esfera3.imprimirEsfera();

        Ponto2D ponto = new Ponto2D(1, 1);
        System.out.println(esfera3.isInnerPoint(ponto));
        System.out.println(esfera3.area());
        System.out.println(esfera3.perimeter());
        System.out.println(esfera3.isBiggerThan(esfera4));
    }
}
