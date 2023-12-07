package ponto;

public class Ponto3D {
    private Ponto2D ponto2D;
    private double z;

    public Ponto3D() {
        this(0, 0, 0);
    }

    public Ponto3D(double x, double y, double z) {
        this.ponto2D = new Ponto2D(x, y);
        this.z = z;
    }

    public double getX() {
        return ponto2D.getX();
    }

    public double getY() {
        return ponto2D.getY();
    }

    public double getZ() {
        return z;
    }

    public boolean inAxisX() {
        return ponto2D.inAxisX();
    }

    public boolean inAxisY() {
        return ponto2D.inAxisY();
    }

    public boolean inAxis() {
        return ponto2D.inAxis();
    }

    public boolean isOrigin() {
        return ponto2D.isOrigin() && z == 0;
    }

    public double distance(double targetX, double targetY, double targetZ) {
        return Math.sqrt(Math.pow(ponto2D.getX() - targetX, 2) +
                         Math.pow(ponto2D.getY() - targetY, 2) +
                         Math.pow(z - targetZ, 2));
    }

    public double distance(Ponto3D ponto) {
        return distance(ponto.getX(), ponto.getY(), ponto.getZ());
    }

    @Override
    public String toString() {
        return ponto2D.toString() + ", Z: " + z;
    }

    public static void main(String[] args) {
        Ponto3D ponto3D = new Ponto3D(1, 2, 3);

        System.out.println("Ponto 3D: " + ponto3D.toString());
        System.out.println("Ponto 3D está na origem? " + ponto3D.isOrigin());
        System.out.println("Distância até a origem: " + ponto3D.distance(new Ponto3D()));
    }
}
