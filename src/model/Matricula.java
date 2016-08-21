/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "matricula")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatricula")
    private Integer idMatricula;
    @Basic(optional = false)
    @Column(name = "mat_data")
    @Temporal(TemporalType.DATE)
    private Date matData;
    @Basic(optional = false)
    @Column(name = "valorTotal")
    private double valorTotal;
    @JoinColumn(name = "idCliente", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Integer pessoa;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "ut_IdUtilizador")
    @ManyToOne
    private Integer utilizador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<Matriculamodalidade> matriculamodalidadeCollection;

    public Matricula() {
    }

    public Matricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Matricula(Integer idMatricula, Date matData, double valorTotal) {
        this.idMatricula = idMatricula;
        this.matData = matData;
        this.valorTotal = valorTotal;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getMatData() {
        return matData;
    }

    public void setMatData(Date matData) {
        this.matData = matData;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getPessoa() {
        return pessoa;
    }

    public void setPessoa(Integer pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Integer utilizador) {
        this.utilizador = utilizador;
    }

    public Collection<Matriculamodalidade> getMatriculamodalidadeCollection() {
        return matriculamodalidadeCollection;
    }

    public void setMatriculamodalidadeCollection(Collection<Matriculamodalidade> matriculamodalidadeCollection) {
        this.matriculamodalidadeCollection = matriculamodalidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Matricula[ idMatricula=" + idMatricula + " ]";
    }
    
}
