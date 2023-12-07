package ponto;

public class Ponto3D extends Ponto2D {
    private double z;

    public Ponto3D() {
        this(0, 0, 0);
    }

    public Ponto3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean isOrigin() {
        return super.isOrigin() && z == 0;
    }

    public double distance(double targetX, double targetY, double targetZ) {
        return Math.sqrt(Math.pow(getX() - targetX, 2) +
                         Math.pow(getY() - targetY, 2) +
                         Math.pow(z - targetZ, 2));
    }

    public double distance(Ponto3D ponto) {
        return distance(ponto.getX(), ponto.getY(), ponto.getZ());
    }

    @Override
    public String toString() {
        return super.toString() + ", Z: " + z;
    }

    public static void main(String[] args) {
        Ponto3D ponto3DHeranca = new Ponto3D(7, 8, 9);
        System.out.println("Herança - Ponto 3D: " + ponto3DHeranca.toString());
    }
}
