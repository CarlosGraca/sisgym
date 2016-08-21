/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

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

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "modalidade")
@NamedQueries({
    @NamedQuery(name = "Modalidade.findAll", query = "SELECT m FROM Modalidade m")})
public class Modalidade implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModalidade")
    private Collection<Matriculamodalidade> matriculamodalidadeCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idModalidade")
    private Integer idModalidade;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModalidade")
    private Collection<Horario> horarioCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModalidade")
   // private Collection<Matricula> matriculaCollection;

    public Modalidade() {
    }

    public Modalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    
    public Modalidade(Integer idModalidade, double valor, String nome) {
        this.idModalidade = idModalidade;
        this.valor = valor;
        this.nome = nome;
    }

    public Integer getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

//    public Collection<Matricula> getMatriculaCollection() {
//        return matriculaCollection;
//    }
//
//    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
//        this.matriculaCollection = matriculaCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModalidade != null ? idModalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidade)) {
            return false;
        }
        Modalidade other = (Modalidade) object;
        if ((this.idModalidade == null && other.idModalidade != null) || (this.idModalidade != null && !this.idModalidade.equals(other.idModalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Modalidade[ idModalidade=" + idModalidade + " ]";
    }

    public Collection<Matriculamodalidade> getMatriculamodalidadeCollection() {
        return matriculamodalidadeCollection;
    }

    public void setMatriculamodalidadeCollection(Collection<Matriculamodalidade> matriculamodalidadeCollection) {
        this.matriculamodalidadeCollection = matriculamodalidadeCollection;
    }
    
}
