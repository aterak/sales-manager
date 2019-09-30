/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Prevvenda;
import modelo.Venda;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class VendaDao implements InterfaceVenda {

    private List<Venda> listaVendaDao;

    @Override
    public List<Venda> getListaPrevvenda() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();

        Criteria cri = ss.createCriteria(Venda.class);
        this.listaVendaDao = cri.list();
        return this.listaVendaDao;

    }

    @Override
    public void salvar(Venda prevvenda) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(prevvenda);
        t.commit();

    }

    @Override
    public void editar(Venda prevvenda) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.update(prevvenda);
        t.commit();
    }

    @Override
    public void excluir(Venda prevvenda) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.delete(prevvenda);
        t.commit();
    }

    
    
    public List<Venda> ListaPrevvendaNotaFiscal() {
        int     nota;

        List<Venda> resultado = new ArrayList<Venda>();
        
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();

        Criteria cri = ss.createCriteria(Venda.class);
        cri = cri.addOrder(Order.asc("nota_fiscal"));
 
        
        
        System.out.println("resultado" + resultado);
    return resultado = cri.list();

     //   return resultado;
     //   for (Venda p : resultado) {
   //     nota = p.getNotaFiscal();
      
     // }
       
       
    }

    @Override
    public List<Venda> ListaNotas() {
   
        
        List<Venda> resultado = new ArrayList<Venda>();
       
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();

        Criteria cri = ss.createCriteria(Venda.class);
       // cri = cri.addOrder(Order.asc("nota_fiscal"));

        resultado = cri.list();

        
        System.out.println("resultado" + resultado);
        return resultado;    
    
    }

}
