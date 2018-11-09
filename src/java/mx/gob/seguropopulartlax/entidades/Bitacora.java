package mx.gob.seguropopulartlax.entidades;

import java.sql.Date;

public class Bitacora {
     
    private int id_bitacora;
    private Date fecha;
    private float kilometraje_inicial;
    private float kilometraje_final;
    private float importe;
    private String tanque_inicial;
    private float suministro;
    private String tanque_final;
    private float diferencia;
    private String recorrido;
    private String nombre_usuario;
    private int firma;
    private String observaciones;
    private String no_economico;
    private String curp;

    public Bitacora() {
    }

    public Bitacora(int id_bitacora, Date fecha, float kilometraje_inicial, float kilometraje_final, float importe, String tanque_inicial, float suministro, String tanque_final, float diferencia, String recorrido, String nombre_usuario, int firma, String observaciones, String no_economico, String curp) {
        this.id_bitacora = id_bitacora;
        this.fecha = fecha;
        this.kilometraje_inicial = kilometraje_inicial;
        this.kilometraje_final = kilometraje_final;
        this.importe = importe;
        this.tanque_inicial = tanque_inicial;
        this.suministro = suministro;
        this.tanque_final = tanque_final;
        this.diferencia = diferencia;
        this.recorrido = recorrido;
        this.nombre_usuario = nombre_usuario;
        this.firma = firma;
        this.observaciones = observaciones;
        this.no_economico = no_economico;
        this.curp = curp;
    }

    public int getId_bitacora() {
        return id_bitacora;
    }

    public void setId_bitacora(int id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getKilometraje_inicial() {
        return kilometraje_inicial;
    }

    public void setKilometraje_inicial(float kilometraje_inicial) {
        this.kilometraje_inicial = kilometraje_inicial;
    }

    public float getKilometraje_final() {
        return kilometraje_final;
    }

    public void setKilometraje_final(float kilometraje_final) {
        this.kilometraje_final = kilometraje_final;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getTanque_inicial() {
        return tanque_inicial;
    }

    public void setTanque_inicial(String tanque_inicial) {
        this.tanque_inicial = tanque_inicial;
    }

    public float getSuministro() {
        return suministro;
    }

    public void setSuministro(float suministro) {
        this.suministro = suministro;
    }

    public String getTanque_final() {
        return tanque_final;
    }

    public void setTanque_final(String tanque_final) {
        this.tanque_final = tanque_final;
    }

    public float getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(float diferencia) {
        this.diferencia = diferencia;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getFirma() {
        return firma;
    }

    public void setFirma(int firma) {
        this.firma = firma;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNo_economico() {
        return no_economico;
    }

    public void setNo_economico(String no_economico) {
        this.no_economico = no_economico;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    
}   
