
package pe.unjfsc.fsi.java8.test;

import java.sql.Connection;
import pe.unjfsc.fsi.java8.conexion.BDConexion;

public class TEConexion {

    public static void main(String[] args) {
        try {
            Connection cn = BDConexion.getInstance().getConection();
            System.out.println("CONEXION ESTABLECIDA");
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }
}
