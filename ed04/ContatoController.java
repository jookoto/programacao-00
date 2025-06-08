package ed04;

import java.util.ArrayList;
import java.util.List;

public class ContatoController {

    public void executar() {
        // Cria uma lista de contatos
        List<Contato> contatos = new ArrayList<>();

        // Cria a nossa view responsável pela tela
        ContatoView view = new ContatoView();

        boolean saida = false;
        do {

            // Exibe o menu de opções
            view.exibirMenu();

            // Usuário escolhe a opção
            int opt = view.lerOpcao();

            switch (opt) {
                // Se opção 1 -> exibe a tela de listar
                case 1:
                    view.exibirListarContatos(contatos);
                    break;

                // Se opção 2 -> exibe a tela de adicionar
                case 2:
                    Contato contatoPF = view.exibirAdicionarPessoaFisica();
                    contatos.add(contatoPF);
                    break;

                // Se opção 3 -> exibe a tela de adicionar
                case 3:
                    Contato contatoPJ = view.exibirAdicionarPessoaJuridica();
                    contatos.add(contatoPJ);
                    break;

                // Se opção 4 -> exibe a tela de remover
                case 4:
                    //view.exibirRemover();
                    break;

                // Se opção 5 -> termina o programa
                case 5:
                    saida = true;
                    break;

                // Senão erro
                default:
                    //view.exibirMensagemErro();
            }

        } while (!saida);
    }

}