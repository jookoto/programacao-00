import java.util.Random;

abstract class Personagem {
    protected String nome;
    protected int hp;
    protected int ataqueBase;

    public Personagem(String nome, int hp, int ataqueBase) {
        this.nome = nome;
        this.hp = hp;
        this.ataqueBase = ataqueBase;
    }

    public void atacar(Personagem inimigo) {
        System.out.println(nome + " ataca " + inimigo.nome + " causando " + ataqueBase + " de dano!");
        inimigo.defender(ataqueBase);
    }

    public void defender(int dano) {
        hp -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano! HP restante: " + hp);
    }

    public abstract void usarHabilidadeEspecial(Personagem[] inimigos);

    public void status() {
        System.out.println(nome + " | HP: " + hp + " | Ataque: " + ataqueBase);
    }
}

class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 150, 20);
    }

    @Override
    public void defender(int dano) {
        int danoReduzido = dano / 2;
        hp -= danoReduzido;
        System.out.println(nome + " bloqueou! Recebeu " + danoReduzido + " de dano! HP: " + hp);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem[] inimigos) {
        if (inimigos.length > 0) {
            Personagem alvo = inimigos[0];
            System.out.println(nome + " usa Golpe Duplo em " + alvo.nome + "!");
            atacar(alvo);
            atacar(alvo);
        }
    }
}

class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 100, 25);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem[] inimigos) {
        System.out.println(nome + " lança Bola de Fogo em área!");
        for (Personagem inimigo : inimigos) {
            System.out.println("Bola de Fogo atinge " + inimigo.nome + " causando " + (ataqueBase + 10) + " de dano!");
            inimigo.defender(ataqueBase + 10);
        }
    }
}

class Arqueiro extends Personagem {
    private Random rand = new Random();

    public Arqueiro(String nome) {
        super(nome, 120, 18);
    }

    @Override
    public void atacar(Personagem inimigo) {
        boolean critico = rand.nextInt(100) < 20;
        int danoFinal = critico ? ataqueBase * 2 : ataqueBase;
        System.out.println(nome + (critico ? " acertou um CRÍTICO! " : " ataca ") + inimigo.nome + " causando " + danoFinal + " de dano!");
        inimigo.defender(danoFinal);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem[] inimigos) {
        if (inimigos.length > 0) {
            Personagem alvo = inimigos[0];
            System.out.println(nome + " usa Chuva de Flechas em " + alvo.nome + "!");
            for (int i = 1; i <= 3; i++) {
                System.out.println("Flecha " + i + ":");
                atacar(alvo);
            }
        }
    }
}
