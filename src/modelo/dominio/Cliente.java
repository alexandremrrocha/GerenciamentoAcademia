package modelo.dominio;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String restricao;

    public Cliente() {}

    public Cliente(String nome, String cpf, String endereco, String bairro, String cidade, String uf, String telefone, String restricao) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.restricao = restricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRestricao() {
        return restricao;
    }

    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }
}
