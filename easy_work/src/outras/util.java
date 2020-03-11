package outras;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
import view.Janela;

public class util {

    public static final int NADA = -1;
    public static final int TELA_LS_EVENTOS = 0;
    public static final int TELA_LS_PARTICIPANTES = 1;
    public static final int TELA_LS_PROJETOS = 2;
    public static final int TELA_LS_CURSOS = 3;
    public static final int TELA_LS_TDS_PARTICIPANTES = 4;
    public static final int TELA_CAD_CURSO = 5;
    public static final int TELA_CAD_PROJETO = 6;
    public static final int TELA_ADD_PART_EXIST = 7;
    public static final int TELA_MENU = 8;
    public static final int ID_CURSO = 9;
    public static final int ID_EVENTO = 10;
    public static final int ID_PROJETO = 11;
    public static int TELA_ATUAL = NADA;
    public static int TELA_ANTERIOR = NADA;

    public static int tipoId = NADA;
    public static Integer idSelecionado = NADA;
    public static final long ANO = 31536000000L;
    public static final int ERA_UNIX = 1900;

    public static void trocarTela(JPanel pAntigo, JPanel pNovo) {
        pAntigo.removeAll();
        pAntigo.remove(pAntigo);
        pNovo.setBounds(0, 0, Janela.LARGURA_PANEL, Janela.ALTURA_PANEL);
        pAntigo.add(pNovo);
        pAntigo.repaint();
        pAntigo.validate();
    }

    public static java.sql.Date converteEmMilissegundos(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(data);
        return new java.sql.Date(dataFormatada.getTime());
    }

    public static long getDataAtual() {
        Calendar cal = new GregorianCalendar();
        System.out.println("cal: " + cal.getTimeInMillis());
        return cal.getTimeInMillis();
    }

    public static int calcularIdade(long dtAtual, long dtNasc) {
        return (int) ((dtAtual - dtNasc) / ANO);
    }

    public static String gerarHash(String mensagem) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = md.digest(mensagem.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String msgCriptografia = hexString.toString();
        return msgCriptografia;
    }

    public static String formatarData(java.sql.Date dt) {

        String dia = dt.getDate() + "";
        String mes = dt.getMonth() + "";
        int ano = dt.getYear() + ERA_UNIX;
        dia = (dia.length() == 1) ? "0" + dia : dia;
        mes = (mes.length() == 1) ? "0" + mes : mes;
        return dia + "/" + mes + "/" + ano;
    }
}
