/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unjfsc.fsi.java8.view;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pe.unjfsc.fsi.java8.entity.CEConductor;
import pe.unjfsc.fsi.java8.logical.impl.CMConductor;
import pe.unjfsc.fsi.java8.logical.impl.CMVehiculo;

/**
 *
 * @author Koraima
 */
public class JInternalConductor extends javax.swing.JInternalFrame {

    int xDNIConductor;
    int xIdConductor;
    boolean sw;
    String placa;
    DefaultTableModel objDtm;
    ResultSet rsConductor;
    ResultSet rsVehiculo;
    CMConductor objCMConductor = new CMConductor();
    CMVehiculo objCMVehiculo = new CMVehiculo();

    public JInternalConductor() {
        initComponents();
        objDtm = (DefaultTableModel) tablaConductor.getModel();
        setVisible(true);
        llenarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConductor = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jbtnNuevo = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtNumeroRegistro = new javax.swing.JTextField();
        jtxtDNI = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtBrevete = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtxtRevisionTecnica = new javax.swing.JTextField();
        jcbxVehiculoAsignado = new javax.swing.JComboBox<>();
        jcbxSOAT = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jtxtID = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtxtApat = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtxtAmat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaConductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombre", "A. Paterno", "A. Materno", "N° Registro", "Vehiculo Asignado", "Brevete", "SOAT", "Revision Tecnica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaConductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConductorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaConductor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 970, 150));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registroNuevo.png"))); // NOI18N
        jbtnNuevo.setText("NUEVO");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, 50));

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelarRegistro.png"))); // NOI18N
        jbtnCancelar.setText("CANCELAR");
        jbtnCancelar.setEnabled(false);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 130, 50));

        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        jbtnGuardar.setText("GUARDAR");
        jbtnGuardar.setEnabled(false);
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 130, 50));

        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jbtnEditar.setText("EDITAR");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 130, 50));

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        jbtnEliminar.setText("ELIMINAR");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 130, 50));

        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir.png"))); // NOI18N
        jbtnSalir.setText("SALIR");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 130, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 360, 360));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("ID");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 80, 20));

        jLabel7.setText("N° Registro ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 90, 20));

        jLabel8.setText("Vehiculo Asignado");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 120, 20));

        jtxtNumeroRegistro.setEditable(false);
        jPanel2.add(jtxtNumeroRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 240, -1));

        jtxtDNI.setEditable(false);
        jPanel2.add(jtxtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 240, -1));

        jLabel9.setText("Brevete                     ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, 20));

        jtxtBrevete.setEditable(false);
        jPanel2.add(jtxtBrevete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 240, -1));

        jLabel15.setText("SOAT                          ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 140, 20));

        jLabel16.setText("Revisión Técnica        ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 140, 20));

        jtxtRevisionTecnica.setEditable(false);
        jPanel2.add(jtxtRevisionTecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 240, -1));

        jcbxVehiculoAsignado.setEnabled(false);
        jcbxVehiculoAsignado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxVehiculoAsignadoActionPerformed(evt);
            }
        });
        jPanel2.add(jcbxVehiculoAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 240, -1));

        jcbxSOAT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "SI", "NO" }));
        jcbxSOAT.setEnabled(false);
        jcbxSOAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxSOATActionPerformed(evt);
            }
        });
        jPanel2.add(jcbxSOAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 240, -1));

        jLabel11.setText("Nombre");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, 20));

        jtxtID.setEditable(false);
        jPanel2.add(jtxtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 240, -1));

        jtxtNombre.setEditable(false);
        jPanel2.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 240, -1));

        jLabel17.setText("DNI   ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 80, 20));

        jLabel18.setText("Apellido Paterno");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 100, 20));

        jtxtApat.setEditable(false);
        jPanel2.add(jtxtApat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 240, -1));

        jLabel19.setText("Apellido Materno");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 100, 20));

        jtxtAmat.setEditable(false);
        jPanel2.add(jtxtAmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 240, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 480, 360));

        jLabel12.setText("CRUD:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        jLabel5.setText("DATOS DEL CONDUCTOR:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 72, -1, -1));

        jtxtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBuscarActionPerformed(evt);
            }
        });
        jtxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 12, 230, 30));

        jLabel14.setText("BUSCAR:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 22, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel13.setText("CONDUCTOR");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaConductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConductorMouseClicked
        try {
            jcbxVehiculoAsignado.removeAllItems();
            llenarCombo();
            xDNIConductor = Integer.parseInt(tablaConductor.getValueAt(tablaConductor.getSelectedRow(), 0).toString());
            rsConductor.first();
            do {
                if (xDNIConductor == rsConductor.getInt(1)) {
                    jtxtID.setText(String.valueOf(rsConductor.getInt(1)));
                    jtxtDNI.setText(String.valueOf(rsConductor.getInt(2)));
                    jtxtNombre.setText(rsConductor.getString(3));
                    jtxtApat.setText(rsConductor.getString(4));
                    jtxtAmat.setText(rsConductor.getString(5));
                    jtxtNumeroRegistro.setText(String.valueOf(rsConductor.getInt(6)));
                    jcbxVehiculoAsignado.setSelectedItem(rsConductor.getString(7));
                    jtxtBrevete.setText(rsConductor.getString(8));                    
                    jcbxSOAT.setSelectedIndex(rsConductor.getInt(9) + 2);
                    jtxtRevisionTecnica.setText(rsConductor.getString(10));
                    rsConductor.last();
                }
            } while (rsConductor.next());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tablaConductorMouseClicked

    private void jtxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyReleased
        try {
            limpiarJTable();
            if (!jtxtBuscar.getText().isEmpty()) {
                rsConductor = objCMConductor.buscar(jtxtBuscar.getText().trim());
                while (rsConductor.next()) {
                    Object registro[] = {rsConductor.getInt(1), 
                        rsConductor.getInt(2), 
                        rsConductor.getString(3),
                        rsConductor.getString(4),
                        rsConductor.getString(5),
                        rsConductor.getInt(6),
                        rsConductor.getString(7),
                        rsConductor.getString(8), 
                        rsConductor.getInt(9), 
                        rsConductor.getString(10)};
                    objDtm.addRow(registro);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jtxtBuscarKeyReleased

    private void jcbxVehiculoAsignadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxVehiculoAsignadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxVehiculoAsignadoActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        habilitaControles(true);
        limpiarControles();
        sw = true;
        llenarCombo();
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        habilitaControles(false);
        limpiarControles();
        llenarCombo();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        try {
            String mensaje = "";
            CEConductor objCEConductor = new CEConductor();
            //objVehiculoCE.setIdVehiculo(xidVehiculo);
            objCEConductor.setDNIconductor(Integer.parseInt(jtxtDNI.getText()));
            objCEConductor.setNombConductor(jtxtNombre.getText());
            objCEConductor.setApatConductor(jtxtApat.getText());
            objCEConductor.setAmatConductor(jtxtAmat.getText());
            objCEConductor.setNumeroRegistro(Integer.parseInt(jtxtNumeroRegistro.getText()));
            objCEConductor.setIdVehiculo(objCMConductor.buscarIdPlaca(jcbxVehiculoAsignado.getSelectedItem().toString()));
            int co = objCMConductor.buscarIdPlaca(jcbxVehiculoAsignado.getSelectedItem().toString());

            objCEConductor.setBrevete(jtxtBrevete.getText());            
            objCEConductor.setSOAT(jcbxSOAT.getSelectedIndex() - 2);
            objCEConductor.setRevisionTecnica(jtxtRevisionTecnica.getText());

            if (sw) {
                objCMConductor.insert(objCEConductor);
                mensaje = "Registro grabado";
            } else {
                xIdConductor = Integer.parseInt(jtxtID.getText());
                objCEConductor.setIdConductor(xIdConductor);
                objCMConductor.update(objCEConductor);
                mensaje = "Registro actualizado";
            }
            habilitaControles(false);
            JOptionPane.showMessageDialog(rootPane, mensaje);
            limpiarControles();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        habilitaControles(true);
        sw = false;
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        try {
            int op = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea eliminar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                CEConductor objConductor = new CEConductor();
                objConductor.setIdConductor(Integer.parseInt(jtxtID.getText()));
                objCMConductor.delete(objConductor);
                limpiarControles();
                JOptionPane.showMessageDialog(rootPane, "Registro Borrado");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jcbxSOATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxSOATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxSOATActionPerformed

    private void jtxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JComboBox<String> jcbxSOAT;
    private javax.swing.JComboBox<String> jcbxVehiculoAsignado;
    private javax.swing.JTextField jtxtAmat;
    private javax.swing.JTextField jtxtApat;
    private javax.swing.JTextField jtxtBrevete;
    private javax.swing.JTextField jtxtBuscar;
    private javax.swing.JTextField jtxtDNI;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNumeroRegistro;
    private javax.swing.JTextField jtxtRevisionTecnica;
    private javax.swing.JTable tablaConductor;
    // End of variables declaration//GEN-END:variables

    private void limpiarJTable() {
        while (objDtm.getRowCount() > 0) { 
            objDtm.removeRow(0);
        }
    }

    private void habilitaControles(boolean b) {
        jbtnNuevo.setEnabled(!b);
        jtxtDNI.setEditable(b);
        jtxtNombre.setEditable(b);
        jtxtApat.setEditable(b);
        jtxtAmat.setEditable(b);
        jtxtNumeroRegistro.setEditable(b);
        jcbxVehiculoAsignado.setEnabled(b);
        jtxtBrevete.setEditable(b);
        jcbxSOAT.setEnabled(b);
        jtxtRevisionTecnica.setEditable(b);
        jbtnGuardar.setEnabled(b);
        jbtnCancelar.setEnabled(b);
        jbtnEliminar.setEnabled(!b);
        jbtnEditar.setEnabled(!b);
    }

    private void limpiarControles() {
        JTextField[] arrJTextFields = {jtxtID, jtxtDNI, jtxtNombre, jtxtApat, jtxtAmat, jtxtNumeroRegistro, jtxtBrevete, jtxtRevisionTecnica};
        for (JTextField objJTextField : arrJTextFields) {
            objJTextField.setText(null);
        }
        limpiarJTable();
        jcbxVehiculoAsignado.removeAllItems();
        jcbxSOAT.setSelectedIndex(0);
    }

    private void llenarCombo() {
        try {
            rsVehiculo = objCMVehiculo.buscar("%");
            while (rsVehiculo.next()) {
                jcbxVehiculoAsignado.addItem(rsVehiculo.getString(2));
            }
        } catch (Exception e) {
        }
    }
}
