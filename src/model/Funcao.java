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
@Table(name = "funcao")
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f")})
public class Funcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncao")
    private Integer idFuncao;
    @Basic(optional = false)
    @Column(name = "designacao")
    private String designacao;
    @Basic(optional = false)
    @Column(name = "salario")
    private int salario;
    @Basic(optional = false)
    @Column(name = "fun_entrada")
    @Temporal(TemporalType.DATE)
    private Date funEntrada;
    @Basic(optional = false)
    @Column(name = "fun_saida")
    @Temporal(TemporalType.DATE)
    private Date funSaida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcao")
    private Collection<Pessoa> pessoaCollection;

    public Funcao() {
    }

    public Funcao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Funcao(Integer idFuncao, String designacao, int salario, Date funEntrada, Date funSaida) {
        this.idFuncao = idFuncao;
        this.designacao = designacao;
        this.salario = salario;
        this.funEntrada = funEntrada;
        this.funSaida = funSaida;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Date getFunEntrada() {
        return funEntrada;
    }

    public void setFunEntrada(Date funEntrada) {
        this.funEntrada = funEntrada;
    }

    public Date getFunSaida() {
        return funSaida;
    }

    public void setFunSaida(Date funSaida) {
        this.funSaida = funSaida;
    }

    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncao != null ? idFuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.idFuncao == null && other.idFuncao != null) || (this.idFuncao != null && !this.idFuncao.equals(other.idFuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcao[ idFuncao=" + idFuncao + " ]";
    }
    
}
