/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unjfsc.fsi.java8.logical.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unjfsc.fsi.java8.conexion.BDConexion;
import pe.unjfsc.fsi.java8.entity.CETipoVehiculo;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

/**
 *
 * @author Hugo Grados
 */
public class CMTipoVehiculo implements CITransporteCarga<CETipoVehiculo>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String nombre = "%" + objObject + "%";
        String sql = "SELECT * FROM  v_tipovehiculo where nomb_tipo like ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(CETipoVehiculo objObjeto) throws Exception {
Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_insert_tipov(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setString(1, objObjeto.getNombTipo());
        cs.execute();
    }

    @Override
    public void update(CETipoVehiculo objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_update_tipov(?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdTipo());
        cs.setString(2, objObjeto.getNombTipo());
        cs.execute();
    }

    @Override
    public void delete(CETipoVehiculo objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_delete_tipov(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdTipo());
        cs.execute();
    }
    
}
