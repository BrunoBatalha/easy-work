/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class Participante {

    private String nome;
    private String cpf;
    private String email;
    private String formacao;
    private String endereco;
    private String regiao;
    private Date dataNascimento;

    public Participante() {
    }

    public Participante(String nome, String email, String formacao) {
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;
    }

    public Participante(String nome, String cpf, String email, String formacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.formacao = formacao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
