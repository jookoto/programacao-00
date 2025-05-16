package ed01;

import java.io.*;
import java.util.ArrayList;

public class Placar {

    private ArrayList<Jogador> ranking;

    // Nome do arquivo para salvar o ranking
    private static final String ARQUIVO_RANKING = "ranking.dat";

    // Construtor
    public Placar() {
        this.ranking = carregarRanking(); // Carregar o ranking do arquivo ao iniciar
    }

    // Adicionar um jogador ao ranking
    public void adicionarJogador(Jogador jogador) {
        ranking.add(jogador);
        salvarRanking(); // Salvar o ranking atualizado no arquivo
    }

    // Mostrar o ranking
    public void mostrarRanking() {
        System.out.println("Ranking dos Jogadores:");
        ranking.sort((j1, j2) -> Integer.compare(j2.getPontuacao(), j1.getPontuacao()));
        for (Jogador jogador : ranking) {
            System.out.println(jogador.getNome() + " - Pontuação: " + jogador.getPontuacao());
        }
    }

    // Salvar o ranking no arquivo
    private void salvarRanking() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_RANKING))) {
            oos.writeObject(ranking);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o ranking: " + e.getMessage());
        }
    }

    // Carregar o ranking do arquivo
    @SuppressWarnings("unchecked")
    private ArrayList<Jogador> carregarRanking() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_RANKING))) {
            return (ArrayList<Jogador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Retorna uma lista vazia se o arquivo não existir ou houver erro
            return new ArrayList<>();
        }
    }
}
