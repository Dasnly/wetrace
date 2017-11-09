/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Victor
 */
public class Requisicao {
    
    protected String Regiao;
    protected String dataInicio;
    protected String oqueEspero;

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String Regiao) {
        this.Regiao = Regiao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getOqueEspero() {
        return oqueEspero;
    }

    public void setOqueEspero(String oqueEspero) {
        this.oqueEspero = oqueEspero;
    }
    
    
    
}
