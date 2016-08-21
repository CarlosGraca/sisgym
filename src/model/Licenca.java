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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "licenca")
@NamedQueries({
    @NamedQuery(name = "Licenca.findAll", query = "SELECT l FROM Licenca l")})
public class Licenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLicenca")
    private Integer idLicenca;
    @Basic(optional = false)
    @Column(name = "dataInicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @Column(name = "dataFim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "mac")
    private String mac;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public Licenca() {
    }

    public Licenca(Integer idLicenca) {
        this.idLicenca = idLicenca;
    }

    public Licenca(Integer idLicenca, Date dataInicio, Date dataFim, String codigo, String mac) {
        this.idLicenca = idLicenca;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.codigo = codigo;
        this.mac = mac;
    }

    public Integer getIdLicenca() {
        return idLicenca;
    }

    public void setIdLicenca(Integer idLicenca) {
        this.idLicenca = idLicenca;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicenca != null ? idLicenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licenca)) {
            return false;
        }
        Licenca other = (Licenca) object;
        if ((this.idLicenca == null && other.idLicenca != null) || (this.idLicenca != null && !this.idLicenca.equals(other.idLicenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Licenca[ idLicenca=" + idLicenca + " ]";
    }
    
}
