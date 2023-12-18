package Main;

import java.sql.*;
import javax.swing.JOptionPane;

public class Main {

    //Atributos de conexión
    private Connection conectar = null;

    private final String usuario = "root";

    private final String contrasena = "4Gu5t1nc1t0";

    private final String db = "neoris_cohorte1";

    private final String ip = "127.0.0.1";

    private final String puerto = "3306";

    private final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;

    public Connection establecerConeccion() {
        try {

            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Se generó la conexión");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se generó la conexión" + e);
        }
        return conectar;
    }

    public static void main(String[] args) {
            Main  app = new Main();
            
            app.establecerConeccion();
    }
}
