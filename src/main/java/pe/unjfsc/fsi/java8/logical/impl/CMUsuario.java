/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unjfsc.fsi.java8.logical.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unjfsc.fsi.java8.conexion.BDConexion;
import pe.unjfsc.fsi.java8.entity.CEUsuario;


public class CMUsuario {
        public boolean acceso(CEUsuario objUsuarioTO) throws Exception {
        boolean sw = false;
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "select *from usuario";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (objUsuarioTO.getUsuario().equals(rs.getString(2)) && objUsuarioTO.getClave().equals(rs.getString(3))) {
                sw = true;
            }
        }
        return sw;
    }
 }

