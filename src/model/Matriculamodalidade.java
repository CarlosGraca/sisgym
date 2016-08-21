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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "matriculamodalidade")
@NamedQueries({
    @NamedQuery(name = "Matriculamodalidade.findAll", query = "SELECT m FROM Matriculamodalidade m")})
public class Matriculamodalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatriculaModalidade")
    private Integer idMatriculaModalidade;
    @Basic(optional = false)
    @Column(name = "valorModalidade")
    private double valorModalidade;
    @JoinColumn(name = "idMatricula", referencedColumnName = "idMatricula")
    @ManyToOne(optional = false)
    private Integer matricula;
    @JoinColumn(name = "idModalidade", referencedColumnName = "idModalidade")
    @ManyToOne(optional = false)
    private Integer modalidade;

    public Matriculamodalidade() {
    }

    public Matriculamodalidade(Integer idMatriculaModalidade) {
        this.idMatriculaModalidade = idMatriculaModalidade;
    }

    public Matriculamodalidade(Integer idMatriculaModalidade, double valorModalidade) {
        this.idMatriculaModalidade = idMatriculaModalidade;
        this.valorModalidade = valorModalidade;
    }

    public Integer getIdMatriculaModalidade() {
        return idMatriculaModalidade;
    }

    public void setIdMatriculaModalidade(Integer idMatriculaModalidade) {
        this.idMatriculaModalidade = idMatriculaModalidade;
    }

    public double getValorModalidade() {
        return valorModalidade;
    }

    public void setValorModalidade(double valorModalidade) {
        this.valorModalidade = valorModalidade;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getModalidade() {
        return modalidade;
    }

    public void setModalidade(Integer modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatriculaModalidade != null ? idMatriculaModalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriculamodalidade)) {
            return false;
        }
        Matriculamodalidade other = (Matriculamodalidade) object;
        if ((this.idMatriculaModalidade == null && other.idMatriculaModalidade != null) || (this.idMatriculaModalidade != null && !this.idMatriculaModalidade.equals(other.idMatriculaModalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Matriculamodalidade[ idMatriculaModalidade=" + idMatriculaModalidade + " ]";
    }
    
}
