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
@Table(name = "nivel_acesso")
@NamedQueries({
    @NamedQuery(name = "NivelAcesso.findAll", query = "SELECT n FROM NivelAcesso n")})
public class NivelAcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ni_Cod_Utilizador")
    private int niCodUtilizador;
    @Basic(optional = false)
    @Column(name = "ni_menu")
    private String niMenu;

    public NivelAcesso() {
    }

    public NivelAcesso(Integer id) {
        this.id = id;
    }

    public NivelAcesso(Integer id, int niCodUtilizador, String niMenu) {
        this.id = id;
        this.niCodUtilizador = niCodUtilizador;
        this.niMenu = niMenu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNiCodUtilizador() {
        return niCodUtilizador;
    }

    public void setNiCodUtilizador(int niCodUtilizador) {
        this.niCodUtilizador = niCodUtilizador;
    }

    public String getNiMenu() {
        return niMenu;
    }

    public void setNiMenu(String niMenu) {
        this.niMenu = niMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcesso)) {
            return false;
        }
        NivelAcesso other = (NivelAcesso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.NivelAcesso[ id=" + id + " ]";
    }
    
}
