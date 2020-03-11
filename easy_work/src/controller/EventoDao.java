package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Evento;
import persistencia.Conexao;

public class EventoDao {

    private static String TABELA = "eventos";

    public Evento pesquisarTitulo(String titulo) throws SQLException {
        Evento adm = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE titulo = ?");

        ps.setString(1, titulo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            adm = new Evento();
            adm.setId(rs.getInt("id"));
            adm.setTitulo(rs.getString("titulo"));
            adm.setResponsavel(rs.getString("responsavel"));
            adm.setDescricao(rs.getString("descricao"));
            adm.setDataInicio(rs.getDate("dataInicio"));
            adm.setDataFim(rs.getDate("dataFim"));
        }

        ps.close();

        return adm;
    }

    public Evento pesquisarId(Integer id) throws SQLException {
        Evento ev = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE id = ?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            ev = new Evento();
            ev.setId(rs.getInt("id"));
            ev.setTitulo(rs.getString("titulo"));
            ev.setResponsavel(rs.getString("responsavel"));
            ev.setDescricao(rs.getString("descricao"));
            ev.setDataInicio(rs.getDate("dataInicio"));
            ev.setDataFim(rs.getDate("dataFim"));
        }

        ps.close();

        return ev;
    }

    public List<Evento> getLista() throws SQLException {

        List<Evento> eventos = new ArrayList<>();
        String sql = "select * from " + TABELA;

        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Evento evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setTitulo(rs.getString("titulo"));
            evento.setResponsavel(rs.getString("responsavel"));
            evento.setDescricao(rs.getString("descricao"));
            evento.setDataInicio(rs.getDate("dataInicio"));
            evento.setDataFim(rs.getDate("dataFim"));

            eventos.add(evento);
        }

        return eventos;

    }

    public Boolean adicionar(Evento ev) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("INSERT INTO " + TABELA
                        + " (titulo,responsavel,descricao,dataInicio,dataFim) "
                        + "VALUES(?,?,?,?,?)");

        ps.setString(1, ev.getTitulo());
        ps.setString(2, ev.getResponsavel());
        ps.setString(3, ev.getDescricao());
        ps.setDate(4, ev.getDataInicio());
        ps.setDate(5, ev.getDataFim());

        int registros = ps.executeUpdate();
        ps.close();

        return registros == 1;
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
