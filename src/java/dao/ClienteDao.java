/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class ClienteDao implements InterfaceCliente {

    private List<Cliente> listaClienteDao;

    @Override
    public List<Cliente> getListaCliente() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();

        Criteria cri = ss.createCriteria(Cliente.class);
        this.listaClienteDao = cri.list();
        return this.listaClienteDao;

    }

    @Override
    public void salvar(Cliente cliente) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(cliente);
        t.commit();

    }

    @Override
    public void editar(Cliente cliente) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.update(cliente);
        t.commit();
    }

    @Override
    public void excluir(Cliente cliente) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.delete(cliente);
        t.commit();
    }

 
   
}
