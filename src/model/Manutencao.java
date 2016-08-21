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
import javax.persistence.Lob;
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
@Table(name = "manutencao")
@NamedQueries({
    @NamedQuery(name = "Manutencao.findAll", query = "SELECT m FROM Manutencao m")})
public class Manutencao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idManutencao")
    private Integer idManutencao;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Lob
    @Column(name = "obs")
    private String obs;
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")
    @ManyToOne(optional = false)
    private Equipamento idEquipamento;

    public Manutencao() {
    }

    public Manutencao(Integer idManutencao) {
        this.idManutencao = idManutencao;
    }

    public Manutencao(Integer idManutencao, Date data, String obs) {
        this.idManutencao = idManutencao;
        this.data = data;
        this.obs = obs;
    }

    public Integer getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Integer idManutencao) {
        this.idManutencao = idManutencao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Equipamento getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManutencao != null ? idManutencao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutencao)) {
            return false;
        }
        Manutencao other = (Manutencao) object;
        if ((this.idManutencao == null && other.idManutencao != null) || (this.idManutencao != null && !this.idManutencao.equals(other.idManutencao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Manutencao[ idManutencao=" + idManutencao + " ]";
    }
    
}
