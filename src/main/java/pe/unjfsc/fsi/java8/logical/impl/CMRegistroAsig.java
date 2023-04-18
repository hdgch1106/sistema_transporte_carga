package pe.unjfsc.fsi.java8.logical.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unjfsc.fsi.java8.conexion.BDConexion;
import pe.unjfsc.fsi.java8.entity.CERegistroAsig;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

public class CMRegistroAsig implements CITransporteCarga<CERegistroAsig>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(CERegistroAsig objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_insert_registronull(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdRegistro());
        cs.execute();
    }

    @Override
    public void update(CERegistroAsig objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "CALL sp_update_registroenvio_asig(?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdRegistro());
        cs.setInt(2, objObjeto.getIdConductor());
        cs.setDate(3, objObjeto.getFechaPartida());
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
    
}
