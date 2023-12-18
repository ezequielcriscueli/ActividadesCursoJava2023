package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
    
    private Connection conectar = null;
    private final String user = "root";
    private final String password = "4Gu5t1nc1t0";
    private final String db = "cohorte1";
    private final String ip = "localhost";
    private final String port = "3306";
    private final String cadena = "jdbc:mysql://" + ip + ":" + port + "/" + db;
    
    
    public Connection establecerConexion(){
        try{
            conectar = DriverManager.getConnection(cadena, user, password);
            JOptionPane.showMessageDialog(null, "Conexión establecida con éxito");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo generar la conexión: " + e);
        }
        return conectar;
    }

    public static void main(String[] args) {
        
        Main app = new Main();
        
        app.establecerConexion();
    }
}
