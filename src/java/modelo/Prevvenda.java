/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMPRESA
 */
@Entity
@Table(name = "prevvenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevvenda.findAll", query = "SELECT p FROM Prevvenda p"),
    @NamedQuery(name = "Prevvenda.findByPrevVendedor", query = "SELECT p FROM Prevvenda p WHERE p.prevVendedor = :prevVendedor"),
    @NamedQuery(name = "Prevvenda.findByPrevCliente", query = "SELECT p FROM Prevvenda p WHERE p.prevCliente = :prevCliente"),
    @NamedQuery(name = "Prevvenda.findByPrevProduto", query = "SELECT p FROM Prevvenda p WHERE p.prevProduto = :prevProduto"),
    @NamedQuery(name = "Prevvenda.findByValorvendaProdutoprevV", query = "SELECT p FROM Prevvenda p WHERE p.valorvendaProdutoprevV = :valorvendaProdutoprevV"),
    @NamedQuery(name = "Prevvenda.findByQuantidade", query = "SELECT p FROM Prevvenda p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Prevvenda.findByTotalPrev", query = "SELECT p FROM Prevvenda p WHERE p.totalPrev = :totalPrev"),
    @NamedQuery(name = "Prevvenda.findById", query = "SELECT p FROM Prevvenda p WHERE p.id = :id"),
    @NamedQuery(name = "Prevvenda.findByValorTotal", query = "SELECT p FROM Prevvenda p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "Prevvenda.findByNotaFiscal", query = "SELECT p FROM Prevvenda p WHERE p.notaFiscal = :notaFiscal"),
    @NamedQuery(name = "Prevvenda.findByDataVenda", query = "SELECT p FROM Prevvenda p WHERE p.dataVenda = :dataVenda"),
    @NamedQuery(name = "Prevvenda.findByValorPago", query = "SELECT p FROM Prevvenda p WHERE p.valorPago = :valorPago"),
    @NamedQuery(name = "Prevvenda.findByTroco", query = "SELECT p FROM Prevvenda p WHERE p.troco = :troco")})
public class Prevvenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "prevVendedor")
    private String prevVendedor;
    @Column(name = "prevCliente")
    private String prevCliente;
    @Column(name = "prevProduto")
    private String prevProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_venda_Produto_prevV")
    private Double valorvendaProdutoprevV;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "totalPrev")
    private Double totalPrev;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "valor_total")
    private Double valorTotal;
    @Column(name = "nota_fiscal")
    private Integer notaFiscal;
    @Basic(optional = false)
    @Column(name = "data_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    @Column(name = "valor_pago")
    private Double valorPago;
    @Column(name = "troco")
    private Double troco;

    public Prevvenda() {
    }

    public Prevvenda(Integer id) {
        this.id = id;
    }

    public Prevvenda(Integer id, Date dataVenda) {
        this.id = id;
        this.dataVenda = dataVenda;
    }

    public String getPrevVendedor() {
        return prevVendedor;
    }

    public void setPrevVendedor(String prevVendedor) {
        this.prevVendedor = prevVendedor;
    }

    public String getPrevCliente() {
        return prevCliente;
    }

    public void setPrevCliente(String prevCliente) {
        this.prevCliente = prevCliente;
    }

    public String getPrevProduto() {
        return prevProduto;
    }

    public void setPrevProduto(String prevProduto) {
        this.prevProduto = prevProduto;
    }

    public Double getValorvendaProdutoprevV() {
        return valorvendaProdutoprevV;
    }

    public void setValorvendaProdutoprevV(Double valorvendaProdutoprevV) {
        this.valorvendaProdutoprevV = valorvendaProdutoprevV;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotalPrev() {
        return totalPrev;
    }

    public void setTotalPrev(Double totalPrev) {
        this.totalPrev = totalPrev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Integer notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
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
        if (!(object instanceof Prevvenda)) {
            return false;
        }
        Prevvenda other = (Prevvenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Prevvenda[ id=" + id + " ]";
    }
    
}
