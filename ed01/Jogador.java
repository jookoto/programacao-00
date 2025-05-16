package ed01;

import java.io.Serializable;

public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L; // Adicione um serialVersionUID
    private String nome;
    private int tentativas;
    private int pontuacao;


    // Construtor da classe Jogador
    public Jogador(String nome) {
        this.nome = nome;
        this.tentativas = 0;
        this.pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void incrementarTentativas() {
        this.tentativas++;
    }
}
