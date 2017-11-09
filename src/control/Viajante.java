/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "viajante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viajante.findAll", query = "SELECT v FROM Viajante v")
    , @NamedQuery(name = "Viajante.findByIdviajante", query = "SELECT v FROM Viajante v WHERE v.idviajante = :idviajante")
    , @NamedQuery(name = "Viajante.findByNome", query = "SELECT v FROM Viajante v WHERE v.nome = :nome")
    , @NamedQuery(name = "Viajante.findByEmail", query = "SELECT v FROM Viajante v WHERE v.email = :email")
    , @NamedQuery(name = "Viajante.findByCpf", query = "SELECT v FROM Viajante v WHERE v.cpf = :cpf")
    , @NamedQuery(name = "Viajante.findBySenha", query = "SELECT v FROM Viajante v WHERE v.senha = :senha")
    , @NamedQuery(name = "Viajante.findByLevel", query = "SELECT v FROM Viajante v WHERE v.level = :level")})
public class Viajante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idviajante")
    private Long idviajante;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "senha")
    private String senha;
    @Column(name = "level")
    private String level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idviajante")
    private Collection<Roteiro> roteiroCollection;

    public Viajante() {
    }

    public Viajante(Long idviajante) {
        this.idviajante = idviajante;
    }

    public Long getIdviajante() {
        return idviajante;
    }

    public void setIdviajante(Long idviajante) {
        this.idviajante = idviajante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @XmlTransient
    public Collection<Roteiro> getRoteiroCollection() {
        return roteiroCollection;
    }

    public void setRoteiroCollection(Collection<Roteiro> roteiroCollection) {
        this.roteiroCollection = roteiroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idviajante != null ? idviajante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viajante)) {
            return false;
        }
        Viajante other = (Viajante) object;
        if ((this.idviajante == null && other.idviajante != null) || (this.idviajante != null && !this.idviajante.equals(other.idviajante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.Viajante[ idviajante=" + idviajante + " ]";
    }
    
}
