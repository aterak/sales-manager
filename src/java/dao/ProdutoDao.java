/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class ProdutoDao implements InterfaceProduto{
  private List<Produto> listaProdutoDao;

    @Override
    public List<Produto> getListaProduto() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();

        Criteria cri = ss.createCriteria(Produto.class);
        this.listaProdutoDao = cri.list();
        return this.listaProdutoDao;

    }

    @Override
    public void salvar(Produto produto) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(produto);
        t.commit();

    }

    @Override
    public void editar(Produto produto) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.update(produto);
        t.commit();
    }

    @Override
    public void excluir(Produto produto) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.delete(produto);
        t.commit();
    }
  
}
