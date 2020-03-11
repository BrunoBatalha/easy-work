package outras;

import javax.swing.JOptionPane;
import persistencia.Conexao;
import persistencia.CriarTabelas;
import view.Janela;
import view.PanelPrincipal;

public class Principal {
    
    public static Janela JFRAME_MAIN;
    public static PanelPrincipal JPANEL_MAIN;
    
    public static void main(String[] args) {
        try {
            JPANEL_MAIN = new PanelPrincipal();
            JFRAME_MAIN = new Janela();
            JFRAME_MAIN.aparecer();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao executar aplicaÃ§Ã£o.");
            System.exit(1);
        }
        
        CriarTabelas ct = new CriarTabelas(new Conexao());
        ct.criarTabelas();
    }
}
