/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.FuncionarioDao;
import dao.InterfaceFuncionario;
import dao.InterfaceProduto;
import dao.ProdutoDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import modelo.Funcionario;


/**
 *
 * @author EMPRESA
 */
@Named(value = "funcionarioBean")
@SessionScoped
@ManagedBean
public class FuncionarioBean implements Serializable {

    /**
     * Creates a new instance of ProdutoBean
     */
    public FuncionarioBean() {
    }
     private List<Funcionario> listaFuncionarioBean;
     private Funcionario funcionario = new Funcionario();

    public List<Funcionario> getListaFuncionarioBean() {
      
          listaFuncionarioBean = new FuncionarioDao().getListaFuncionario();
        return listaFuncionarioBean;
    }

    public void setListaFuncionarioBean(List<Funcionario> listaFuncionarioBean) {
        this.listaFuncionarioBean = listaFuncionarioBean;
    }

    public Funcionario getFuncionarios() {
        if(funcionario == null){
        
        funcionario = new Funcionario();
        }
        
        return funcionario;
    }

    public void setCliente(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
    
     public String prepararEdita(Funcionario u) {

        funcionario = u;

       return "funcionario";

    }
    
     public String incluirFuncionario(){
    InterfaceFuncionario dao = new FuncionarioDao();
    if(funcionario.getId()==null){
        
         dao.salvar(funcionario);
         
    }else
        
        dao.editar(funcionario);
     
        limparCampos();
      
    return "funcionario";
    
    } 
    
    
    
    
    
    
    public void salvar() {

              InterfaceFuncionario dao = new FuncionarioDao();
                  dao.salvar(funcionario);
              limparCampos();
     

    }

    public String excluir(Funcionario u) {
        this.funcionario = u;
       InterfaceFuncionario dao = new FuncionarioDao();
        dao.excluir(funcionario);
           return "funcionario";
    }

    

    public void aterar() {

        InterfaceFuncionario dao = new FuncionarioDao();
        dao.editar(funcionario);

       
    }
    
     public int tamanho() {

        //listaUsuarioBean = new UsuarioDao().getListaUsuario();
        return listaFuncionarioBean.size();// assim da certo para ver o tamanho da lista

    }
     
        public void limparCampos(){
     
        funcionario.setBairro(null);
       funcionario.setCel(null);
        funcionario.setCep(null);
        funcionario.setCidade(null);
        funcionario.setId(null);
        funcionario.setCpf(null);
        funcionario.setDataNasc(null);
        funcionario.setEstadocivil(null);
        funcionario.setEmail(null);
        funcionario.setEndereco(null);
        funcionario.setEstado(null);
        funcionario.setIdent(null);
        funcionario.setNome(null);
        funcionario.setSexo(null);
        funcionario.setTelCont(null);
        funcionario.setTel(null);
        
        
        
        }
}
