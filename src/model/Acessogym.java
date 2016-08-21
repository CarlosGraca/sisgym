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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */
@MappedSuperclass
@Table(name = "acessogym")
public class Acessogym implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAcessoGym")
    private Integer idAcessoGym;
    @Basic(optional = false)
    @Column(name = "horaEntrada")
    private String horaEntrada;
    @Basic(optional = false)
    @Column(name = "horaSaida")
    @Temporal(TemporalType.TIME)
    private Date horaSaida;
    @Basic(optional = false)
    @Column(name = "idCliente")
    private int idCliente;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Acessogym() {
    }

    public Acessogym(Integer idAcessoGym) {
        this.idAcessoGym = idAcessoGym;
    }

    public Acessogym(Integer idAcessoGym, String horaEntrada, Date horaSaida, int idCliente, Date data) {
        this.idAcessoGym = idAcessoGym;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.idCliente = idCliente;
        this.data = data;
    }

    public Integer getIdAcessoGym() {
        return idAcessoGym;
    }

    public void setIdAcessoGym(Integer idAcessoGym) {
        this.idAcessoGym = idAcessoGym;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcessoGym != null ? idAcessoGym.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acessogym)) {
            return false;
        }
        Acessogym other = (Acessogym) object;
        if ((this.idAcessoGym == null && other.idAcessoGym != null) || (this.idAcessoGym != null && !this.idAcessoGym.equals(other.idAcessoGym))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Acessogym[ idAcessoGym=" + idAcessoGym + " ]";
    }
    
}
