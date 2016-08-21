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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "tipoutilizador")
@NamedQueries({
    @NamedQuery(name = "Tipoutilizador.findAll", query = "SELECT t FROM Tipoutilizador t")})
public class Tipoutilizador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoutilizador")
    private Integer idTipoutilizador;
    @Basic(optional = false)
    @Column(name = "designacao")
    private String designacao;
    @Basic(optional = false)
    @Lob
    @Column(name = "permissao")
    private String permissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utTipo")
    private Collection<Utilizador> utilizadorCollection;

    public Tipoutilizador() {
    }

    public Tipoutilizador(Integer idTipoutilizador) {
        this.idTipoutilizador = idTipoutilizador;
    }

    public Tipoutilizador(Integer idTipoutilizador, String designacao, String permissao) {
        this.idTipoutilizador = idTipoutilizador;
        this.designacao = designacao;
        this.permissao = permissao;
    }

    public Integer getIdTipoutilizador() {
        return idTipoutilizador;
    }

    public void setIdTipoutilizador(Integer idTipoutilizador) {
        this.idTipoutilizador = idTipoutilizador;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public Collection<Utilizador> getUtilizadorCollection() {
        return utilizadorCollection;
    }

    public void setUtilizadorCollection(Collection<Utilizador> utilizadorCollection) {
        this.utilizadorCollection = utilizadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoutilizador != null ? idTipoutilizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoutilizador)) {
            return false;
        }
        Tipoutilizador other = (Tipoutilizador) object;
        if ((this.idTipoutilizador == null && other.idTipoutilizador != null) || (this.idTipoutilizador != null && !this.idTipoutilizador.equals(other.idTipoutilizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipoutilizador[ idTipoutilizador=" + idTipoutilizador + " ]";
    }
    
}
