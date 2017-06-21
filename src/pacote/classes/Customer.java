
package pacote.classes;

public class Customer {

    //Atributos
  private int id_customer;
  private int cpf_cnpj;
  private String nm_customer;  
  private boolean is_active;
  private double vl_total;             

  //Método Construtor
  public Customer(){};
  
  //Getter e Setter
    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(int cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public double getVl_total() {
        return vl_total;
    }

    public void setVl_total(double vl_total) {
        this.vl_total = vl_total;
    }

    @Override
    public String toString() {
        return "Customer{" + "id_customer=" + id_customer + ", cpf_cnpj=" + cpf_cnpj + ", nm_customer=" + nm_customer + ", is_active=" + is_active + ", vl_total=" + vl_total + '}';
    }
   
    
   
}
