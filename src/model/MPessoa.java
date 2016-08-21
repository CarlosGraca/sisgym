/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class MPessoa {
    private int idPessoa;
    private String nome;
    private Date dtNasc;
    private int sexo;
    private String bi;
    private String nif;
    private String email;
    private String morada;
    private String cp;
    private String telemovel;
    private String telfCasa;
    private String profissao;
    private String localTrab;
    private String telfTrab;
    private String encaEdu;
    private String obs;
    private String codBarra;
    private int status;
    private byte[] foto;
    private Date dtreg;
    private int tipoPessoa;
    private int idFuncionario;

    public MPessoa(int idPessoa, String nome, Date dtNasc, int sexo, String bi, String nif, String email, String morada, String cp, String telemovel, String telfCasa, String profissao, String localTrab, String telfTrab, String encaEdu, String obs, String codBarra, int status, byte[] foto, Date dtreg, int tipoPessoa, int idFuncionario) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.bi = bi;
        this.nif = nif;
        this.email = email;
        this.morada = morada;
        this.cp = cp;
        this.telemovel = telemovel;
        this.telfCasa = telfCasa;
        this.profissao = profissao;
        this.localTrab = localTrab;
        this.telfTrab = telfTrab;
        this.encaEdu = encaEdu;
        this.obs = obs;
        this.codBarra = codBarra;
        this.status = status;
        this.foto = foto;
        this.dtreg = dtreg;
        this.tipoPessoa = tipoPessoa;
        this.idFuncionario = idFuncionario;
    }

    public MPessoa() {
    }

    public MPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "MPessoa{" + "idPessoa=" + idPessoa + ", nome=" + nome + ", dtNasc=" + dtNasc + ", sexo=" + sexo + ", bi=" + bi + ", nif=" + nif + ", email=" + email + ", morada=" + morada + ", cp=" + cp + ", telemovel=" + telemovel + ", telfCasa=" + telfCasa + ", profissao=" + profissao + ", localTrab=" + localTrab + ", telfTrab=" + telfTrab + ", encaEdu=" + encaEdu + ", obs=" + obs + ", codBarra=" + codBarra + ", status=" + status + ", foto=" + foto + ", dtreg=" + dtreg + ", tipoPessoa=" + tipoPessoa + ", idFuncionario=" + idFuncionario + '}';
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
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

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    
}
