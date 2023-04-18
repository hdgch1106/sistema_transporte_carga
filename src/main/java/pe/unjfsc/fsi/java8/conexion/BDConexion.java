/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unjfsc.fsi.java8.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jefrey
 */
public class BDConexion {
     static BDConexion instance = null;
    Connection connection = null;

    public BDConexion() throws Exception {
        String url = "jdbc:mysql://localhost:3306/transportecarga";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, "root", "");   
    }

    public static BDConexion getInstance() throws Exception {
        if(instance==null){
            instance = new BDConexion();
        }
        return instance;
    }

    public Connection getConection() {
        return connection;
    }
    protected void finalize() throws Throwable {
        connection.close();
        connection=null;
        super.finalize();
    }
}
