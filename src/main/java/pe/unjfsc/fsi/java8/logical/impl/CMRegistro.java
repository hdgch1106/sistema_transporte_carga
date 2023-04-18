package pe.unjfsc.fsi.java8.logical.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unjfsc.fsi.java8.conexion.BDConexion;
import pe.unjfsc.fsi.java8.entity.CERegistro;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

public class CMRegistro implements CITransporteCarga<CERegistro> {

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(CERegistro objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_insert_registro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdCliente());
        cs.setInt(2, objObjeto.getDniCliente());
        cs.setString(3, objObjeto.getNombCliente());
        cs.setString(4, objObjeto.getAppaCliente());
        cs.setString(5, objObjeto.getApmaCliente());
        cs.setInt(6, objObjeto.getCelCliente());
        cs.setDouble(7, objObjeto.getPeso());
        cs.setInt(8, objObjeto.getNumeroPaquetes());
        cs.setString(9, objObjeto.getDescripcion());
        cs.setString(10, objObjeto.getDptoPartida());
        cs.setString(11, objObjeto.getProvinciaPartida());
        cs.setString(12, objObjeto.getDistritoPartida());
        cs.setString(13, objObjeto.getDireccionPartida());
        cs.setString(14, objObjeto.getDptoLlegada());
        cs.setString(15, objObjeto.getProvinciaLlegada());
        cs.setString(16, objObjeto.getDistritoLlegada());
        cs.setString(17, objObjeto.getDireccionLlegada());
        cs.execute();
    }

    @Override
    public void update(CERegistro objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(CERegistro objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet buscar_registros_pendiente() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM v_registros_pendientes;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet buscar_registros_aceptados() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM v_registros_aceptados;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public ResultSet buscar_registros_aceptadosgeneral() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM v_registros_aceptados_general;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public ResultSet buscar_registros_anulados() throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "SELECT * FROM v_registros_anulados;";
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public void aceptar_orden_pendiente(CERegistro objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_aceptar_registro(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdRegistro());
        cs.execute();
    }

    public void anular_orden_pendiente(CERegistro objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_anular_registro(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdRegistro());
        cs.execute();
    }
    
    public ResultSet buscar_registros_pendiente(Object objObject) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String nombre = "%" + objObject + "%";
        String sql = "SELECT * FROM v_registros_pendientes WHERE (appa_cliente) like?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        return rs;

    }
    
}
