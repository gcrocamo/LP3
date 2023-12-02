import java.lang.Math;

class Figura3D {
    protected double raio;
    protected double altura;

    public Figura3D(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public void imprimirDados() {
        System.out.println("Raio: " + raio);
        System.out.println("Altura: " + altura);
    }

    public double calcularVolume() {
        return 0.0;
    }

    public double calcularAreaSuperficial() {
        return 0.0;
    }
}

class Cilindro extends Figura3D {
    public Cilindro(double raio, double altura) {
        super(raio, altura);
    }

    @Override
    public double calcularVolume() {
        return Math.PI * raio * raio * altura;
    }

    @Override
    public double calcularAreaSuperficial() {
        return 2 * Math.PI * raio * raio + 2 * Math.PI * raio * altura;
    }
}

class Cone extends Figura3D {
    public Cone(double raio, double altura) {
        super(raio, altura);
    }

    @Override
    public double calcularVolume() {
        return (Math.PI * raio * raio * altura) / 3.0;
    }

    @Override
    public double calcularAreaSuperficial() {
        double lado = Math.sqrt(raio * raio + altura * altura);
        return Math.PI * raio * (raio + lado);
    }
}

public class ProgramaFiguras3D {
    public static void main(String[] args) {
        Cilindro cilindro = new Cilindro(5.0, 10.0);
        System.out.println("Cilindro:");
        cilindro.imprimirDados();
        System.out.println("Volume: " + cilindro.calcularVolume());
        System.out.println("Área Superficial: " + cilindro.calcularAreaSuperficial());
        System.out.println();

        Cone cone = new Cone(3.0, 7.0);
        System.out.println("Cone:");
        cone.imprimirDados();
        System.out.println("Volume: " + cone.calcularVolume());
        System.out.println("Área Superficial: " + cone.calcularAreaSuperficial());
    }
}
