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
import pe.unjfsc.fsi.java8.entity.CECliente;
import pe.unjfsc.fsi.java8.logica.CITransporteCarga;

/**
 *
 * @author Shuhiro
 */
public class CMCliente implements CITransporteCarga<CECliente>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn=BDConexion.getInstance().getConection();
        String nombre="%"+objObject+"%";
        String sql="select * from v_cliente where appa_cliente like ?";
        PreparedStatement ps =cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(CECliente objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_insert_cliente(?,?,?,?,?,?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getDni_cliente());
        cs.setString(2, objObjeto.getNom_cliente());
        cs.setString(3, objObjeto.getAppa_cliente());
        cs.setString(4, objObjeto.getApma_cliente());
        cs.setString(5, objObjeto.getRuc_cliente());
        cs.setString(6, objObjeto.getDire_cliente());
        cs.setInt(7, objObjeto.getTelef_cliente());
        cs.setInt(8, objObjeto.getCel_cliente());
        cs.execute();
    }

    @Override
    public void update(CECliente objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_update_cliente(?,?,?,?,?,?,?,?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getId_cliente());
        cs.setInt(2, objObjeto.getDni_cliente());
        cs.setString(3, objObjeto.getNom_cliente());
        cs.setString(4, objObjeto.getAppa_cliente());
        cs.setString(5, objObjeto.getApma_cliente());
        cs.setString(6, objObjeto.getRuc_cliente());
        cs.setString(7, objObjeto.getDire_cliente());
        cs.setInt(8, objObjeto.getTelef_cliente());
        cs.setInt(9, objObjeto.getCel_cliente());
        cs.execute();
    }

    @Override
    public void delete(CECliente objObjeto) throws Exception {
        Connection cn = BDConexion.getInstance().getConection();
        String sql = "call sp_delete_cliente(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getId_cliente());
        cs.execute();
    }
    public ResultSet buscarxdni(Object objObject) throws Exception {
        Connection cn=BDConexion.getInstance().getConection();
        String nombre="%"+objObject+"%";
        String sql="select * from v_cliente where dni_cliente like ?";
        PreparedStatement ps =cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs=ps.executeQuery();
        return rs;
    }
}
