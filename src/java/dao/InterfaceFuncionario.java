/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Funcionario;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
public interface InterfaceFuncionario {

    public List<Funcionario> getListaFuncionario();

    public void salvar(Funcionario funcionario);

    public void editar(Funcionario funcionario);

    public void excluir(Funcionario funcionario);

    public Funcionario login(Funcionario funcionario);
}
