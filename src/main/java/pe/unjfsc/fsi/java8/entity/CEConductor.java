/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unjfsc.fsi.java8.entity;

/**
 *
 * @author Koraima
 */
public class CEConductor implements Comparable<CEConductor> {

    private int idConductor;    
    private int DNIconductor;
    private String NombConductor;
    private String ApatConductor;
    private String AmatConductor;
    private int NumeroRegistro;
    private int idVehiculo;
    private String Brevete;
    private int SOAT;
    private String RevisionTecnica;

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getDNIconductor() {
        return DNIconductor;
    }

    public void setDNIconductor(int DNIconductor) {
        this.DNIconductor = DNIconductor;
    }

    public String getNombConductor() {
        return NombConductor;
    }

    public void setNombConductor(String NombConductor) {
        this.NombConductor = NombConductor;
    }

    public String getApatConductor() {
        return ApatConductor;
    }

    public void setApatConductor(String ApatConductor) {
        this.ApatConductor = ApatConductor;
    }

    public String getAmatConductor() {
        return AmatConductor;
    }

    public void setAmatConductor(String AmatConductor) {
        this.AmatConductor = AmatConductor;
    }

    public int getNumeroRegistro() {
        return NumeroRegistro;
    }

    public void setNumeroRegistro(int NumeroRegistro) {
        this.NumeroRegistro = NumeroRegistro;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getBrevete() {
        return Brevete;
    }

    public void setBrevete(String Brevete) {
        this.Brevete = Brevete;
    }

    public int getSOAT() {
        return SOAT;
    }

    public void setSOAT(int SOAT) {
        this.SOAT = SOAT;
    }

    public String getRevisionTecnica() {
        return RevisionTecnica;
    }

    public void setRevisionTecnica(String RevisionTecnica) {
        this.RevisionTecnica = RevisionTecnica;
    }
    
    public CEConductor() {
    }

    public CEConductor(int idConductor, int DNIconductor, String NombConductor, String ApatConductor, String AmatConductor, int NumeroRegistro, int idVehiculo, String Brevete, int SOAT, String RevisionTecnica) {
        this.idConductor = idConductor;
        this.DNIconductor = DNIconductor;
        this.NombConductor = NombConductor;
        this.ApatConductor = ApatConductor;
        this.AmatConductor = AmatConductor;
        this.NumeroRegistro = NumeroRegistro;
        this.idVehiculo = idVehiculo;
        this.Brevete = Brevete;
        this.SOAT = SOAT;
        this.RevisionTecnica = RevisionTecnica;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.DNIconductor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CEConductor other = (CEConductor) obj;
        if (this.DNIconductor != other.DNIconductor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conductor : " + DNIconductor 
                + "\nNombre:" + NombConductor 
                + "\nApellido Paterno :" + ApatConductor 
                + "\nApellido Materno :" + AmatConductor 
                + "\nNumero de Registro :" + NumeroRegistro 
                + "\nVehiculo Asignado :" + idVehiculo 
                + "\nBrevete :" + Brevete 
                + "\nSOAT :" + SOAT 
                + "\nRevisionTecnica :" + RevisionTecnica + "\n";
    }
    
    @Override
    public int compareTo(CEConductor t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}