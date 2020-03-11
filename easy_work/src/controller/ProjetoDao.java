/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.Projeto;
import persistencia.Conexao;

public class ProjetoDao {

    private static String TABELA = "projetos";

    public Projeto pesquisarNome(String nome) throws SQLException {
        Projeto proj = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE nome = ?");

        ps.setString(1, nome);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            proj = getResult(rs);
        }

        ps.close();

        return proj;
    }

    public Projeto pesquisarId(Integer id) throws SQLException {
        Projeto proj = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE id = ?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            proj = getResult(rs);
        }

        ps.close();

        return proj;
    }

    public List<Projeto> getLista() throws SQLException {

        List<Projeto> cursos = new ArrayList<>();
        String sql = "select * from " + TABELA;

        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cursos.add(getResult(rs));
        }

        return cursos;

    }

    public Boolean adicionar(Projeto proj) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("INSERT INTO " + TABELA
                        + " (nome,responsavel,descricao,cargaHoraria,dataInicio,dataFim) "
                        + "VALUES(?,?,?,?,?,?)");

        ps.setString(1, proj.getNome());
        ps.setString(2, proj.getResponsavel());
        ps.setString(3, proj.getDescricao());
        ps.setInt(4, proj.getCargaHoraria());
        ps.setDate(5, proj.getDataInicio());
        ps.setDate(6, proj.getDataFim());

        int registros = ps.executeUpdate();
        ps.close();

        return registros == 1;
    }

    private Projeto getResult(ResultSet rs) throws SQLException {
        Projeto proj = new Projeto();
        proj.setId(rs.getInt("id"));
        proj.setNome(rs.getString("nome"));
        proj.setResponsavel(rs.getString("responsavel"));
        proj.setDescricao(rs.getString("descricao"));
        proj.setCargaHoraria(rs.getInt("cargaHoraria"));
        proj.setDataInicio(rs.getDate("dataInicio"));
        proj.setDataFim(rs.getDate("dataFim"));
        return proj;
    }
    
    public Boolean remover(Integer c) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("DELETE FROM " + TABELA + " WHERE id = ?");

        ps.setInt(1, c);
        int registros = ps.executeUpdate();
        ps.close();
        return registros == 1;
    }
}
