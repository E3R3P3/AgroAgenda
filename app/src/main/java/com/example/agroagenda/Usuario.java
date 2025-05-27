package com.example.agroagenda;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String extension;
    private String puesto;
    private String sucursal;
    private String departamento;

    public Usuario() {
        // Constructor vacío necesario para algunas operaciones
    }

    public Usuario(String nombre, String apellido, String extension, String puesto, String sucursal, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.extension = extension;
        this.puesto = puesto;
        this.sucursal = sucursal;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
