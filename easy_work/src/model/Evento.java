package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

public class Evento implements Serializable {

    private Integer id;
    private String titulo;
    private String responsavel;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;

    public Evento(Integer id, String titulo, String responsavel, String descricao, Date dataInicio, Date dataFim) {
        this.id = id;
        this.titulo = titulo;
        this.responsavel = responsavel;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Evento(String titulo, String responsavel, String descricao, Date dataInicio, Date dataFim) {
        this.titulo = titulo;
        this.responsavel = responsavel;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Evento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

}
