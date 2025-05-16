package ed01;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Inicializar Scanner
        Random rand = new Random(); // Inicializar Random
        Placar placar = new Placar(); // Inicializar Placar

        Jogo jogo = new Jogo(sc, rand, placar); // Passar as instâncias para o Jogo
        jogo.iniciar(); // Iniciar o jogo
    }
}
