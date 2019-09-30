/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Fornecedor;
import modelo.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class FornecedorDao implements InterfaceFornecedor{
  private List<Fornecedor> listaFornecedorDao;

    @Override
    public List<Fornecedor> getListaFornecedor() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();

        Criteria cri = ss.createCriteria(Fornecedor.class);
        this.listaFornecedorDao = cri.list();
        return this.listaFornecedorDao;

    }

    @Override
    public void salvar(Fornecedor fornecedor) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(fornecedor);
        t.commit();

    }

    @Override
    public void editar(Fornecedor fornecedor) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.update(fornecedor);
        t.commit();
    }

    @Override
    public void excluir(Fornecedor fornecedor) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.delete(fornecedor);
        t.commit();
    }
  
}
