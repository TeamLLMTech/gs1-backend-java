package br.com.llmtech.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "EVENTOS")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPrevista;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal probabilidade;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date geradoEm;

    @Column(columnDefinition = "CLOB")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_modelo", nullable = false)
    private ModeloIA modelo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_evento", nullable = false)
    private TipoEventoNatural tipoEvento;

    @ManyToOne
    @JoinColumn(name = "id_regiao", nullable = false)
    private RegiaoMonitorada regiao;

    @Temporal(TemporalType.DATE)
    private Date dataOcorrencia;

    @OneToMany(mappedBy = "evento")
    private List<Alerta> alertas;

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public BigDecimal getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(BigDecimal probabilidade) {
        this.probabilidade = probabilidade;
    }

    public Date getGeradoEm() {
        return geradoEm;
    }

    public void setGeradoEm(Date geradoEm) {
        this.geradoEm = geradoEm;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ModeloIA getModelo() {
        return modelo;
    }

    public void setModelo(ModeloIA modelo) {
        this.modelo = modelo;
    }

    public TipoEventoNatural getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEventoNatural tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public RegiaoMonitorada getRegiao() {
        return regiao;
    }

    public void setRegiao(RegiaoMonitorada regiao) {
        this.regiao = regiao;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    // Getters and setters
    // ...
}
