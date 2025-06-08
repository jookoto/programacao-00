package ed04;

import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    public void salvar(Contato contato) {
        // Manipulação de arquivos
        // Caminhos (Path)
        //  - Absoluto: informa o caminho do arquivo a partir
        //              da raiz do sistema
        //              /home/chaua/poo/teste.txt
        //              C:\Users\chaua\poo\teste.txt
        //
        //  - Relativo: informa o caminho do arquivo a partir
        //              do diretorio de execucao
        //              poo/teste.txt

        List<String> lista = new ArrayList<>();
        lista.add(contato.toCSV());

        // Excecoes!!!
        Files.write(Paths.get("contatos.txt"),
                    lista,
                    StandardOpenOption.APPEND);

    }

    public void salvar(List<Contato> contatos) {

    }

    public List<Contato> carregar() {

    }


}