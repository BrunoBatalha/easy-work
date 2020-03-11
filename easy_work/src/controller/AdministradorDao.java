package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Administrador;
import persistencia.Conexao;

public class AdministradorDao {

    private static String TABELA = "administradores";

    public Administrador pesquisarEmailSenha(String email, String senha) throws SQLException {
        Administrador adm = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + TABELA
                        + " WHERE email = ? AND senha = ?");

        ps.setString(1, email);
        ps.setString(2, senha);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            adm = new Administrador();
            adm.setId(rs.getInt("id"));
            adm.setNome(rs.getString("nome"));
            adm.setEmail(rs.getString("email"));
            adm.setSenha(rs.getString("senha"));
        }

        ps.close();

        return adm;
    }

    public Boolean adicionar(Administrador adm) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("INSERT INTO " + TABELA + " (nome,email,senha) VALUES(?,?,?)");

        ps.setString(1, adm.getNome());
        ps.setString(2, adm.getEmail());
        ps.setString(3, adm.getSenha());

        int registros = ps.executeUpdate();
        ps.close();

        return registros == 1;
    }
}
