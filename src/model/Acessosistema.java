/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "acessosistema")
@NamedQueries({
    @NamedQuery(name = "Acessosistema.findAll", query = "SELECT a FROM Acessosistema a")})
public class Acessosistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAcessoSis")
    private Integer idAcessoSis;
    @Basic(optional = false)
    @Column(name = "login")
    private int login;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "horaEntrada")
    @Temporal(TemporalType.TIME)
    private String horaEntrada;
    @Basic(optional = false)
    @Column(name = "acao")
    private String acao;
  
    public Acessosistema() {
    }

    public Acessosistema(Integer idAcessoSis) {
        this.idAcessoSis = idAcessoSis;
    }

    public Acessosistema(Integer idAcessoSis, int login, Date data, String horaEntrada, String acao) {
        this.idAcessoSis = idAcessoSis;
        this.login = login;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.acao = acao;
    }

    public Integer getIdAcessoSis() {
        return idAcessoSis;
    }

    public void setIdAcessoSis(Integer idAcessoSis) {
        this.idAcessoSis = idAcessoSis;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcessoSis != null ? idAcessoSis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acessosistema)) {
            return false;
        }
        Acessosistema other = (Acessosistema) object;
        if ((this.idAcessoSis == null && other.idAcessoSis != null) || (this.idAcessoSis != null && !this.idAcessoSis.equals(other.idAcessoSis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acessosistema[ idAcessoSis=" + idAcessoSis + " ]";
    }
    
}
