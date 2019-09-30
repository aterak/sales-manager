/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FornecedorDao;
import dao.InterfaceFornecedor;
import dao.InterfaceProduto;
import dao.ProdutoDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import modelo.Fornecedor;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
@Named(value = "fornecedorBean")
@SessionScoped
@ManagedBean
public class FornecedorBean implements Serializable {

    /**
     * Creates a new instance of ProdutoBean
     */
    public FornecedorBean() {
    }
    private List<Fornecedor> listaFornecedorBean;
    private Fornecedor fornecedor = new Fornecedor();

    public List<Fornecedor> getListaFornecedorBean() {

        listaFornecedorBean = new FornecedorDao().getListaFornecedor();
        return listaFornecedorBean;
    }

    public void setListaFornecedorBean(List<Fornecedor> listaFornecedorBean) {
        this.listaFornecedorBean = listaFornecedorBean;
    }

    public Fornecedor getFornecedor() {
        if (fornecedor == null) {

            fornecedor = new Fornecedor();
        }

        return fornecedor;
    }
    
    
    public void prepararEdita(Fornecedor u){
    
    fornecedor = u;
    
    
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String incluirFornecedor() {
        InterfaceFornecedor dao = new FornecedorDao();
        if (fornecedor.getId() == null) {

            dao.salvar(fornecedor);
        } else {
            dao.editar(fornecedor);
        }

        limparCampos();

        return "fornecedor";

    }

    public void salvar() {

        InterfaceFornecedor dao = new FornecedorDao();
        dao.salvar(fornecedor);
limparCampos();
    }

    public String excluir(Fornecedor u) {
        this.fornecedor = u;
        InterfaceFornecedor dao = new FornecedorDao();
        dao.excluir(fornecedor);
        limparCampos();
        return "fornecedor";
    }


    public void aterar() {

        InterfaceFornecedor dao = new FornecedorDao();
        dao.editar(fornecedor);
limparCampos();
    }

    public int tamanho() {

        //listaUsuarioBean = new UsuarioDao().getListaUsuario();
        return listaFornecedorBean.size();// assim da certo para ver o tamanho da lista

    }

    public void limparCampos() {

        fornecedor.setBairro(null);
        fornecedor.setCel(null);
        fornecedor.setCep(null);
        fornecedor.setCgc(null);
        fornecedor.setCidade(null);
        fornecedor.setId(null); 
        fornecedor.setCpf(null);
        fornecedor.setDetalhe(null);
        fornecedor.setEmail(null);
        fornecedor.setEndereco(null);
        fornecedor.setEstado(null);
        fornecedor.setNome(null);
        fornecedor.setProduto(null);
        fornecedor.setTel(null);

    }

}
