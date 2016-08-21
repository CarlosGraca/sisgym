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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos
 */

@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPessoa")
    private Integer idPessoa;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "dtNasc")
    @Temporal(TemporalType.DATE)
    private Date dtNasc;
    @Basic(optional = false)
    @Column(name = "sexo")
    private int sexo;
    @Column(name = "bi")
    private String bi;
    @Column(name = "nif")
    private String nif;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "morada")
    private String morada;
    @Column(name = "cp")
    private String cp;
    @Basic(optional = false)
    @Column(name = "telemovel")
    private String telemovel;
    @Column(name = "telfCasa")
    private String telfCasa;
    @Column(name = "profissao")
    private String profissao;
    @Lob
    @Column(name = "localTrab")
    private String localTrab;
    @Column(name = "telfTrab")
    private String telfTrab;
    @Column(name = "encaEdu")
    private String encaEdu;
    @Lob
    @Column(name = "obs")
    private String obs;
    @Basic(optional = false)
    @Column(name = "codBarra")
    private String codBarra;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "dtreg")
    @Temporal(TemporalType.DATE)
    private Date dtreg;
    @Column(name = "tipoPessoa")
    private Integer tipoPessoa;
    @Column(name = "idFuncionario")
    private int idFuncionario;
    private int idMes;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(Integer idPessoa, String nome, int sexo, String email, String morada, String telemovel, String codBarra, int status) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.morada = morada;
        this.telemovel = telemovel;
        this.codBarra = codBarra;
        this.status = status;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getTelfCasa() {
        return telfCasa;
    }

    public void setTelfCasa(String telfCasa) {
        this.telfCasa = telfCasa;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getLocalTrab() {
        return localTrab;
    }

    public void setLocalTrab(String localTrab) {
        this.localTrab = localTrab;
    }

    public String getTelfTrab() {
        return telfTrab;
    }

    public void setTelfTrab(String telfTrab) {
        this.telfTrab = telfTrab;
    }

    public String getEncaEdu() {
        return encaEdu;
    }

    public void setEncaEdu(String encaEdu) {
        this.encaEdu = encaEdu;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getDtreg() {
        return dtreg;
    }

    public void setDtreg(Date dtreg) {
        this.dtreg = dtreg;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pessoa[ idPessoa=" + idPessoa + " ]";
    }
    
}
