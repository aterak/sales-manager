/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.VendaDao;
import dao.ProdutoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import modelo.Prevvenda;
import modelo.Produto;
import modelo.Venda;

/**
 *
 * @author EMPRESA
 */
@Named(value = "vendaBean")
@SessionScoped
public class VendaBean implements Serializable {

    /**
     * Creates a new instance of VendaBean
     */
    public VendaBean() {
      
    }
    
    
    
    private Produto produtos = new Produto();//ok
    private Venda venda = new Venda();//ok
    private List<Produto> listaProdutos = new ArrayList();//ok
    private List<Venda> listaProdutosVendidos = new ArrayList();//ok
    private List<Venda> carrinhoCompras = new ArrayList();//ok
    private double valorTotal = 0;//ok
    private int quantidadeItens = 0;//ok
    private int ultimaNota=0;
    
    
     
    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    
     public double getValorTotal() {

        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public List<Produto> getListaProdutos() {
      
        listaProdutos = new ProdutoDao().getListaProduto();
        return listaProdutos;
    }

    public List<Venda> getListaProdutosVendidos() {
        listaProdutosVendidos = new VendaDao().getListaPrevvenda();
        return listaProdutosVendidos;
    }

    public List<Venda> getCarrinhoCompras() {
        return carrinhoCompras;
    }
    
   
    

   //-------------------------------------------------------------------------------------------------------------------//
    public void incluirCarrinho(Produto p) {
        //UltimaNotaFiscal();

        String n = p.getNome();
        Double va = p.getValor();
        int quntidade = venda.getQuantidade();

        Venda prev = new Venda();

        prev.setQuantidade(quntidade);
        //prev.setId(1);// aqui esta setando pois no  venda esta null
        prev.setQuantidade(quntidade);//ok
        prev.setValorvendaProdutoprevV(va);//ok

        double totalPrev = (quntidade * (va));
        prev.setTotalPrev(totalPrev);//ok

       // double valorTotal2 = totalPrev;

      //  prev.setPrevVendedor("vendedor1");
      //  prev.setPrevCliente("cliente1");
        prev.setPrevProduto(n);//ok

       // prev.setValorTotal(totalPrev);//ok   

        carrinhoCompras.add(prev);
        calculaTotal(); // calcula o total Geral

        venda.setQuantidade(null);

         getUltimaNota();
        
        
    }
     private void calculaTotal() {

        valorTotal = 0;

        for (Venda p : carrinhoCompras) {

            valorTotal += p.getTotalPrev();

       }
    }


     public void retirarCarrinho(Venda s) {

        carrinhoCompras.remove(s);

        calculaTotal();

    }

    public void limparCarrinho() {

        carrinhoCompras.clear();
        calculaTotal();
    }


     public int tamanho() {

        quantidadeItens = 0;
        for (Venda v : carrinhoCompras) {
            quantidadeItens += v.getQuantidade();// assim da certo para ver o tamanho da lista
        }
        return quantidadeItens;
    }
    
    
    public String realizarvenda() {
        ArrayList<Venda> listaVendaRealizada = new ArrayList<>();
                 
        for (Venda prevvenda1 : carrinhoCompras) {//PERCORRO TODO CARRINHO
            prevvenda1.setValorTotal(valorTotal);//seto o valor total gerAL PARA TODOS OS PRODUTOS
            prevvenda1.setDataVenda(new Date());
            prevvenda1.setNotaFiscal(getUltimaNota());
            listaVendaRealizada.add(prevvenda1); // ADICIONO TODOS ITENS DO CARRINHO
        }

        for (Venda prevvendafim : listaVendaRealizada) { //PERCORRO TODA LISTA FINAL 

            VendaDao dao = new VendaDao();
            dao.salvar(prevvendafim);         // SALVO GERAL

        }

        limparCarrinho();

        venda.setValorTotal(null);
        venda.setPrevCliente(null);
        venda.setPrevVendedor(null);
         
        
        getUltimaNota();
        
        
        return "venda";
    }

    
    // aqui eu pego a ultima nota
    public int getUltimaNota() {
        
         listaProdutosVendidos = new VendaDao().getListaPrevvenda();
        
        ultimaNota = 0;
        for (Venda v : listaProdutosVendidos) {
            ultimaNota = 1 + v.getNotaFiscal();// assim da certo para ver o tamanho da lista
        }
        return ultimaNota;
    }

    public void setUltimaNota(int ultimaNota) {
        this.ultimaNota = ultimaNota;
    }

    
    
   
     
    
}
