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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "servidor_email")
@NamedQueries({
    @NamedQuery(name = "ServidorEmail.findAll", query = "SELECT s FROM ServidorEmail s")})
public class ServidorEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ser_idServidor")
    private Integer seridServidor;
    @Basic(optional = false)
    @Column(name = "ser_smtp")
    private String serSmtp;
    @Basic(optional = false)
    @Column(name = "ser_porta")
    private int serPorta;
    @Basic(optional = false)
    @Column(name = "ser_email")
    private String serEmail;
    @Basic(optional = false)
    @Column(name = "ser_senha")
    private String serSenha;
    @Basic(optional = false)
    @Lob
    @Column(name = "ser_assinatura")
    private String serAssinatura;

    public ServidorEmail() {
    }

    public ServidorEmail(Integer seridServidor) {
        this.seridServidor = seridServidor;
    }

    public ServidorEmail(Integer seridServidor, String serSmtp, int serPorta, String serEmail, String serSenha, String serAssinatura) {
        this.seridServidor = seridServidor;
        this.serSmtp = serSmtp;
        this.serPorta = serPorta;
        this.serEmail = serEmail;
        this.serSenha = serSenha;
        this.serAssinatura = serAssinatura;
    }

    public Integer getSeridServidor() {
        return seridServidor;
    }

    public void setSeridServidor(Integer seridServidor) {
        this.seridServidor = seridServidor;
    }

    public String getSerSmtp() {
        return serSmtp;
    }

    public void setSerSmtp(String serSmtp) {
        this.serSmtp = serSmtp;
    }

    public int getSerPorta() {
        return serPorta;
    }

    public void setSerPorta(int serPorta) {
        this.serPorta = serPorta;
    }

    public String getSerEmail() {
        return serEmail;
    }

    public void setSerEmail(String serEmail) {
        this.serEmail = serEmail;
    }

    public String getSerSenha() {
        return serSenha;
    }

    public void setSerSenha(String serSenha) {
        this.serSenha = serSenha;
    }

    public String getSerAssinatura() {
        return serAssinatura;
    }

    public void setSerAssinatura(String serAssinatura) {
        this.serAssinatura = serAssinatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seridServidor != null ? seridServidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServidorEmail)) {
            return false;
        }
        ServidorEmail other = (ServidorEmail) object;
        if ((this.seridServidor == null && other.seridServidor != null) || (this.seridServidor != null && !this.seridServidor.equals(other.seridServidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ServidorEmail[ seridServidor=" + seridServidor + " ]";
    }
    
}
