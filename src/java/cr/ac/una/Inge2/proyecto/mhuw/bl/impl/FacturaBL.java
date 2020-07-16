/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.bl.impl;

import cr.ac.una.Inge2.proyecto.mhuw.bl.BaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.bl.IBaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Factura;
import java.util.List;

/**
 *
 * @author patei
 */
public class FacturaBL extends BaseBL implements IBaseBL<Factura, Integer> {
        public FacturaBL() {
        super();
    }

    
    
    
    @Override
    public void save(Factura o) {
        this.getDAO(o.getClass().getName()).save(o);
    }

    @Override
    public Factura merge(Factura o) {
        return (Factura) this.getDAO(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Factura o) {
        this.getDAO(o.getClass().getName()).delete(o);
    }

    @Override
    public Factura findById(Integer o) {
        return (Factura) this.getDAO(Factura.class.getName()).findById(o);
    }

    @Override
    public List<Factura> findAll(String className) {
        return this.getDAO(className).findAll();

    }
    

    @Override
    public List<Factura> findByQuery(String query) {
        return this.getDAO(Factura.class.getName()).findByQuery(query);
    }

}
