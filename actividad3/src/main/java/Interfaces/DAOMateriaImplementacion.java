package Interfaces;

import DAO.Main;
import Materia.Materia;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAOMateriaImplementacion implements DAOMateria{
    
    //ESTABLECEMOS UNA INSTANCIA DE LA CLASE MAIN
    Main main = new Main();

    //CONSTRUCTOR VACIO
    public DAOMateriaImplementacion(){}
    
    
    //IMPLEMENTAMOS METODO AGREGAR
    @Override
    public boolean agregar(Materia materia){
        try {
            //GENERAMOS LA SENTENCIA SQL
            String sql = "INSERT INTO materias (fecha_inscripcion, materia) VALUES (?, ?)";
            
            //ESTABLECEMOS LA CONEXION A LA BBDD
            Connection conexion = main.establecerConexion();
            
            // CONVIERTO LOCALDATE A DATE
            Date fechaInscripcionSql = java.sql.Date.valueOf(materia.getFechaInscripcion());
            
            //PREPARAMOS LA SENTENCIA
            PreparedStatement insertar = conexion.prepareStatement(sql);
            
            insertar.setDate(1, fechaInscripcionSql);
            insertar.setString(2, materia.getMateria());
            
            //EJECUTAMOS LA SENTENCIA
            int filasAfectadas = insertar.executeUpdate();
            
            insertar.close();
            conexion.close();
            
            if (filasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Materia inscripta con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la inscripción");
                return false;
            }
                    
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
            return false;
        }
    }
    
    //IMPLEMENTAMOS METODO MODIFICAR
    @Override
    public boolean modificar(Materia materia) {
        try {
            Connection conexion = main.establecerConexion();
            
            PreparedStatement modificar = conexion.prepareStatement("UPDATE materias SET materia = ? WHERE id = ?");
            
            modificar.setString(1, materia.getMateria());
            modificar.setInt(2, materia.getId());
            
            int filasAfectadas = modificar.executeUpdate();
            
            modificar.close();
            conexion.close();
            
            if (filasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Materia modificada con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar la Materia");
                return false;
            }
                  
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
            return false;
        }
    }

    
    //IMPLEMENTAMOS EL METODO ELIMINAR
    @Override
    public boolean eliminar(Materia materia) {
         try {
            Connection conexion = main.establecerConexion();
            
            PreparedStatement eliminar = conexion.prepareStatement("DELETE FROM materias WHERE id = ?");
            
            eliminar.setInt(1, materia.getId());
            
            int filasAfectadas = eliminar.executeUpdate();
            
            eliminar.close();
            conexion.close();
            
            if (filasAfectadas>0){
                JOptionPane.showMessageDialog(null, "Materia eliminada con éxito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la materia");
                return false;
            }  
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
            return false;
        }   
    }
 
    //IMPLEMENTAMOS EL METODO BUSCAR
    @Override
    public void buscar(Materia materia) {
        try {
            Connection conexion = main.establecerConexion();
            
            PreparedStatement buscar = conexion.prepareStatement("SELECT * FROM materias WHERE id = ?");
            
            buscar.setInt(1, materia.getId());
            
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
                materia.setId(Integer.parseInt(consulta.getString("id")));
                materia.setMateria(consulta.getString("materia"));
                JOptionPane.showMessageDialog(null, "Materia encontrada");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar la Materia");
            }       
            buscar.close();
            conexion.close();   
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
    }   
}
