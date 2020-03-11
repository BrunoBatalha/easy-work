package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    private static Connection conexao;

    public Conexao() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:bdSqlite.db";
            conexao =  DriverManager.getConnection(url);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na conexão "
                    + "com o Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }
    }

    public Connection getConexao() {
        return conexao;
    }
    
    

}
