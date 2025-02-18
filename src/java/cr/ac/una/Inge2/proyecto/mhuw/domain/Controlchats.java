package cr.ac.una.Inge2.proyecto.mhuw.domain;
// Generated 03-oct-2018 19:51:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Controlchats generated by hbm2java
 */
public class Controlchats  implements java.io.Serializable {


     private Integer pkIdControlChats;
     private Usuario usuarioByFkIdUsuarioOrigen;
     private Usuario usuarioByFkIdUsuarioDestino;
     private String mensaje;
     private String asunto;
     private Date fechaEnvio;

    public Controlchats() {
    }

    public Controlchats(Usuario usuarioByFkIdUsuarioOrigen, Usuario usuarioByFkIdUsuarioDestino, String mensaje, String asunto, Date fechaEnvio) {
       this.usuarioByFkIdUsuarioOrigen = usuarioByFkIdUsuarioOrigen;
       this.usuarioByFkIdUsuarioDestino = usuarioByFkIdUsuarioDestino;
       this.mensaje = mensaje;
       this.asunto = asunto;
       this.fechaEnvio = fechaEnvio;
    }
   
    public Integer getPkIdControlChats() {
        return this.pkIdControlChats;
    }
    
    public void setPkIdControlChats(Integer pkIdControlChats) {
        this.pkIdControlChats = pkIdControlChats;
    }
    public Usuario getUsuarioByFkIdUsuarioOrigen() {
        return this.usuarioByFkIdUsuarioOrigen;
    }
    
    public void setUsuarioByFkIdUsuarioOrigen(Usuario usuarioByFkIdUsuarioOrigen) {
        this.usuarioByFkIdUsuarioOrigen = usuarioByFkIdUsuarioOrigen;
    }
    public Usuario getUsuarioByFkIdUsuarioDestino() {
        return this.usuarioByFkIdUsuarioDestino;
    }
    
    public void setUsuarioByFkIdUsuarioDestino(Usuario usuarioByFkIdUsuarioDestino) {
        this.usuarioByFkIdUsuarioDestino = usuarioByFkIdUsuarioDestino;
    }
    public String getMensaje() {
        return this.mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getAsunto() {
        return this.asunto;
    }
    
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public Date getFechaEnvio() {
        return this.fechaEnvio;
    }
    
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }




}


