/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.bl.impl;

import cr.ac.una.Inge2.proyecto.mhuw.bl.BaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.bl.IBaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Controlservicios;
import java.util.List;

/**
 *
 * @author patei
 */
public class ControlserviciosBL extends BaseBL implements IBaseBL<Controlservicios, Integer> {
        public ControlserviciosBL() {
        super();
    }

    
    
    
    @Override
    public void save(Controlservicios o) {
        this.getDAO(o.getClass().getName()).save(o);
    }

    @Override
    public Controlservicios merge(Controlservicios o) {
        return (Controlservicios) this.getDAO(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Controlservicios o) {
        this.getDAO(o.getClass().getName()).delete(o);
    }

    @Override
    public Controlservicios findById(Integer o) {
        return (Controlservicios) this.getDAO(Controlservicios.class.getName()).findById(o);
    }

    @Override
    public List<Controlservicios> findAll(String className) {
        return this.getDAO(className).findAll();

    }
    

    @Override
    public List<Controlservicios> findByQuery(String query) {
        return this.getDAO(Controlservicios.class.getName()).findByQuery(query);
    }

}
