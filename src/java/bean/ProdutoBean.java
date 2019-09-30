/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.InterfaceProduto;
import dao.ProdutoDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
@Named(value = "produtoBean")
@SessionScoped
@ManagedBean
public class ProdutoBean implements Serializable {

    /**
     * Creates a new instance of ProdutoBean
     */
    public ProdutoBean() {
    }
    private List<Produto> listaProdutoBean;
    private Produto produto = new Produto();

    public List<Produto> getListaProdutoBean() {

        listaProdutoBean = new ProdutoDao().getListaProduto();
        return listaProdutoBean;
    }

    public void setListaProdutoBean(List<Produto> listaProdutoBean) {
        this.listaProdutoBean = listaProdutoBean;
    }

    public Produto getProduto() {
        if (produto == null) {

            produto = new Produto();
        }

        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String incluirProduto() {
        InterfaceProduto dao = new ProdutoDao();
        if (produto.getId() == null) {

            dao.salvar(produto);
            limparCampos();
        } else {
            dao.editar(produto);
            limparCampos();
        }

        limparCampos();

       return "produto";

    }

    public void salvar() {

        InterfaceProduto dao = new ProdutoDao();
        dao.salvar(produto);
        limparCampos();
    }

    public String excluir(Produto u) {
        this.produto = u;
        InterfaceProduto dao = new ProdutoDao();
        dao.excluir(produto);
         limparCampos();
        return "produto";
    }

    public String prepararEdita(Produto c) {

        produto = c;

        return "produto";

    }

    public void aterar() {

        InterfaceProduto dao = new ProdutoDao();
        dao.editar(produto);
         limparCampos();
    }

    public int tamanho() {

        //listaUsuarioBean = new UsuarioDao().getListaUsuario();
        return listaProdutoBean.size();// assim da certo para ver o tamanho da lista

    }

    public void limparCampos() {

        produto.setId(null);
        produto.setCodigoInter(null);
        produto.setFornecedor(null);
        produto.setNome(null);
        produto.setValor(null);
        produto.setPcusto(null);
        produto.setEstoqueMinimo(null);
        produto.setQuant(null);
    }

    
    
    
    
    
    
    
    
    
    
    
    
//    
//    
//
//    JasperPrint jasperPrint;
//
//    public void init() throws JRException {
//
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaProdutoBean);
//
//        jasperPrint = JasperFillManager.fillReport("C:\\RelatorioWeb\\relatorio.jasper", new HashMap(), beanCollectionDataSource);
//
//    }
//
//    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
//
//        init();
//
//        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext();
//
//         //  httpServletResponse.addHeader("content-disposition", "attachment; filename= report.pdf");// isto serve para fazer download
//        ServletOutputStream servletOutputStream;
//
//        servletOutputStream = httpServletResponse.getOutputStream();
//
//        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
//
//    }
//
//    public void DOCX(ActionEvent actionEvent) throws IOException, JRException {
//        init();
//        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext();
//
//        //   httpServletResponse.addHeader("content-disposition", "attachment; filename= report.docx");// isto serve para fazer download
//        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//        JRDocxExporter docxExporter = new JRDocxExporter();
//        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
//     //   docxExporter.setParameter(docxExporter.OUTPUT_STREAM, servletOutputStream);
//
//        docxExporter.exportReport();
//
//    }
//
//    public void XLSX(ActionEvent actionEvent) throws IOException, JRException {
//        init();
//        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext();
//
//        //   httpServletResponse.addHeader("content-disposition", "attachment; filename= report.xlsx");// isto serve para fazer download
//        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//        JRXlsExporter jRXlsExporter = new JRXlsExporter();
//        jRXlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        jRXlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
//        jRXlsExporter.exportReport();
//
//    }
//
//    public void ODT(ActionEvent actionEvent) throws IOException, JRException {
//        init();
//        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext();
//
//        //   httpServletResponse.addHeader("content-disposition", "attachment; filename= report.odt");// isto serve para fazer download
//        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//        JROdtExporter jROdtExporter = new JROdtExporter();
//        jROdtExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        jROdtExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
//        jROdtExporter.exportReport();
//
//    }
//
//    public void PPTX(ActionEvent actionEvent) throws IOException, JRException {
//        init();
//        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext();
//
//        //   httpServletResponse.addHeader("content-disposition", "attachment; filename= report.pptx");// isto serve para fazer download
//        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//
//     //   JRPptxExporter jrpptxExporter = new JRPptxExporter();
//    //    jrpptxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//    //    jrpptxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
//    //    jrpptxExporter.exportReport();
//
//    }
//    
//    
//    
//    
//    
    
}
