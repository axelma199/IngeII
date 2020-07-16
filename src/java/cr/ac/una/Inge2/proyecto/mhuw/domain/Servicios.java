package cr.ac.una.Inge2.proyecto.mhuw.domain;
// Generated 08-sep-2018 18:49:14 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Servicios generated by hbm2java
 */
public class Servicios  implements java.io.Serializable {


     private Integer pkIdServicio;
     private int nombre;
     private int tipoServicio;
     private Date horario;
     private String descripcion;
     private Integer cupos;
     private Double precio;
     private Date fechaCreacion;
     private Integer IUltimoUsuario;
     private Date DFechaModificacion;
     private Set<Controlservicios> controlservicioses = new HashSet<Controlservicios>(0);
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Servicios() {
    }

	
    public Servicios(int nombre, int tipoServicio, String descripcion) {
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
    }
    public Servicios(int nombre, int tipoServicio, Date horario, String descripcion, Integer cupos, Double precio, Date fechaCreacion, Integer IUltimoUsuario, Date DFechaModificacion, Set<Controlservicios> controlservicioses, Set<Factura> facturas) {
       this.nombre = nombre;
       this.tipoServicio = tipoServicio;
       this.horario = horario;
       this.descripcion = descripcion;
       this.cupos = cupos;
       this.precio = precio;
       this.fechaCreacion = fechaCreacion;
       this.IUltimoUsuario = IUltimoUsuario;
       this.DFechaModificacion = DFechaModificacion;
       this.controlservicioses = controlservicioses;
       this.facturas = facturas;
    }
   
    public Integer getPkIdServicio() {
        return this.pkIdServicio;
    }
    
    public void setPkIdServicio(Integer pkIdServicio) {
        this.pkIdServicio = pkIdServicio;
    }
    public int getNombre() {
        return this.nombre;
    }
    
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public int getTipoServicio() {
        return this.tipoServicio;
    }
    
    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public Date getHorario() {
        return this.horario;
    }
    
    public void setHorario(Date horario) {
        this.horario = horario;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getCupos() {
        return this.cupos;
    }
    
    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Integer getIUltimoUsuario() {
        return this.IUltimoUsuario;
    }
    
    public void setIUltimoUsuario(Integer IUltimoUsuario) {
        this.IUltimoUsuario = IUltimoUsuario;
    }
    public Date getDFechaModificacion() {
        return this.DFechaModificacion;
    }
    
    public void setDFechaModificacion(Date DFechaModificacion) {
        this.DFechaModificacion = DFechaModificacion;
    }
    public Set<Controlservicios> getControlservicioses() {
        return this.controlservicioses;
    }
    
    public void setControlservicioses(Set<Controlservicios> controlservicioses) {
        this.controlservicioses = controlservicioses;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }




}


