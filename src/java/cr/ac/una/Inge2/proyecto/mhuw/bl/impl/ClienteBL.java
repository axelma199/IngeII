/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.bl.impl;

import cr.ac.una.Inge2.proyecto.mhuw.bl.BaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.bl.IBaseBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Cliente;
import java.util.List;

/**
 *
 * @author patei
 */
public class ClienteBL extends BaseBL implements IBaseBL<Cliente, Integer> {
        public ClienteBL() {
        super();
    }

    
    
    
    @Override
    public void save(Cliente o) {
        this.getDAO(o.getClass().getName()).save(o);
    }

    @Override
    public Cliente merge(Cliente o) {
        return (Cliente) this.getDAO(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Cliente o) {
        this.getDAO(o.getClass().getName()).delete(o);
    }

    @Override
    public Cliente findById(Integer o) {
        return (Cliente) this.getDAO(Cliente.class.getName()).findById(o);
    }

    @Override
    public List<Cliente> findAll(String className) {
        return this.getDAO(className).findAll();

    }
    

    @Override
    public List<Cliente> findByQuery(String query) {
        return this.getDAO(Cliente.class.getName()).findByQuery(query);
    }

}
