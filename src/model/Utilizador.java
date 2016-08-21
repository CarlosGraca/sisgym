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
@Table(name = "utilizador")
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u")})
public class Utilizador implements Serializable {
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<Matricula> matriculaCollection;
    @JoinColumn(name = "ut_tipoUtilizador", referencedColumnName = "idTipoutilizador")
    @ManyToOne
    private Tipoutilizador uttipoUtilizador;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ut_IdUtilizador")
    private Integer utIdUtilizador;
    @Basic(optional = false)
    @Column(name = "ut_login")
    private String utLogin;
    @Basic(optional = false)
    @Column(name = "ut_senha")
    private String utSenha;
    @Basic(optional = false)
    @Column(name = "ut_nome")
    private String utNome;
    @Basic(optional = false)
    @Column(name = "ut_dtReg")
    @Temporal(TemporalType.DATE)
    private Date utdtReg;
    @Basic(optional = false)
    @Column(name = "ut_dtUltimaVisita")
    @Temporal(TemporalType.DATE)
    private Date utdtUltimaVisita;
    @Basic(optional = false)
    @Column(name = "ut_status")
    private int utStatus;
    @JoinColumn(name = "ut_tipoUtilzador", referencedColumnName = "idTipoutilizador")
    @ManyToOne
    private Integer uttipoUtilzador;

    public Utilizador() {
    }

    public Utilizador(Integer utIdUtilizador) {
        this.utIdUtilizador = utIdUtilizador;
    }

    public Utilizador(Integer utIdUtilizador, String utLogin, String utSenha, String utNome, Date utdtReg, Date utdtUltimaVisita, int utStatus) {
        this.utIdUtilizador = utIdUtilizador;
        this.utLogin = utLogin;
        this.utSenha = utSenha;
        this.utNome = utNome;
        this.utdtReg = utdtReg;
        this.utdtUltimaVisita = utdtUltimaVisita;
        this.utStatus = utStatus;
    }

    public Integer getUtIdUtilizador() {
        return utIdUtilizador;
    }

    public void setUtIdUtilizador(Integer utIdUtilizador) {
        this.utIdUtilizador = utIdUtilizador;
    }

    public String getUtLogin() {
        return utLogin;
    }

    public void setUtLogin(String utLogin) {
        this.utLogin = utLogin;
    }

    public String getUtSenha() {
        return utSenha;
    }

    public void setUtSenha(String utSenha) {
        this.utSenha = utSenha;
    }

    public String getUtNome() {
        return utNome;
    }

    public void setUtNome(String utNome) {
        this.utNome = utNome;
    }

    public Date getUtdtReg() {
        return utdtReg;
    }

    public void setUtdtReg(Date utdtReg) {
        this.utdtReg = utdtReg;
    }

    public Date getUtdtUltimaVisita() {
        return utdtUltimaVisita;
    }

    public void setUtdtUltimaVisita(Date utdtUltimaVisita) {
        this.utdtUltimaVisita = utdtUltimaVisita;
    }

    public int getUtStatus() {
        return utStatus;
    }

    public void setUtStatus(int utStatus) {
        this.utStatus = utStatus;
    }

    public int getUttipoUtilzador() {
        return uttipoUtilzador;
    }

    public void setUttipoUtilzador(int uttipoUtilzador) {
        this.uttipoUtilzador = uttipoUtilzador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utIdUtilizador != null ? utIdUtilizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.utIdUtilizador == null && other.utIdUtilizador != null) || (this.utIdUtilizador != null && !this.utIdUtilizador.equals(other.utIdUtilizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Utilizador[ utIdUtilizador=" + utIdUtilizador + " ]";
    }

    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    public Tipoutilizador getUttipoUtilizador() {
        return uttipoUtilizador;
    }

    public void setUttipoUtilizador(Tipoutilizador uttipoUtilizador) {
        this.uttipoUtilizador = uttipoUtilizador;
    }
    
}
