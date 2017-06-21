
package pacote.classes;

import java.util.ArrayList;

public class Main {
   static ArrayList<Customer> customer = new ArrayList();
    //Método Principal
    public static void main(String[] args){
       
        //Instanciando Objetos
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        Customer c4 = new Customer();
        Customer c5 = new Customer();
        Operacoes o = new Operacoes();
        
       //Inserindo Clientes
       c1.setId_customer(1);
       c1.setCpf_cnpj(1111111);
       c1.setNm_customer("cliente n1");
       c1.setIs_active(true);
       c1.setVl_total(780.00);       
       o.create(c1); 
        
       c2.setId_customer(2);
       c2.setCpf_cnpj(222222);
       c2.setNm_customer("cliente n2");
       c2.setIs_active(false);
       c2.setVl_total(33.00);       
       o.create(c2); 
        
       c3.setId_customer(1788);
       c3.setCpf_cnpj(333333);
       c3.setNm_customer("Cliente n3");
       c3.setIs_active(true);
       c3.setVl_total(1567.30);       
       o.create(c3); 
        
       c4.setId_customer(1701);
       c4.setCpf_cnpj(44444);
       c4.setNm_customer("Cliente n4");
       c4.setIs_active(true);
       c4.setVl_total(3335.50);       
       o.create(c4);
        
       c5.setId_customer(1722);
       c5.setCpf_cnpj(55555);
       c5.setNm_customer("Cliente n5");
       c5.setIs_active(true);
       c5.setVl_total(560.10);       
       o.create(c5); 
       
       //Chamando Operações 
       o.realizarOperacoes();

       
    }//Fim do método Main
   
}
