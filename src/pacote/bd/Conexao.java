
package pacote.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Conexao {
        private Conexao(){
     PreparedStatement pstmt = null;
    }

    static {
        try {
            //Carrega o driver do banco
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco nao encontrado.");
            System.exit( -1);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
         
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/TesteBack",
                    "root",
                    ""
                    );
        } catch (SQLException ex) {
            System.err.print("Erro ao obter conexao: " + ex.getMessage());
        }
        return conn;
    }
    
    
}//Fim Classe
