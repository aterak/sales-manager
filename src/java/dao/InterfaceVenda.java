/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import modelo.Prevvenda;
import modelo.Venda;

/**
 *
 * @author EMPRESA
 */
public interface InterfaceVenda {
      public List<Venda> getListaPrevvenda();
    public void salvar(Venda venda);
     public void editar(Venda venda );
      public void excluir(Venda venda);
      
      public List<Venda>ListaNotas();
      
}
