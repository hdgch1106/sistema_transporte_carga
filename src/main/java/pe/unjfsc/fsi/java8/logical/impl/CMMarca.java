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
import pe.unjfsc.fsi.java8.entity.CEMarca;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

/**
 *
 * @author Hugo Grados
 */
public class CMMarca implements CITransporteCarga<CEMarca> {

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String nombre = "%" + objObject + "%";
        String sql = "SELECT * FROM  marca_vehiculo where nomb_marca like ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(CEMarca objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CEMarca objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(CEMarca objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
