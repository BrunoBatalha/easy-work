package model;

import java.sql.Date;

public class Curso {

    private Integer id;
    private String nome;
    private String responsavel;
    private String descricao;
    private Integer cargaHoraria;
    private java.sql.Date dataInicio;
    private java.sql.Date dataFim;

    public Curso(Integer id, String nome, String responsavel, String descricao, Integer cargaHoraria, Date dataInicio, Date dataFim) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Curso(String nome, String responsavel, String descricao, Integer cargaHoraria, Date dataInicio, Date dataFim) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Curso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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
