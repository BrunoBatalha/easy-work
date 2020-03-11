package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Participante;
import persistencia.Conexao;

public class ParticipanteDao {

    private static String TABELA = "participante";

    public Participante pesquisarNome(String nome) throws SQLException {
        Participante part = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE nome = ?");

        ps.setString(1, nome);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            part = new Participante();
            part.setNome(rs.getString("nome"));
            part.setCpf(rs.getString("cpf"));
            part.setFormacao(rs.getString("formacao"));
            part.setEmail(rs.getString("email"));
            part.setEndereco(rs.getString("endereco"));
            part.setRegiao(rs.getString("regiao"));
            part.setDataNascimento(rs.getDate("dataNascimento"));
        }

        ps.close();

        return part;
    }

    public List<Participante> pesquisarVariosNomes(String nome) throws SQLException {
        List<Participante> participantes = new ArrayList<>();
        Participante part = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE nome like ?");

        ps.setString(1, "%" + nome + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            part = new Participante();
            part.setNome(rs.getString("nome"));
            part.setCpf(rs.getString("cpf"));
            part.setFormacao(rs.getString("formacao"));
            part.setEmail(rs.getString("email"));
            part.setEndereco(rs.getString("endereco"));
            part.setRegiao(rs.getString("regiao"));
            part.setDataNascimento(rs.getDate("dataNascimento"));
            participantes.add(part);
        }

        ps.close();

        return participantes;
    }

    public Participante pesquisarCpf(String cpf) throws SQLException {
        Participante part = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA + "  WHERE cpf = ?");

        ps.setString(1, cpf);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            part = new Participante();
            part.setNome(rs.getString("nome"));
            part.setCpf(rs.getString("cpf"));
            part.setFormacao(rs.getString("formacao"));
            part.setEmail(rs.getString("email"));
            part.setEndereco(rs.getString("endereco"));
            part.setRegiao(rs.getString("regiao"));
            part.setDataNascimento(rs.getDate("dataNascimento"));
        }

        ps.close();

        return part;
    }

    public List<Participante> getLista() throws SQLException {

        List<Participante> participantes = new ArrayList<>();
        String sql = "select * from " + TABELA;

        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Participante part = new Participante();
            part.setNome(rs.getString("nome"));
            part.setCpf(rs.getString("cpf"));
            part.setFormacao(rs.getString("formacao"));
            part.setEmail(rs.getString("email"));
            part.setEndereco(rs.getString("endereco"));
            part.setRegiao(rs.getString("regiao"));
            part.setDataNascimento(rs.getDate("dataNascimento"));
            participantes.add(part);
        }

        return participantes;

    }

    public Boolean adicionar(Participante par) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("INSERT INTO " + TABELA
                        + " (nome,cpf,formacao,email,endereco,regiao,dataNascimento) "
                        + "VALUES(?,?,?,?,?,?,?)");

        ps.setString(1, par.getNome());
        ps.setString(2, par.getCpf());
        ps.setString(3, par.getFormacao());
        ps.setString(4, par.getEmail());
        ps.setString(5, par.getEndereco());
        ps.setString(6, par.getRegiao());
        ps.setDate(7, par.getDataNascimento());

        int registros = ps.executeUpdate();
        ps.close();

        return registros == 1;
    }

    public boolean atualizar(Participante p) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("UPDATE " + TABELA + " SET "
                        + "nome = ?, "
                        + "formacao = ?, "
                        + "email = ?, "
                        + "endereco= ?, "
                        + "regiao = ?,"
                        + "dataNascimento = ?  WHERE cpf= ?");

        ps.setString(1, p.getNome());
        ps.setString(2, p.getFormacao());
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getEndereco());
        ps.setString(5, p.getRegiao());
        ps.setDate(6, p.getDataNascimento());
        ps.setString(7, p.getCpf());
        
        int registros = ps.executeUpdate();
        ps.close();
        return registros == 1;
    }
}
