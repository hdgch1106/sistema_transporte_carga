
package pe.unjfsc.fsi.java8.entity;


public class CECliente {

    private int id_cliente;
    private int dni_cliente;
    private String nom_cliente;
    private String appa_cliente;
    private String apma_cliente;
    private String ruc_cliente;
    private String dire_cliente;
    private int telef_cliente;
    private int cel_cliente;

    public CECliente() {
    }

    public CECliente(int id_cliente, int dni_cliente, String nom_cliente, String appa_cliente, String apma_cliente, String ruc_cliente, String dire_cliente, int telef_cliente, int cel_cliente) {
        this.id_cliente = id_cliente;
        this.dni_cliente = dni_cliente;
        this.nom_cliente = nom_cliente;
        this.appa_cliente = appa_cliente;
        this.apma_cliente = apma_cliente;
        this.ruc_cliente = ruc_cliente;
        this.dire_cliente = dire_cliente;
        this.telef_cliente = telef_cliente;
        this.cel_cliente = cel_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getAppa_cliente() {
        return appa_cliente;
    }

    public void setAppa_cliente(String appa_cliente) {
        this.appa_cliente = appa_cliente;
    }

    public String getApma_cliente() {
        return apma_cliente;
    }

    public void setApma_cliente(String apma_cliente) {
        this.apma_cliente = apma_cliente;
    }

    public String getRuc_cliente() {
        return ruc_cliente;
    }

    public void setRuc_cliente(String ruc_cliente) {
        this.ruc_cliente = ruc_cliente;
    }

    public String getDire_cliente() {
        return dire_cliente;
    }

    public void setDire_cliente(String dire_cliente) {
        this.dire_cliente = dire_cliente;
    }

    public int getTelef_cliente() {
        return telef_cliente;
    }

    public void setTelef_cliente(int telef_cliente) {
        this.telef_cliente = telef_cliente;
    }

    public int getCel_cliente() {
        return cel_cliente;
    }

    public void setCel_cliente(int cel_cliente) {
        this.cel_cliente = cel_cliente;
    }
    
}
