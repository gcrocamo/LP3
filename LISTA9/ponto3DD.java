package ponto;

public class Main {
    public static void main(String[] args) {
        Ponto2D ponto2D = new Ponto2D(1, 2);
        Ponto3DComposicao ponto3DComposicao = new Ponto3DComposicao(1, 2, 3);
        Ponto3DAgregacao ponto3DAgregacao = new Ponto3DAgregacao(ponto2D, 3);
        Ponto3DHeranca ponto3DHeranca = new Ponto3DHeranca(1, 2, 3);

        System.out.println("Ponto2D: " + ponto2D.toString());
        System.out.println("Está na origem? " + ponto2D.isOrigin());
        System.out.println("Distância até a origem: " + ponto2D.distance(new Ponto2D()));

        System.out.println("\nPonto3DComposicao: " + ponto3DComposicao.toString());
        System.out.println("Está na origem? " + ponto3DComposicao.isOrigin());
        System.out.println("Distância até a origem: " + ponto3DComposicao.distance(new Ponto3DComposicao()));

        System.out.println("\nPonto3DAgregacao: " + ponto3DAgregacao.toString());
        System.out.println("Está na origem? " + ponto3DAgregacao.isOrigin());
        System.out.println("Distância até a origem: " + ponto3DAgregacao.distance(new Ponto3DAgregacao()));

        System.out.println("\nPonto3DHeranca: " + ponto3DHeranca.toString());
        System.out.println("Está na origem? " + ponto3DHeranca.isOrigin());
        System.out.println("Distância até a origem: " + ponto3DHeranca.distance(new Ponto3DHeranca()));
    }
    }
}

/*Composição: A classe Ponto3D cria e gerencia sua própria instância de Ponto2D. Isso significa que Ponto3D tem controle total sobre ela.
Agregação: A classe Ponto3D usa uma instância existente de Ponto2D. Isso significa que Ponto2D pode existir independentemente de Ponto3D.
Herança: A classe Ponto3D é um tipo de Ponto2D. Isso significa que Ponto3D herda todos os atributos e métodos de Ponto2D e também pode ter seus próprios atributos e métodos específicos.*/
