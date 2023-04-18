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
import pe.unjfsc.fsi.java8.entity.CEVehiculo;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;


public class CMVehiculo implements CITransporteCarga<CEVehiculo> {

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM  v_vehiculo";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public ResultSet buscarPlaca(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String nombre = "%" + objObject + "%";
        String sql = "SELECT * FROM  v_vehiculo where placa like ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(CEVehiculo objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_insert_vehiculo(?,?,?,?,?,?,?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setString(1, objObjeto.getPlaca());
        cs.setString(2, objObjeto.getNroSerie());
        cs.setInt(3, objObjeto.getMarca());
        cs.setInt(4, objObjeto.getColor());
        cs.setInt(5, objObjeto.getTipoCarga());
        cs.setInt(6, objObjeto.getNroLlantas());
        cs.setDouble(7, objObjeto.getPeso_bruto());
        cs.setDouble(8, objObjeto.getPeso_neto());
        cs.setDouble(9, objObjeto.getPeso_util());
        cs.execute();
    }

    @Override
    public void update(CEVehiculo objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_update_vehiculo(?,?,?,?,?,?,?,?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdVehiculo());
        cs.setString(2, objObjeto.getPlaca());
        cs.setString(3, objObjeto.getNroSerie());
        cs.setInt(4, objObjeto.getMarca());
        cs.setInt(5, objObjeto.getColor());
        cs.setInt(6, objObjeto.getTipoCarga());
        cs.setInt(7, objObjeto.getNroLlantas());
        cs.setDouble(8, objObjeto.getPeso_bruto());
        cs.setDouble(9, objObjeto.getPeso_neto());
        cs.setDouble(10, objObjeto.getPeso_util());
        cs.execute();
    }

    @Override
    public void delete(CEVehiculo objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_delete_vehiculo(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdVehiculo());
        cs.execute();
    }

}
