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
import pe.unjfsc.fsi.java8.entity.CERegistroAsig;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

/**
 *
 * @author Koraima
 */
public class CMRegistroFinal implements CITransporteCarga<CERegistroAsig> {

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM  v_envio_final";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(CERegistroAsig objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CERegistroAsig objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_update_registroenvio_final(?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdRegistro());
        cs.setInt(2, objObjeto.getIdConductor());
        cs.setDate(3, objObjeto.getFechaLlegada());
        cs.execute();
    }

    @Override
    public void delete(CERegistroAsig objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int obtenerIdRegistro() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT *FROM registroenvio";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.last();
        return rs.getInt(1);
    }

    public void set_fecha_llegada(String id, String fecha) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "update registroenvio_asig set fecha_llegada= ? where id_registro= ?;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, fecha);
        ps.setString(2, id);
        ps.executeUpdate();
    }
}
