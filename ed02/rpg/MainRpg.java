public class MainRpg {
    public static void main(String[] args) {
        Guerreiro g = new Guerreiro("Thorgal");
        Mago m = new Mago("Merlino");
        Arqueiro a = new Arqueiro("Legolis");

        Personagem[] inimigosParaMago = {g, a};
        Personagem[] inimigoUnico = {m};

        System.out.println("\n--- Status Inicial ---");
        g.status();
        m.status();
        a.status();

        System.out.println("\n--- Combate ---");
        g.atacar(m);
        m.usarHabilidadeEspecial(inimigosParaMago);
        a.usarHabilidadeEspecial(inimigoUnico);

        System.out.println("\n--- Status Final ---");
        g.status();
        m.status();
        a.status();
    }
}
