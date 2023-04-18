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
import pe.unjfsc.fsi.java8.entity.CECliente;
import pe.unjfsc.fsi.java8.logical.impl.CMCliente;

/**
 *
 * @author Shuhiro
 */
public class JInternalCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalCliente
     */
    int xid_cliente;
    DefaultTableModel objDTM = new DefaultTableModel();
    CMCliente objCliente = new CMCliente();
    ResultSet rsCliente;
    boolean sw;

    public JInternalCliente() {
        initComponents();
        objDTM = (DefaultTableModel) tblCliente.getModel();
        setSize(735, 590);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("CLIENTE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("Ap. Paterno del Cliente a Buscar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 130, -1));

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombre", "Ap. Paterno", "Ap. Materno", "RUC", "Direccion", "Telefono", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 680, 150));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("DNI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jLabel5.setText("Ap. Paterno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel6.setText("Ap. Materno");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        txtDNI.setEditable(false);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 120, -1));

        txtNombre.setEditable(false);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 120, -1));

        txtPaterno.setEditable(false);
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 120, -1));

        txtMaterno.setEditable(false);
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 120, -1));

        jLabel7.setText("RUC");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jLabel8.setText("Direccion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel9.setText("Telefono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        jLabel10.setText("Celular");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        txtRUC.setEditable(false);
        txtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCKeyTyped(evt);
            }
        });
        jPanel1.add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 120, -1));

        txtDireccion.setEditable(false);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 120, -1));

        txtTelefono.setEditable(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, -1));

        txtCelular.setEditable(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 120, -1));

        jLabel11.setText("ID");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 680, 180));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnGuardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        jbtnGuardar.setText("GUARDAR");
        jbtnGuardar.setEnabled(false);
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 140, 50));

        jbtnBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        jbtnBorrar.setText("BORRAR");
        jbtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBorrarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 140, 50));

        jbtnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelarRegistro.png"))); // NOI18N
        jbtnCancelar.setText("CANCELAR");
        jbtnCancelar.setEnabled(false);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 150, 50));

        jbtnEditar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jbtnEditar.setText("EDITAR");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 120, 50));

        jbtnNuevo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registroNuevo.png"))); // NOI18N
        jbtnNuevo.setText("NUEVO");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 150, 50));

        jbtnSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir.png"))); // NOI18N
        jbtnSalir.setText("SALIR");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 120, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 680, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarControles() {
        JTextField[] arrayJTextField = {txtBuscar, txtID,txtDNI, txtNombre, txtPaterno, txtMaterno, txtRUC, txtDireccion, txtTelefono, txtCelular};
        for (JTextField jTextField : arrayJTextField) {
            jTextField.setText(null);
        }
        limpiarTable();
    }

    private void limpiarTable() {
        while (objDTM.getRowCount() > 0) {
            objDTM.removeRow(0);
        }
    }

    private void habilitaControles(boolean b) {
        JTextField[] arrayJTextField = {txtDNI, txtNombre, txtPaterno, txtMaterno, txtRUC, txtDireccion, txtTelefono, txtCelular};
        for (JTextField jTextField : arrayJTextField) {
            jTextField.setEditable(b);
        }
        txtBuscar.setEditable(!b);
        txtDNI.grabFocus();
        jbtnGuardar.setEnabled(b);
        jbtnCancelar.setEnabled(b);
        jbtnNuevo.setEnabled(!b);
        jbtnEditar.setEnabled(!b);
        jbtnBorrar.setEnabled(!b);
        jbtnSalir.setEnabled(!b);
    }
    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        try {
            String mensaje;
            CECliente objCECliente = new CECliente();
            
            objCECliente.setDni_cliente(Integer.parseInt(txtDNI.getText()));
            objCECliente.setNom_cliente(txtNombre.getText());
            objCECliente.setAppa_cliente(txtPaterno.getText());
            objCECliente.setApma_cliente(txtMaterno.getText());
            if (txtRUC.getText().equals("")) {
                objCECliente.setRuc_cliente("NO CUENTA");
            } else {
                objCECliente.setRuc_cliente(txtRUC.getText());
            }
            objCECliente.setDire_cliente(txtDireccion.getText());
            objCECliente.setTelef_cliente(Integer.parseInt(txtTelefono.getText()));
            objCECliente.setCel_cliente(Integer.parseInt(txtCelular.getText()));

            if (sw) {
                objCliente.insert(objCECliente);
                mensaje = "Registro Agregado";
            } else {
                xid_cliente = Integer.parseInt(txtID.getText());
                objCECliente.setId_cliente(xid_cliente);
                objCliente.update(objCECliente);
                mensaje = "Registro Actualizado";
            }
            JOptionPane.showMessageDialog(rootPane, mensaje);
            habilitaControles(false);
            limpiarControles();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        try {
            int op = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que desea borrar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                CECliente objCECliente = new CECliente();
                objCECliente.setId_cliente(Integer.parseInt(txtID.getText()));
                objCliente.delete(objCECliente);
                limpiarControles();
                JOptionPane.showMessageDialog(rootPane, "Registro Borrado");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        limpiarControles();
        habilitaControles(false);
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        sw = false;
        habilitaControles(true);
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        sw = true;
        limpiarControles();
        habilitaControles(true);    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        // TODO add your handling code here:
        try {
            int xdni_cliente= Integer.parseInt(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0).toString());
            rsCliente.first();
            do {                
                if (xdni_cliente == rsCliente.getInt(1)) {
                    txtID.setText(String.valueOf(rsCliente.getInt(1)));
                    txtDNI.setText(String.valueOf(rsCliente.getInt(2)));
                    txtNombre.setText(rsCliente.getString(3));
                    txtPaterno.setText(rsCliente.getString(4));
                    txtMaterno.setText(rsCliente.getString(5));
                    txtRUC.setText(rsCliente.getString(6));
                    txtDireccion.setText(rsCliente.getString(7));
                    txtTelefono.setText(String.valueOf(rsCliente.getInt(8)));
                    txtCelular.setText(String.valueOf(rsCliente.getInt(9)));
                    rsCliente.last();
                }
            } while (rsCliente.next());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblClienteMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        try {
            limpiarTable();
            if (!txtBuscar.getText().isEmpty()) {
                String apellido = txtBuscar.getText().trim();
                rsCliente = objCliente.buscar(apellido);
                while (rsCliente.next()) {
                    Object[] registro = {
                        rsCliente.getInt(1),
                        rsCliente.getInt(2), rsCliente.getString(3), rsCliente.getString(4),
                        rsCliente.getString(5),rsCliente.getString(6),rsCliente.getString(7),
                        rsCliente.getInt(8),rsCliente.getInt(9)};
                    objDTM.addRow(registro);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMaternoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (c<'0' || c>'9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (c<'0' || c>'9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtRUCKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (c<'0' || c>'9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (c<'0' || c>'9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
