package modelo.dominio;

import java.util.Date;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class Equipamento {
    private String codigo;
    private String nome;
    private String fornecedor;
    private Date dataCompra;
    private String quantidade;
    private String valor;
    private String limitePeso;
    
    public Equipamento(){}

    public Equipamento(String codigo, String nome, String fornecedor, Date dataCompra, String quantidade, String valor, String limitePeso) {
        this.codigo = codigo;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.dataCompra = dataCompra;
        this.quantidade = quantidade;
        this.valor = valor;
        this.limitePeso = limitePeso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLimitePeso() {
        return limitePeso;
    }

    public void setLimitePeso(String limitePeso) {
        this.limitePeso = limitePeso;
    }

    
       
}
