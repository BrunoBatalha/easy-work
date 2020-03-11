package model;

public class  RelacaoComParticipante {
    protected Integer id;
    protected String cpfParticipante;

    public RelacaoComParticipante(Integer id, String cpfParticipante) {
        this.id = id;
        this.cpfParticipante = cpfParticipante;
    }

    public RelacaoComParticipante() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer idEvento) {
        this.id = idEvento;
    }

    public String getCpfParticipante() {
        return cpfParticipante;
    }

    public void setCpfParticipante(String cpfParticipante) {
        this.cpfParticipante = cpfParticipante;
    }
}
