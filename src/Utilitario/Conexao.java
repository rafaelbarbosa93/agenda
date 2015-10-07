package Utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	private final String drive = "org.gjt.mm.mysql.Driver";
    private final String url = "jdbc:mysql://localhost:3306/agenda" ;
    private final String usuario = "root";
    private final String senha = "root";
    private Connection con;
    
    public Conexao(){
        try {
            Class.forName(drive);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        if(con == null){
            try {
                con = DriverManager.getConnection(url, usuario, senha);
                con.setAutoCommit(false);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    
    public void desconecta(){
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 }