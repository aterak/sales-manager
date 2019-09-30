/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
public interface InterfaceProduto {
      public List<Produto> getListaProduto();
    public void salvar(Produto produto);
     public void editar(Produto produto );
      public void excluir(Produto produto);
      
}
