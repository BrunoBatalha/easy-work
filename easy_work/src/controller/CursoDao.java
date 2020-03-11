package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import persistencia.Conexao;

public class CursoDao {

    private static String TABELA = "cursos";

    public Curso pesquisarNome(String nome) throws SQLException {
        Curso crs = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE nome = ?");

        ps.setString(1, nome);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            crs = getResult(rs);
        }

        ps.close();

        return crs;
    }

    public Curso pesquisarId(Integer id) throws SQLException {
        Curso crs = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE id = ?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            crs = getResult(rs);
        }

        ps.close();

        return crs;
    }

    public List<Curso> getLista() throws SQLException {

        List<Curso> cursos = new ArrayList<>();
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

    public Boolean adicionar(Curso crs) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("INSERT INTO " + TABELA
                        + " (nome,responsavel,descricao,cargaHoraria,dataInicio,dataFim) "
                        + "VALUES(?,?,?,?,?,?)");

        ps.setString(1, crs.getNome());
        ps.setString(2, crs.getResponsavel());
        ps.setString(3, crs.getDescricao());
        ps.setInt(4, crs.getCargaHoraria());
        ps.setDate(5, crs.getDataInicio());
        ps.setDate(6, crs.getDataFim());

        int registros = ps.executeUpdate();
        ps.close();

        return registros == 1;
    }

    private Curso getResult(ResultSet rs) throws SQLException {
        Curso crs = new Curso();
        crs.setId(rs.getInt("id"));
        crs.setNome(rs.getString("nome"));
        crs.setResponsavel(rs.getString("responsavel"));
        crs.setDescricao(rs.getString("descricao"));
        crs.setCargaHoraria(rs.getInt("cargaHoraria"));
        crs.setDataInicio(rs.getDate("dataInicio"));
        crs.setDataFim(rs.getDate("dataFim"));
        return crs;
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
