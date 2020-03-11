/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


public class CursoParticipanteDao extends RelacaoComParticipanteDao{

    public CursoParticipanteDao() {
        setTabela("cursoParticipante");
        setIdAtributo("idCurso");
    }
    
}
