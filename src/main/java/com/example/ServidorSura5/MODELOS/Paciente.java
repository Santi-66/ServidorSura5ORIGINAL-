package com.example.ServidorSura5.MODELOS;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="pacientes")

public class  Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;
    private String ips;

    private String grupoIngresos;
    private Boolean tienePoliza;
    private LocalDate fechaDeAfiliacion;

    //Crenado una relacion con la clase medico
    //Me relaciono con un medico

    @ManyToOne
    @JoinColumn (name = "fk_medico", referencedColumnName = "id")
    @JsonBackReference
    private Medico medico;

    @OneToMany (mappedBy = "paciente")
    @JsonManagedReference
    private List<Medicamento> medicamentos;

    @OneToMany (mappedBy = "paciente")
    @JsonManagedReference
    private List<SignoVital> signoVital;

    @OneToMany (mappedBy = "paciente")
    @JsonManagedReference
    private List<Enfermedad> enfermedad;




    public Paciente() {
    }

    public Paciente(Long id, String nombre, LocalDate fechaNacimiento, String correo, String telefono, String ips, String gripoIngresos, Boolean tienePoliza, LocalDate fechaDeAfiliacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.ips = ips;
        this.grupoIngresos = gripoIngresos;
        this.tienePoliza = tienePoliza;
        this.fechaDeAfiliacion = fechaDeAfiliacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getGripoIngresos() {
        return grupoIngresos;
    }

    public void setGripoIngresos(String gripoIngresos) {
       this.grupoIngresos = gripoIngresos;
    }

    public Boolean getTienePoliza() {
        return tienePoliza;
    }

    public void setTienePoliza(Boolean tienePoliza) {
        this.tienePoliza = tienePoliza;
    }

    public LocalDate getFechaDeAfiliacion() {
        return fechaDeAfiliacion;
    }

    public void setFechaDeAfiliacion(LocalDate fechaDeAfiliacion) {
        this.fechaDeAfiliacion = fechaDeAfiliacion;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ips='" + ips + '\'' +
                ", gripoIngresos='" + grupoIngresos + '\'' +
                ", tienePoliza=" + tienePoliza +
                ", fechaDeAfiliacion=" + fechaDeAfiliacion +
                '}';
    }
}
