/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.bl.impl;

import cr.ac.una.Inge2.proyecto.mhuw.bl.BaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.bl.IBaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Servicios;
import java.util.List;

/**
 *
 * @author patei
 */
public class ServiciosBL extends BaseBL implements IBaseBL<Servicios, Integer> {

    public ServiciosBL() {
        super();
    }

    
    
    
    @Override
    public void save(Servicios o) {
        this.getDAO(o.getClass().getName()).save(o);
    }

    @Override
    public Servicios merge(Servicios o) {
        return (Servicios) this.getDAO(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Servicios o) {
        this.getDAO(o.getClass().getName()).delete(o);
    }

    @Override
    public Servicios findById(Integer o) {
        return (Servicios) this.getDAO(Servicios.class.getName()).findById(o);
    }

    @Override
    public List<Servicios> findAll(String className) {
        return this.getDAO(className).findAll();

    }
    

    @Override
    public List<Servicios> findByQuery(String query) {
        return this.getDAO(Servicios.class.getName()).findByQuery(query);
    }

}
