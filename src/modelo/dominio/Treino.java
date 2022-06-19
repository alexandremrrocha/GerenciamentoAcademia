package modelo.dominio;

import java.util.Date;

/**
 *
 * @author Alexandre Rocha e Raquel
 */
public class Treino {
    
    private String nomeCliente;
    private String nomePersonal;
    private String numeroTreino;
    private Date dataTreino;
    private String preTreino;
    private String tempoPre;
    private String posTreino;
    private String tempoPos;
    private String grupoMuscular;
    private String serie;
    private String repeticao;
    private String intervalo;
    private String horaInicio;
    private String horaFim;

    public Treino() {}

    public Treino(String nomeCliente, String nomePersonal, String numeroTreino, Date dataTreino, String preTreino, String tempoPre, String posTreino, String tempoPos, String grupoMuscular, String serie, String repeticao, String intervalo, String horaInicio, String horaFim) {
        this.nomeCliente = nomeCliente;
        this.nomePersonal = nomePersonal;
        this.numeroTreino = numeroTreino;
        this.dataTreino = dataTreino;
        this.preTreino = preTreino;
        this.tempoPre = tempoPre;
        this.posTreino = posTreino;
        this.tempoPos = tempoPos;
        this.grupoMuscular = grupoMuscular;
        this.serie = serie;
        this.repeticao = repeticao;
        this.intervalo = intervalo;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomePersonal() {
        return nomePersonal;
    }

    public void setNomePersonal(String nomePersonal) {
        this.nomePersonal = nomePersonal;
    }
    
    public String getNumeroTreino() {
        return numeroTreino;
    }

    public void setNumeroTreino(String numeroTreino) {
        this.numeroTreino = numeroTreino;
    }

    public Date getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(Date dataTreino) {
        this.dataTreino = dataTreino;
    }

    public String getPreTreino() {
        return preTreino;
    }

    public void setPreTreino(String preTreino) {
        this.preTreino = preTreino;
    }

    public String getTempoPre() {
        return tempoPre;
    }

    public void setTempoPre(String tempoPre) {
        this.tempoPre = tempoPre;
    }

    public String getPosTreino() {
        return posTreino;
    }

    public void setPosTreino(String posTreino) {
        this.posTreino = posTreino;
    }

    public String getTempoPos() {
        return tempoPos;
    }

    public void setTempoPos(String tempoPro) {
        this.tempoPos = tempoPro;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(String repeticao) {
        this.repeticao = repeticao;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    

}
