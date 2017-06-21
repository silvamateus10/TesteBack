package pacote.classes;

import pacote.bd.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static pacote.classes.Main.customer;

public class Operacoes {

    ArrayList<Customer> customer = new ArrayList();
    ArrayList<Customer> selecionados = new ArrayList();       
    Customer c = new Customer();
    private double soma = 0;
    private double media = 0;    
    int j;//Váriavel global de incremento
    
    public Operacoes() {
    }

    public double getSoma() {
        return soma;
    }

    public void setSoma(double soma) {
        this.soma += soma;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
    
    
    //Método de inserção no Banco de dados
    public void create(Customer c) {

        PreparedStatement pstmt;
        Connection conn = Conexao.getConnection();

        try {

            String queryString = "INSERT INTO tb_customer_account(id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(queryString);
            pstmt.setInt(1, c.getId_customer());
            pstmt.setInt(2, c.getCpf_cnpj());
            pstmt.setString(3, c.getNm_customer());
            pstmt.setBoolean(4, c.isIs_active());
            pstmt.setDouble(5, c.getVl_total());
            
            pstmt.executeUpdate();
            conn.close();            
            
            System.out.println("Criado com Sucesso!");            
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    
    }//Fim método create

  

    //Método ListOrder ordena os dados da tabela de forma crescente de acordo com vl_total
    public ArrayList<Customer> ListOrder() {   
        Connection conn = Conexao.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_customer_account ORDER BY vl_total");
            
            
            while(rs.next()){
                    Customer cl = new Customer();
                    cl.setId_customer(rs.getInt("id_customer"));
                    cl.setCpf_cnpj(rs.getInt("cpf_cnpj"));
                    cl.setNm_customer(rs.getString("nm_customer"));
                    cl.setIs_active(rs.getBoolean("is_active"));
                    cl.setVl_total(rs.getDouble("vl_total"));
                    customer.add(cl);
            }
                        
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        //Retornando a ArrayList Ordenada
        return customer;
    }//Fim do método ListOrder
    
    
    //Método filtro é responsável por selecionar apenas os intens que o valor seja maior que 560 e o Id estiver entre 1500 e 1700
    public ArrayList<Customer> filtro() {
        customer = ListOrder();
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getVl_total() > 560) {
                if (customer.get(i).getId_customer() >= 1500 && customer.get(i).getId_customer() <= 2700) {
                    selecionados.add(customer.get(i));
                }
            }
        }        
        
        //Retorna uma ArrayList com apenas os selecionados
        return selecionados;
    }//fim método filtro

    
    //Responsável por calcular a médio dos itens selecionados
    public void calcularMedia() {
       //Chamar a arraylist escolhida
        selecionados = filtro();
        
        //Somando os valores
        for (j = 0; j < selecionados.size(); j++) {
            setSoma(selecionados.get(j).getVl_total());
        }
        
        //Calculando a média
        setMedia(getSoma() / j);        
        
    }//Fim método calcularMedia

    
    //Método show exibirá a média calculada e os clientes utilizados para o calculo
    public void show() {        
                
        System.out.println("Média calculada: " + getMedia());
        System.out.println("\n\nClientes usados para o Cálculo da média: ");
        int i = 0;
        while(i < selecionados.size()) {            
            System.out.println(selecionados.get(i));
             i++;
        }
         
         

    }// Fim do método show    
    
    
    //Método realizarOperacoes irá chamar os métodos para calcular a média e depois exibir 
    public void realizarOperacoes(){
     calcularMedia();      
     show();
    }//Fim do método realizar 
}
