package cr.ac.una.Inge2.proyecto.mhuw.domain;
// Generated 03-oct-2018 19:51:19 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private Integer pkIdFuncionario;
     private Telefonos telefonos;
     private Usuario usuario;
     private String cedula;
     private String nombre;
     private String apellidos;
     private String celular;
     private Integer ultimoUsuario;
     private Date fechaModificacion;
     private Set<Grupo> grupos = new HashSet<Grupo>(0);

    public Funcionario() {
    }

	
    public Funcionario(Telefonos telefonos, Usuario usuario, String cedula, String nombre, String apellidos) {
        this.telefonos = telefonos;
        this.usuario = usuario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public Funcionario(Telefonos telefonos, Usuario usuario, String cedula, String nombre, String apellidos, String celular, Integer ultimoUsuario, Date fechaModificacion, Set<Grupo> grupos) {
       this.telefonos = telefonos;
       this.usuario = usuario;
       this.cedula = cedula;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.celular = celular;
       this.ultimoUsuario = ultimoUsuario;
       this.fechaModificacion = fechaModificacion;
       this.grupos = grupos;
    }
   
    public Integer getPkIdFuncionario() {
        return this.pkIdFuncionario;
    }
    
    public void setPkIdFuncionario(Integer pkIdFuncionario) {
        this.pkIdFuncionario = pkIdFuncionario;
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
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
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
    public Set<Grupo> getGrupos() {
        return this.grupos;
    }
    
    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }




}


