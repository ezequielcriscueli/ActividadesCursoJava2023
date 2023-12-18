package Materia;

import DAO.Main;
import Interfaces.DAOMateriaImplementacion;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Design extends javax.swing.JFrame {

     public Design() {
        initComponents();
         
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_cabecera = new javax.swing.JPanel();
        lbl_cabecera = new javax.swing.JLabel();
        panel_campos = new javax.swing.JPanel();
        lbl_ID = new javax.swing.JLabel();
        lbl_tarea = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_materia = new javax.swing.JTextField();
        panel_botones = new javax.swing.JPanel();
        btn_agregarMateria = new javax.swing.JButton();
        btn_modificarMateriaSeleccionada = new javax.swing.JButton();
        btn_eliminarMateriaSeleccionada = new javax.swing.JButton();
        btn_buscarMateria = new javax.swing.JButton();
        panel_lista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_cabecera.setBackground(new java.awt.Color(153, 153, 153));

        lbl_cabecera.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbl_cabecera.setForeground(new java.awt.Color(0, 0, 0));
        lbl_cabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cabecera.setText("Inscripción Materias Ciclo Lectivo 2024");

        panel_campos.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ID.setBackground(new java.awt.Color(0, 0, 0));
        lbl_ID.setForeground(new java.awt.Color(0, 0, 0));
        lbl_ID.setText("Código");

        lbl_tarea.setForeground(new java.awt.Color(0, 0, 0));
        lbl_tarea.setText("Materia");

        javax.swing.GroupLayout panel_camposLayout = new javax.swing.GroupLayout(panel_campos);
        panel_campos.setLayout(panel_camposLayout);
        panel_camposLayout.setHorizontalGroup(
            panel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_camposLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(txt_materia))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        panel_camposLayout.setVerticalGroup(
            panel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_camposLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_camposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panel_botones.setBackground(new java.awt.Color(204, 204, 204));

        btn_agregarMateria.setText("Inscribirse a Materia");
        btn_agregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarMateriaActionPerformed(evt);
            }
        });

        btn_modificarMateriaSeleccionada.setText("Modificar Materia");
        btn_modificarMateriaSeleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarMateriaSeleccionadaActionPerformed(evt);
            }
        });

        btn_eliminarMateriaSeleccionada.setText("Eliminar Materia");
        btn_eliminarMateriaSeleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarMateriaSeleccionadaActionPerformed(evt);
            }
        });

        btn_buscarMateria.setText("Buscar Materia por Código");
        btn_buscarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_botonesLayout = new javax.swing.GroupLayout(panel_botones);
        panel_botones.setLayout(panel_botonesLayout);
        panel_botonesLayout.setHorizontalGroup(
            panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_agregarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_modificarMateriaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_eliminarMateriaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btn_buscarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_botonesLayout.setVerticalGroup(
            panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_botonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificarMateriaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminarMateriaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_cabeceraLayout = new javax.swing.GroupLayout(panel_cabecera);
        panel_cabecera.setLayout(panel_cabeceraLayout);
        panel_cabeceraLayout.setHorizontalGroup(
            panel_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cabeceraLayout.createSequentialGroup()
                .addGroup(panel_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_cabeceraLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lbl_cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_cabeceraLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panel_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panel_cabeceraLayout.setVerticalGroup(
            panel_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_campos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        panel_lista.setBackground(new java.awt.Color(102, 102, 102));

        tabla_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Fecha Inscripcion", "Materia"
            }
        ));
        tabla_datos.setToolTipText("");
        jScrollPane1.setViewportView(tabla_datos);

        javax.swing.GroupLayout panel_listaLayout = new javax.swing.GroupLayout(panel_lista);
        panel_lista.setLayout(panel_listaLayout);
        panel_listaLayout.setHorizontalGroup(
            panel_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );
        panel_listaLayout.setVerticalGroup(
            panel_listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_listaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(682, 682, 682))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(panel_lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*-----------------INICIO FUNCION DE BOTONES-------------------*/    
    
    /*BOTON AGREGAR TAREA*/
    private void btn_agregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarMateriaActionPerformed
        if(agregar()){
            mostrar();
            limpiar();
        }
    }//GEN-LAST:event_btn_agregarMateriaActionPerformed

    private void btn_buscarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarMateriaActionPerformed
        buscar();
    }//GEN-LAST:event_btn_buscarMateriaActionPerformed

    private void btn_modificarMateriaSeleccionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarMateriaSeleccionadaActionPerformed
        if(modificar()){
            mostrar();
            limpiar();
        }
    }//GEN-LAST:event_btn_modificarMateriaSeleccionadaActionPerformed

    private void btn_eliminarMateriaSeleccionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarMateriaSeleccionadaActionPerformed
        if(eliminar()){
            mostrar();
            limpiar();
        }
    }//GEN-LAST:event_btn_eliminarMateriaSeleccionadaActionPerformed

    /*-----------------FIN FUNCION DE BOTONES-------------------*/
    
    
    /*-----------------INICIO LOGICA DE BOTONES-------------------*/
    /*METODO AGREGAR*/
    public boolean agregar() {
        DAOMateriaImplementacion materia_dao = new DAOMateriaImplementacion();
        Materia materia = new Materia();
        
        String descripcionMateria = txt_materia.getText();
        
        if(descripcionMateria.isBlank()){
            JOptionPane.showMessageDialog(null, "El campo 'Materia' no pueden estar vacío");
        }else {              
            LocalDate hoy = LocalDate.now();

            materia.setFechaInscripcion(hoy);
            materia.setMateria(descripcionMateria);
            
            return materia_dao.agregar(materia);
        }
        return false;
    }
        
    /*METODO MOSTRAR*/
    public void mostrar(){
        try {
            
            Main main = new Main();
            
            //GENERAMOS LA SENTENCIA SQL
            String sql = "SELECT * FROM materias";
            
            //ESTABLECEMOS LA CONEXION A LA BBDD
            Connection conexion = main.establecerConexion();
            
            //CREAMOS UN MODELO PARA ALMACENAR LOS REGISTROS DENTRO DE LA TABLA
        
            DefaultTableModel model = new DefaultTableModel();
            
            //CREAMOS UNA DECLARACION PARA EJECUTAR LA CONSULTA SQL
            Statement st = conexion.createStatement();
            
            //EJECUTAMOS LA QUERY
            ResultSet rs = st.executeQuery(sql);
            
            //OBTENEMOS LA INFORMACION DE LAS COLUMNAS DE LA CONSULTA
            ResultSetMetaData metaData = rs.getMetaData();
            
            int numColumnas = metaData.getColumnCount();
            
            //CREAMOS LAS COLUMNAS EN LA TABLA
            
            //for (int column = 1; column <= numColumnas-1; column++) {
                model.addColumn("ID");
                model.addColumn("Fecha Inscripcion");
                model.addColumn("Materia");
            //}
            
            //AGREGAMJOS LAS FILAS AL MODELO DE LA TABLA (LOS DATOS)
            while (rs.next()) {                
                Object[] rowData = new Object[numColumnas];
                for (int i = 0; i < numColumnas; i++) {
                    rowData[i] = rs.getObject(i+1);
                }
                model.addRow(rowData);
            }            
            //ASIGNAMOS EL MODEL DE LA TABLA AL COMPONENTE TABLADATOS
            tabla_datos.setModel(model);
            
            // Establecemos el ancho de las columnas
            int[] columnWidths = {50, 100, 500}; // Ancho de cada columna en píxeles
            for (int i = 0; i < numColumnas; i++) {
                TableColumn column = tabla_datos.getColumnModel().getColumn(i);
                column.setPreferredWidth(columnWidths[i]);
            }                           
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    
    /*METODO PARA MODIFICAR*/
    public boolean modificar(){
        DAOMateriaImplementacion materia_dao = new DAOMateriaImplementacion();
        Materia materia = new Materia();
        
        if (txt_id.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Coloque un ID numérico para modificar");
        } else {
            if(esNumeroEntero(txt_id.getText())){ //CHEQUEO QUE EL VALOR INGRESADO COMO ID SEA UN NUMERO ENTERO Y NO CARACTERES DE LETRAS
                
                int id = Integer.parseInt(txt_id.getText());
                String descripcionMateria = txt_materia.getText();

                materia.setId(id);
                materia.setMateria(descripcionMateria);

                return materia_dao.modificar(materia);
            } else {
                JOptionPane.showMessageDialog(null, "El ID a modificar debe ser numérico");
            }
        }    
        return false;
    }
    
    /*METODO PARA BUSCAR*/
    public void buscar(){
        DAOMateriaImplementacion materia_dao = new DAOMateriaImplementacion();
        Materia materia = new Materia();
        
        if (txt_id.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Coloque un ID numérico para buscar");
        } else {
            if(esNumeroEntero(txt_id.getText())){
                int id = Integer.parseInt(txt_id.getText());

                materia.setId(id);
                materia_dao.buscar(materia);

                txt_id.setText(String.valueOf(materia.getId()));
                txt_materia.setText(materia.getMateria());
            } else {
                JOptionPane.showMessageDialog(null, "El ID a buscar debe ser numérico");
            }
        }
    }
    
    /*METODO PARA ELIMINAR*/
    
    public boolean eliminar(){
        DAOMateriaImplementacion tarea_dao = new DAOMateriaImplementacion();
        Materia tarea = new Materia();
        
        if (txt_id.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Coloque un ID numérico para eliminar");
        } else {
            if(esNumeroEntero(txt_id.getText())){
                int id = Integer.parseInt(txt_id.getText());
                
                tarea.setId(id);
                return tarea_dao.eliminar(tarea);
            } else {
                JOptionPane.showMessageDialog(null, "El ID a eliminar debe ser numérico");
            }
        }
        return false;
    }
    /*METODO PARA VALIDAR SI UN STRING PUEDE PARSEARSE A ENTERO*/
    public boolean esNumeroEntero(String txt){
        try{
            Integer.parseInt(txt);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    
    /*METODO PARA LIMPIAR LOS CAMPOS DE TEXTO*/
    private void limpiar(){
        txt_id.setText("");
        txt_materia.setText("");
    }
    
    
    /*-----------------FIN LOGICA DE BOTONES-------------------*/
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Design design = new Design();
                
                design.setVisible(true);
                //design.txt_id.setEditable(false);
                //design.txt_id.setFocusable(false);
                design.mostrar();
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregarMateria;
    private javax.swing.JButton btn_buscarMateria;
    private javax.swing.JButton btn_eliminarMateriaSeleccionada;
    private javax.swing.JButton btn_modificarMateriaSeleccionada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_cabecera;
    private javax.swing.JLabel lbl_tarea;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPanel panel_cabecera;
    private javax.swing.JPanel panel_campos;
    private javax.swing.JPanel panel_lista;
    private javax.swing.JTable tabla_datos;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_materia;
    // End of variables declaration//GEN-END:variables
}
