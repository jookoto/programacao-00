package ed04;

public class ContatoBase implements Contato{
    private String nome;
    private String email;
    private String telefone;

    public ContatoBase(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public ContatoBase() {
        this("", "", "");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toCSV() {
        return nome + "," + telefone + "," + email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



}