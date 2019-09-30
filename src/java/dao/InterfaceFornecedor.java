/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Fornecedor;

/**
 *
 * @author EMPRESA
 */
public interface InterfaceFornecedor {
      public List<Fornecedor> getListaFornecedor();
    public void salvar(Fornecedor fornecedor);
     public void editar(Fornecedor fornecedor );
      public void excluir(Fornecedor fornecedor);
      
}
