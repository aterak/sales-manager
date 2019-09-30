/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import dao.ProdutoDao;
import modelo.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author EMPRESA
 */
public class teste {
    
    
    
    public static void main(String[] args) {
      
        
//         int i=0;
//         int ii=0;
//         
//       List <Prevvenda> resultado= new ArrayList<Prevvenda>();
//        
//          Session ss = HibernateUtil.getSessionFactory().openSession();
//          Transaction t = ss.beginTransaction();
//
//        Criteria cri = ss.createCriteria(Prevvenda.class);
//        cri =cri.addOrder(Order.asc("notafiscal"));
//        
//       resultado = cri.list();
//       
//        
//       System.out.println("teste"+resultado);  
//        
       
//        for (Prevvenda p : resultado) {
//      ii=      p.getQuantidade();
//        // System.out.println("1"+ii);  
//        }
//        System.out.println("resultado"+ii);  
  //  }
        
        
        
        
        
        
      
          Session ss = HibernateUtil.getSessionFactory().openSession();
       Transaction t = ss.beginTransaction();
//   String s="SELECT nota_fiscal FROM Prevvenda ORDER BY nota_fiscal ";
//      Query q = ss.createQuery(s);
//            
//    resultado= q.list();
//             
//          System.out.println("1"+resultado);  
//       
//    }
    Produto pp =  new Produto();
    ProdutoDao dao = new ProdutoDao();
    
    pp.setNome("produto");
    dao.salvar(pp);
    t.commit();
    }
}
