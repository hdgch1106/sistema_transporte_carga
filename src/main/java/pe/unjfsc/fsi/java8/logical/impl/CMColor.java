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
import pe.unjfsc.fsi.java8.entity.CEColor;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

/**
 *
 * @author Hugo Grados
 */
public class CMColor implements CITransporteCarga<CEColor> {

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String nombre = "%" + objObject + "%";
        String sql = "SELECT * FROM  color_vehiculo where nomb_color like ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(CEColor objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CEColor objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(CEColor objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
