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
import pe.unjfsc.fsi.java8.entity.CEConductor;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

/**
 *
 * @author Koraima
 */
public class CMConductor implements CITransporteCarga<CEConductor> {

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM  v_conductor";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(CEConductor objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_insert_conductor(?,?,?,?,?,?,?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getDNIconductor());
        cs.setString(2, objObjeto.getNombConductor());
        cs.setString(3, objObjeto.getApatConductor());
        cs.setString(4, objObjeto.getAmatConductor());
        cs.setInt(5, objObjeto.getNumeroRegistro());
        cs.setInt(6, objObjeto.getIdVehiculo());
        cs.setString(7, objObjeto.getBrevete());
        cs.setInt(8, objObjeto.getSOAT());
        cs.setString(9, objObjeto.getRevisionTecnica());
        cs.execute();
    }

    @Override
    public void update(CEConductor objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_update_conductor(?,?,?,?,?,?,?,?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdConductor());
        cs.setInt(2, objObjeto.getDNIconductor());
        cs.setString(3, objObjeto.getNombConductor());
        cs.setString(4, objObjeto.getApatConductor());
        cs.setString(5, objObjeto.getAmatConductor());
        cs.setInt(6, objObjeto.getNumeroRegistro());
        cs.setInt(7, objObjeto.getIdVehiculo());
        cs.setString(8, objObjeto.getBrevete());
        cs.setInt(9, objObjeto.getSOAT());
        cs.setString(10, objObjeto.getRevisionTecnica());
        cs.execute();
    }

    @Override
    public void delete(CEConductor objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_delete_conductor(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdConductor());
        cs.execute();
    }

    public String buscarById(int id) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "select placa from vehiculo where id_vehiculo = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }

    public int buscarIdPlaca(String placa) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "select id_vehiculo from vehiculo where placa = ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, placa);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    
    public ResultSet buscarConductor(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String nombre = "%" + objObject + "%";
        String sql = "SELECT * FROM  v_conductor where APAT_CONDUCTOR like ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet buscarConductorActivo() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM v_conductor_activo;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet buscarConductorInactivo() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM v_conductor_inactivo;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public ResultSet buscarConductorNombre() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM v_conductor_nombre;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
