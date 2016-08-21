/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Carlos
 */
public class MVenda {

    private int idVenda;
    private float valorVenda;
    private int nomeProduto;
    private int nomeCliente;
    private int qtdItem;
    private Date data;
    private String codBarra;
    private int codFunc;

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    /**
     * @param qtdItem the qtdItem to set
     */
    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the codBarra
     */
    public String getCodBarra() {
        return codBarra;
    }

    /**
     * @param codBarra the codBarra to set
     */
    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    /**
     * @return the codFunc
     */
    public int getCodFunc() {
        return codFunc;
    }

    /**
     * @param codFunc the codFunc to set
     */
    public void setCodFunc(int codFunc) {
        this.codFunc = codFunc;
    }

    /**
     * @return the nomeProduto
     */
    public int getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @return the nomeCliente
     */
    public int getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(int nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(int nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
