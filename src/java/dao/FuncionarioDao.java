/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author EMPRESA
 */
public class FuncionarioDao implements InterfaceFuncionario {

    private List<Funcionario> listaFuncionariorDao;

    @Override
    public List<Funcionario> getListaFuncionario() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();

        Criteria cri = ss.createCriteria(Funcionario.class);
        this.listaFuncionariorDao = cri.list();
        return this.listaFuncionariorDao;

    }

    @Override
    public void salvar(Funcionario funcionario) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.save(funcionario);
        t.commit();

    }

    @Override
    public void editar(Funcionario funcionario) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.update(funcionario);
        t.commit();
    }

    @Override
    public void excluir(Funcionario funcionario) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        ss.delete(funcionario);
        t.commit();
    }

    @Override
    public Funcionario login(Funcionario func) {
        Funcionario us = null;

        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction t = ss.beginTransaction();
        String hql = "from Funcionario where id = '" + func.getId() + "' and senha ='" + func.getSenha() + "'";

        Query query = ss.createQuery(hql);
             
        if (!query.list().isEmpty()) {
            us = (Funcionario) query.list().get(0);
            t.commit();
        }
        return us;

    }

}
