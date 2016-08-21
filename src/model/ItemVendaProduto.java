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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "item_venda_produto")
@NamedQueries({
    @NamedQuery(name = "ItemVendaProduto.findAll", query = "SELECT i FROM ItemVendaProduto i")})
public class ItemVendaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "quantidade_produto")
    private int quantidadeProduto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "Id_venda", referencedColumnName = "ven_id")
    @ManyToOne
    private Integer idvenda;
    @JoinColumn(name = "Id_produto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Integer idproduto;
    private float valorItem;

    public ItemVendaProduto() {
    }

    public ItemVendaProduto(Integer id) {
        this.id = id;
    }

    public ItemVendaProduto(Integer id, int quantidadeProduto) {
        this.id = id;
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
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
        if (!(object instanceof ItemVendaProduto)) {
            return false;
        }
        ItemVendaProduto other = (ItemVendaProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ItemVendaProduto[ id=" + id + " ]";
    }

    /**
     * @return the valorVenda
     */
    public float getValorItem() {
        return valorItem;
    }

    /**
     * @param valorItem the valorVenda to set
     */
    public void setValorItem(float valorItem) {
        this.valorItem = valorItem;
    }
    
}
