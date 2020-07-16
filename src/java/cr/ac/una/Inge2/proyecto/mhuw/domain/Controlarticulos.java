package cr.ac.una.Inge2.proyecto.mhuw.domain;
// Generated 03-oct-2018 19:51:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Controlarticulos generated by hbm2java
 */
public class Controlarticulos  implements java.io.Serializable {


     private Integer pkIdArticulo;
     private Usuario usuario;
     private String titulo;
     private String descripcion;
     private String autor;
     private Date fechaPublicacion;
     private String enlace;
     private String enlaceDrive;
     private Date fechaModificacion;
     private Integer ultimoUsuario;

    public Controlarticulos() {
    }

	
    public Controlarticulos(Usuario usuario, String titulo, String descripcion, String autor, Date fechaPublicacion, String enlace) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.enlace = enlace;
    }
    public Controlarticulos(Usuario usuario, String titulo, String descripcion, String autor, Date fechaPublicacion, String enlace, String enlaceDrive, Date fechaModificacion, Integer ultimoUsuario) {
       this.usuario = usuario;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.autor = autor;
       this.fechaPublicacion = fechaPublicacion;
       this.enlace = enlace;
       this.enlaceDrive = enlaceDrive;
       this.fechaModificacion = fechaModificacion;
       this.ultimoUsuario = ultimoUsuario;
    }
   
    public Integer getPkIdArticulo() {
        return this.pkIdArticulo;
    }
    
    public void setPkIdArticulo(Integer pkIdArticulo) {
        this.pkIdArticulo = pkIdArticulo;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public String getEnlace() {
        return this.enlace;
    }
    
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    public String getEnlaceDrive() {
        return this.enlaceDrive;
    }
    
    public void setEnlaceDrive(String enlaceDrive) {
        this.enlaceDrive = enlaceDrive;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public Integer getUltimoUsuario() {
        return this.ultimoUsuario;
    }
    
    public void setUltimoUsuario(Integer ultimoUsuario) {
        this.ultimoUsuario = ultimoUsuario;
    }




}


