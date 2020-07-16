/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.bl.impl;

import cr.ac.una.Inge2.proyecto.mhuw.bl.IBaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Usuario;
import cr.ac.una.Inge2.proyecto.mhuw.bl.BaseBL;
import java.util.List;



/**
 *
 * @author patei
 */
public class UsuarioBL extends BaseBL implements IBaseBL<Usuario, Integer> {

    public UsuarioBL() {
        super();
    }

    
    
    
    @Override
    public void save(Usuario o) {
        this.getDAO(o.getClass().getName()).save(o);
    }

    @Override
    public Usuario merge(Usuario o) {
        return (Usuario) this.getDAO(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Usuario o) {
        this.getDAO(o.getClass().getName()).delete(o);
    }

    @Override
    public Usuario findById(Integer o) {
        return (Usuario) this.getDAO(Usuario.class.getName()).findById(o);
    }

    @Override
    public List<Usuario> findAll(String className) {
        return this.getDAO(className).findAll();

    }
    
       public Usuario findByNombreUsuario(String name){
        List<Usuario> usuarios = findAll(Usuario.class.getName());
        for (Usuario nom: usuarios) {
            if(nom.getUsuario().equals(name)){
                return nom;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> findByQuery(String query) {
        return this.getDAO(Usuario.class.getName()).findByQuery(query);
    }

}
