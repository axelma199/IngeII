package cr.ac.una.Inge2.proyecto.mhuw.domain;
// Generated 03-oct-2018 19:51:19 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Estudiante generated by hbm2java
 */
public class Estudiante  implements java.io.Serializable {


     private Integer pkIdEstudiante;
     private Direccion direccion;
     private Salud salud;
     private Telefonos telefonos;
     private Usuario usuario;
     private String cedula;
     private String nombre;
     private String apellidos;
     private String nacionalidad;
     private String carrera;
     private String codigoCarrera;
     private String numeroCarnet;
     private String fechaNacimiento;
     private String lugarNacimiento;
     private String personaEmergencia;
     private String telefonoEmergencia;
     private Integer ultimoUsuario;
     private Date fechaModificacion;
     private Set<Comentarios> comentarioses = new HashSet<Comentarios>(0);

    public Estudiante() {
    }

	
    public Estudiante(Usuario usuario, String cedula, String nombre, String apellidos, String nacionalidad) {
        this.usuario = usuario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
    }
    public Estudiante(Direccion direccion, Salud salud, Telefonos telefonos, Usuario usuario, String cedula, String nombre, String apellidos, String nacionalidad, String carrera, String codigoCarrera, String numeroCarnet, String fechaNacimiento, String lugarNacimiento, String personaEmergencia, String telefonoEmergencia, Integer ultimoUsuario, Date fechaModificacion, Set<Comentarios> comentarioses) {
       this.direccion = direccion;
       this.salud = salud;
       this.telefonos = telefonos;
       this.usuario = usuario;
       this.cedula = cedula;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.nacionalidad = nacionalidad;
       this.carrera = carrera;
       this.codigoCarrera = codigoCarrera;
       this.numeroCarnet = numeroCarnet;
       this.fechaNacimiento = fechaNacimiento;
       this.lugarNacimiento = lugarNacimiento;
       this.personaEmergencia = personaEmergencia;
       this.telefonoEmergencia = telefonoEmergencia;
       this.ultimoUsuario = ultimoUsuario;
       this.fechaModificacion = fechaModificacion;
       this.comentarioses = comentarioses;
    }
   
    public Integer getPkIdEstudiante() {
        return this.pkIdEstudiante;
    }
    
    public void setPkIdEstudiante(Integer pkIdEstudiante) {
        this.pkIdEstudiante = pkIdEstudiante;
    }
    public Direccion getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public Salud getSalud() {
        return this.salud;
    }
    
    public void setSalud(Salud salud) {
        this.salud = salud;
    }
    public Telefonos getTelefonos() {
        return this.telefonos;
    }
    
    public void setTelefonos(Telefonos telefonos) {
        this.telefonos = telefonos;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String getCodigoCarrera() {
        return this.codigoCarrera;
    }
    
    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    public String getNumeroCarnet() {
        return this.numeroCarnet;
    }
    
    public void setNumeroCarnet(String numeroCarnet) {
        this.numeroCarnet = numeroCarnet;
    }
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getLugarNacimiento() {
        return this.lugarNacimiento;
    }
    
    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }
    public String getPersonaEmergencia() {
        return this.personaEmergencia;
    }
    
    public void setPersonaEmergencia(String personaEmergencia) {
        this.personaEmergencia = personaEmergencia;
    }
    public String getTelefonoEmergencia() {
        return this.telefonoEmergencia;
    }
    
    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }
    public Integer getUltimoUsuario() {
        return this.ultimoUsuario;
    }
    
    public void setUltimoUsuario(Integer ultimoUsuario) {
        this.ultimoUsuario = ultimoUsuario;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public Set<Comentarios> getComentarioses() {
        return this.comentarioses;
    }
    
    public void setComentarioses(Set<Comentarios> comentarioses) {
        this.comentarioses = comentarioses;
    }




}


