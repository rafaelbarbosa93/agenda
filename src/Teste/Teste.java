package Teste;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Utilitario.Conexao;

public class Teste {

	public static void main(String[] args) {
		  
        try {
            Conexao con = new Conexao();
            PreparedStatement stm = con.getConnection().prepareStatement("select * from contato");
            ResultSet rs = stm.executeQuery();
            rs.next();
            System.out.println(rs.getString("NOME"));
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

