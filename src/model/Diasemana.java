/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "diasemana")
@NamedQueries({
    @NamedQuery(name = "Diasemana.findAll", query = "SELECT d FROM Diasemana d")})
public class Diasemana implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSemana")
    private Integer idSemana;
    @Column(name = "nome")
    private String nome;
    @Column(name = "estado")
    private String estado;

    public Diasemana() {
    }

    public Diasemana(Integer idSemana) {
        this.idSemana = idSemana;
    }

    public Integer getIdSemana() {
        return idSemana;
    }

    public void setIdSemana(Integer idSemana) {
        this.idSemana = idSemana;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSemana != null ? idSemana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diasemana)) {
            return false;
        }
        Diasemana other = (Diasemana) object;
        if ((this.idSemana == null && other.idSemana != null) || (this.idSemana != null && !this.idSemana.equals(other.idSemana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Diasemana[ idSemana=" + idSemana + " ]";
    }
    
}
