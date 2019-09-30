/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDao;
import dao.InterfaceCliente;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

/**
 *
 * @author EMPRESA
 */
@Named(value = "clienteBean")
@SessionScoped

@ManagedBean
public class ClienteBean implements Serializable {

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }
    private List<Cliente> listaClienteBean;
    private Cliente cliente = new Cliente();

    public List<Cliente> getListaClienteBean() {

        listaClienteBean = new ClienteDao().getListaCliente();
        return listaClienteBean;
    }

    public void setListaClienteBean(List<Cliente> listaClienteBean) {
        this.listaClienteBean = listaClienteBean;
    }

    public Cliente getCliente() {
        if (cliente == null) {

            cliente = new Cliente();
        }

        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String prepararEdita(Cliente u) {

        cliente = u;

        return "cliente";

    }

    public String incluirCliente() {
        InterfaceCliente dao = new ClienteDao();
        if (cliente.getId() == null) {

            dao.salvar(cliente);
            limparCampos();
        } else {
            dao.editar(cliente);

            limparCampos();
        }
        limparCampos();
        return "cliente";
    }

    public void salvar() {

        InterfaceCliente dao = new ClienteDao();
        dao.salvar(cliente);

        limparCampos();
    }

    public String excluir(Cliente u) {
        this.cliente = u;
        InterfaceCliente dao = new ClienteDao();
        dao.excluir(cliente);
        limparCampos();
        return "cliente";
    }

    public void aterar() {

        InterfaceCliente dao = new ClienteDao();
        dao.editar(cliente);

        limparCampos();
    }

    public int tamanho() {

        //listaUsuarioBean = new UsuarioDao().getListaUsuario();
        return listaClienteBean.size();// assim da certo para ver o tamanho da lista

    }

    public void limparCampos() {

        cliente.setBairro(null);
        cliente.setCel(null);
        cliente.setCep(null);
        cliente.setCidade(null);
        cliente.setId(null);
        cliente.setCpf(null);
        cliente.setDataNasc(null);
        cliente.setEstadocivil(null);
        cliente.setEmail(null);
        cliente.setEndereco(null);
        cliente.setEstado(null);
        cliente.setIdent(null);
        cliente.setNome(null);
        cliente.setSexo(null);
        cliente.setTel(null);
    }

    
    
    
    public void exportarPDF(javax.faces.event.ActionEvent actionEvent) throws JRException, IOException{
Map<String,Object> paramters = new HashMap<String, Object>();
paramters.put("txtusuario","marcelo");

 File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Cliente.jasper"));
 JasperPrint imprime = JasperFillManager.fillReport(jasper.getPath(),paramters, new JRBeanCollectionDataSource(this.getListaClienteBean()));

 HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
 httpServletResponse.addHeader("Content-disposition", "attachment; filename=relatorioCliente.pdf");  

        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();  
        JasperExportManager.exportReportToPdfStream(imprime, servletOutputStream);  
       
        servletOutputStream.flush();
        servletOutputStream.close();
        
        FacesContext.getCurrentInstance().responseComplete();  




}
public void exportarExcel(javax.faces.event.ActionEvent actionEvent) throws JRException, IOException{
Map<String,Object> paramters = new HashMap<String, Object>();
paramters.put("txtusuario","marcelo");

 File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Cliente.jasper"));
 JasperPrint imprime = JasperFillManager.fillReport(jasper.getPath(),paramters, new JRBeanCollectionDataSource(this.getListaClienteBean()));

 HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
 httpServletResponse.addHeader("Content-disposition", "attachment; filename=relatorioCliente.xls");  

        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();  
       // JasperExportManager.exportReportToPdfStream(imprime, servletOutputStream);  
       
       
        
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, imprime);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        exporter.exportReport();
        
        servletOutputStream.flush();
        servletOutputStream.close();
        
        FacesContext.getCurrentInstance().responseComplete();  




}
public void exportarPPT(javax.faces.event.ActionEvent actionEvent) throws JRException, IOException{
Map<String,Object> paramters = new HashMap<String, Object>();
paramters.put("txtusuario","marcelo");

 File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Cliente.jasper"));
 JasperPrint imprime = JasperFillManager.fillReport(jasper.getPath(),paramters, new JRBeanCollectionDataSource(this.getListaClienteBean()));

 HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
 httpServletResponse.addHeader("Content-disposition", "attachment; filename=relatorioCliente.ppt");  

        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();  
       // JasperExportManager.exportReportToPdfStream(imprime, servletOutputStream);  
       
       
        
        JRPptxExporter exporter = new JRPptxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, imprime);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        exporter.exportReport();
        
        servletOutputStream.flush();
        servletOutputStream.close();
        
        FacesContext.getCurrentInstance().responseComplete();  




}
public void exportarDOC(javax.faces.event.ActionEvent actionEvent) throws JRException, IOException{
Map<String,Object> paramters = new HashMap<String, Object>();
paramters.put("txtusuario","marcelo");

 File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Cliente.jasper"));
 JasperPrint imprime = JasperFillManager.fillReport(jasper.getPath(),paramters, new JRBeanCollectionDataSource(this.getListaClienteBean()));

 HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
 httpServletResponse.addHeader("Content-disposition", "attachment; filename=relatorioCliente.doc");  

        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();  
           
       
        
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, imprime);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        exporter.exportReport();
        
        servletOutputStream.flush();
        servletOutputStream.close();
        
        FacesContext.getCurrentInstance().responseComplete();  




}
public void exportarHTML(javax.faces.event.ActionEvent actionEvent) throws JRException, IOException{

 File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Cliente.jasper"));
 byte[] bite = JasperRunManager.runReportToPdf(jasper.getPath(), null,new JRBeanCollectionDataSource(this.getListaClienteBean()));

 HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
 httpServletResponse.setContentType("application/pdf");
 httpServletResponse.setContentLength(bite.length);
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();  
       servletOutputStream.write(bite,0,bite.length);
       
       
        servletOutputStream.flush();
        servletOutputStream.close();
        
        FacesContext.getCurrentInstance().responseComplete();  




}
    
}
