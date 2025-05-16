package ed01;

import java.util.Random;
import java.util.Scanner;

    // Classe principal do jogo
public class Jogo {
    private Scanner sc;
    private Random rand;
    private Placar placar;

    // Construtor da classe Jogo
    public Jogo(Scanner sc, Random rand, Placar placar) {
        this.sc = sc;
        this.rand = rand;
        this.placar = placar;
    }

    // Método para iniciar o jogo
    public void iniciar() {
        System.out.println("Jogo de Adivinhação");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        Jogador jogador = new Jogador(nome);
    
        int numeroSecreto = rand.nextInt(100) + 1; // Gera um número entre 1 e 100
        boolean acertou = false;

        System.out.println("Tente adivinhar o número secreto (entre 1 e 100):");
        
        // Loop para o jogador tentar adivinhar o número
        while (!acertou) {
            System.out.print("Digite o número: ");
            int numero = sc.nextInt();

            if (numero < numeroSecreto) {
                System.out.println("O número secreto é maior!");
                jogador.incrementarTentativas();
            } else if (numero > numeroSecreto) {
                System.out.println("O número secreto é menor!");
                jogador.incrementarTentativas();
            } else {
                System.out.println("Parabéns, " + jogador.getNome() + "! Você acertou o número secreto: " + numeroSecreto);
                jogador.incrementarTentativas();
                jogador.setPontuacao(100 - jogador.getTentativas() * 10); // Exemplo de cálculo de pontuação
                System.out.println("Sua pontuação: " + jogador.getPontuacao());
                System.out.println("Tentativas: " + jogador.getTentativas());
                acertou = true;

                placar.adicionarJogador(jogador); // Adiciona o jogador ao placar
                placar.mostrarRanking(); // Exibir o ranking após o jogo
            }
        }
    }
}