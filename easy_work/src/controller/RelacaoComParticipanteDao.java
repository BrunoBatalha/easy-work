package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Participante;
import model.RelacaoComParticipante;
import persistencia.Conexao;

public class RelacaoComParticipanteDao {

    protected String idAtributo;
    protected String tabela;

    public void setIdAtributo(String idAtributo) {
        this.idAtributo = idAtributo;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public RelacaoComParticipante pesquisar(Integer id, String cpf) throws SQLException {
        RelacaoComParticipante r = null;
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + tabela + "  WHERE " + idAtributo + " = ? AND cpfParticipante = ?");

        ps.setInt(1, id);
        ps.setString(2, cpf);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            r = new RelacaoComParticipante();
            r.setId(rs.getInt(idAtributo));
            r.setCpfParticipante(rs.getString("cpfParticipante"));
        }
        ps.close();
        return r;
    }

    public List<RelacaoComParticipante> pesquisarId(Integer id) throws SQLException {
        List<RelacaoComParticipante> evparts = new ArrayList<>();
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + tabela + "  WHERE " + idAtributo + " = ? ");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            RelacaoComParticipante evpart = new RelacaoComParticipante();
            evpart.setId(rs.getInt(idAtributo));
            evpart.setCpfParticipante(rs.getString("cpfParticipante"));

            evparts.add(evpart);
        }

        ps.close();

        return evparts;
    }   

    public Boolean adicionar(RelacaoComParticipante evpart) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("INSERT INTO " + tabela
                        + " (" + idAtributo + ",cpfParticipante) "
                        + "VALUES(?,?)");

        ps.setInt(1, evpart.getId());
        ps.setString(2, evpart.getCpfParticipante());

        int registros = ps.executeUpdate();
        ps.close();

        return registros == 1;
    }

    public Boolean remover(Integer id, String cpf) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("DELETE FROM " + tabela + " WHERE " + idAtributo + " = ? AND cpfParticipante = ?");

        ps.setInt(1, id);
        ps.setString(2, cpf);

        int registros = ps.executeUpdate();
        ps.close();
        return registros == 1;
    }

}
/*
public Participante pesquisarPart(Integer id, String cpf) throws SQLException {
        Participante part = new Participante();
        Conexao conexao = new Conexao();
        PreparedStatement ps = conexao.getConexao()
                .prepareStatement("SELECT * FROM " + tabela + "  "
                        + "WHERE " + idAtributo + " = ? AND cpfParticipante = ?");

        ps.setInt(1, id);
        ps.setString(2, cpf);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            
            RelacaoComParticipante evpart = new RelacaoComParticipante();
            evpart.setId(rs.getInt(idAtributo));
            evpart.setCpfParticipante(rs.getString("cpfParticipante"));

            evparts.add(evpart);
        }

        ps.close();

        return evparts;
    }
*/