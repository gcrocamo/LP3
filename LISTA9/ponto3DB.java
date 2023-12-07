package ponto;

public class Ponto3D {
    private Ponto2D ponto2D;
    private double z;

    public Ponto3D(Ponto2D ponto2D, double z) {
        this.ponto2D = ponto2D;
        this.z = z;
    }

    public double getZ() {
        return z;
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
        Ponto2D ponto2DAgregacao = new Ponto2D(4, 5);
        Ponto3D ponto3DAgregacao = new Ponto3D(ponto2DAgregacao, 6);
        System.out.println("Agregação - Ponto 3D: " + ponto3DAgregacao.toString());
    }
}
