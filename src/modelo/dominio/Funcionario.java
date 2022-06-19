package modelo.dominio;

import java.util.Date;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class Funcionario {
    
    private String nome;
    private String cpf;
     private String endereco;
    private String cidade;
    private String uf;
    private String cargo;
    private Date dataContratacao;
    private String salario;

    public Funcionario() {}

    public Funcionario(String nome, String cpf, String endereco, String cidade, String uf, String cargo, Date dataContratacao, String salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
   
}
