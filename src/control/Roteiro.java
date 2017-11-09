/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "roteiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roteiro.findAll", query = "SELECT r FROM Roteiro r")
    , @NamedQuery(name = "Roteiro.findByIdroteiro", query = "SELECT r FROM Roteiro r WHERE r.idroteiro = :idroteiro")
    , @NamedQuery(name = "Roteiro.findByNome", query = "SELECT r FROM Roteiro r WHERE r.nome = :nome")
    , @NamedQuery(name = "Roteiro.findByRegiao", query = "SELECT r FROM Roteiro r WHERE r.regiao = :regiao")
    , @NamedQuery(name = "Roteiro.findByDataInicio", query = "SELECT r FROM Roteiro r WHERE r.dataInicio = :dataInicio")
    , @NamedQuery(name = "Roteiro.findByDescricao", query = "SELECT r FROM Roteiro r WHERE r.descricao = :descricao")})
public class Roteiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idroteiro")
    private Long idroteiro;
    @Column(name = "nome")
    private String nome;
    @Column(name = "regiao")
    private String regiao;
    @Column(name = "dataInicio")
    private String dataInicio;
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "idviajante", referencedColumnName = "idviajante")
    @ManyToOne(optional = false)
    private Viajante idviajante;

    public Roteiro() {
    }

    public Roteiro(Long idroteiro) {
        this.idroteiro = idroteiro;
    }

    public Long getIdroteiro() {
        return idroteiro;
    }

    public void setIdroteiro(Long idroteiro) {
        this.idroteiro = idroteiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Viajante getIdviajante() {
        return idviajante;
    }

    public void setIdviajante(Viajante idviajante) {
        this.idviajante = idviajante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroteiro != null ? idroteiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roteiro)) {
            return false;
        }
        Roteiro other = (Roteiro) object;
        if ((this.idroteiro == null && other.idroteiro != null) || (this.idroteiro != null && !this.idroteiro.equals(other.idroteiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.Roteiro[ idroteiro=" + idroteiro + " ]";
    }
    
}
