/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author EMPRESA
 */
public interface InterfaceCliente {

    public List<Cliente> getListaCliente();

    public void salvar(Cliente cliente);

    public void editar(Cliente cliente);

    public void excluir(Cliente cliente);

}
