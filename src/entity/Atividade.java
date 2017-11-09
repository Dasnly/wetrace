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
public class Atividade {
    
    protected Long id;
    protected String nome;
    protected String tipo;
    protected Integer gastoAproximado;
    protected String turno;
    protected String descricao;
    protected String idcidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getGastoAproximado() {
        return gastoAproximado;
    }

    public void setGastoAproximado(Integer gastoAproximado) {
        this.gastoAproximado = gastoAproximado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(String idcidade) {
        this.idcidade = idcidade;
    }

  

   
    
}
