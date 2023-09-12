import java.util.Random;

public class Craps {
    
	public static void main(String[] args){
        int dado1 = jogarDado(), dado2 = jogarDado(), ponto = dado1+dado2;
        System.out.println("Dado 1: " + dado1 + " | Dado 2: " + dado2);
        System.out.println("Pontos: " + ponto);
        if (ponto == 7 || ponto == 11)
            System.out.println("Vc ganhou :-)");
        else if (ponto == 2 || ponto == 3 || ponto == 12)
            System.out.println("Vc perdeu :-(");
        else{
            int cont = 0;
            System.out.println("\nESTAGIO 2");
            while (true){
                dado1 = jogarDado();
                dado2 = jogarDado();
                System.out.println("Jogada " + (++cont));
                System.out.println("Dado 1: " + dado1 + " | Dado 2: " + dado2);
                System.out.println("Pontos: " + (dado1+dado2) + "\n");
                if (dado1+dado2 == ponto){
                	System.out.println("Vc ganhou :-)");
                    break;
                }
                else if (dado1+dado2 == 7){
                	System.out.println("Vc perdeu :-(");
                    break;
                }
            }
        }
    }
    public static int jogarDado(){
        Random rand = new Random();
        return 1 + rand.nextInt(6);
    }
}