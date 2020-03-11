/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aluno
 */
public class CriarTabelas {

    private final Conexao con;

    public CriarTabelas(Conexao con) {
        this.con = con;
    }

    public void criarTabelas() {

        String tAdm = "CREATE TABLE IF NOT EXISTS administradores ("
                + "    id    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,\n"
                + "    nome  VARCHAR NOT NULL,\n"
                + "    email VARCHAR UNIQUE NOT NULL,\n"
                + "    senha VARCHAR NOT NULL"
                + ");";
        String tep = "CREATE TABLE IF NOT EXISTS eventoParticipante ("
                + "    idEvento        INTEGER REFERENCES eventos (id),\n"
                + "    cpfParticipante VARCHAR REFERENCES participante (cpf)"
                + ");";
        String tEv = "CREATE TABLE IF NOT EXISTS eventos ("
                + "    id          INTEGER  PRIMARY KEY AUTOINCREMENT\n"
                + "                         NOT NULL UNIQUE,\n"
                + "    titulo      VARCHAR  UNIQUE NOT NULL,\n"
                + "    responsavel VARCHAR  NOT NULL,\n"
                + "    descricao   VARCHAR  NOT NULL,\n"
                + "    dataInicio  DATETIME NOT NULL,\n"
                + "    dataFim     DATETIME NOT NULL"
                + ");";
        String tP = "CREATE TABLE IF NOT EXISTS participante (\n"
                + "    nome     VARCHAR NOT NULL,\n"
                + "    cpf      VARCHAR PRIMARY KEY NOT NULL UNIQUE,\n"
                + "    formacao VARCHAR NOT NULL,\n"
                + "    email    VARCHAR UNIQUE NOT NULL,\n"
                + "    endereco VARCHAR NOT NULL,\n"
                + "    regiao   VARCHAR NOT NULL,\n"
                + "    dataNascimento DATETIME NOT NULL"
                + ");";
        String tC = "CREATE TABLE IF NOT EXISTS cursos (\n"
                + "    id           INTEGER  PRIMARY KEY AUTOINCREMENT\n"
                + "                          NOT NULL\n"
                + "                          UNIQUE,\n"
                + "    nome         VARCHAR  NOT NULL,\n"
                + "    responsavel  VARCHAR  NOT NULL,\n"
                + "    descricao    VARCHAR  NOT NULL,\n"
                + "    cargaHoraria INTEGER  NOT NULL,\n"
                + "    dataInicio   DATETIME NOT NULL,\n"
                + "    dataFim      DATETIME NOT NULL\n"
                + ");";
        String tPr = "CREATE TABLE IF NOT EXISTS projetos (\n"
                + "    id           INTEGER  PRIMARY KEY AUTOINCREMENT\n"
                + "                          NOT NULL\n"
                + "                          UNIQUE,\n"
                + "    nome         VARCHAR  NOT NULL,\n"
                + "    responsavel  VARCHAR  NOT NULL,\n"
                + "    descricao    VARCHAR  NOT NULL,\n"
                + "    cargaHoraria INTEGER  NOT NULL,\n"
                + "    dataInicio   DATETIME NOT NULL,\n"
                + "    dataFim      DATETIME NOT NULL\n"
                + ");";
        String tCp = "CREATE TABLE IF NOT EXISTS cursoParticipante ("
                + "    idCurso        INTEGER REFERENCES cursos (id),\n"
                + "    cpfParticipante VARCHAR REFERENCES participante (cpf)"
                + ");";
        String tPp = "CREATE TABLE IF NOT EXISTS projetoParticipante ("
                + "    idProjeto        INTEGER REFERENCES projetos (id),\n"
                + "    cpfParticipante VARCHAR REFERENCES participante (cpf)"
                + ");";
        try {
            Statement stmt = this.con.getConexao().createStatement();

            stmt.execute(tAdm);
            stmt.execute(tEv);
            stmt.execute(tP);
            stmt.execute(tep);
            stmt.execute(tPr);
            stmt.execute(tC);
            stmt.execute(tCp);
            stmt.execute(tPp);
            
            System.out.println("Tabelas criadas!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
