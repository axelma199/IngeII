/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.dao.impl;

import cr.ac.una.Inge2.proyecto.mhuw.dao.IBaseDAO;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Cliente;
import cr.ac.una.Inge2.proyecto.mhuw.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author patei
 */
public class ClienteDAO extends HibernateUtil implements IBaseDAO<Cliente, Integer>{
    public void save(Cliente o) {

        try {
            iniciaOperacion();
            getSesion().save(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Cliente merge(Cliente o) {
        try {
            iniciaOperacion();
            o = (Cliente) getSesion().merge(o);
            getTransac().commit();
        } catch(HibernateException he)  {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return o;
    }

    @Override
    public void delete(Cliente o) {
       try {
            iniciaOperacion();
            getSesion().delete(o);
            getTransac().commit();
        } catch(HibernateException he)  {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
       
    }

    @Override
    public Cliente findById(Integer id) {
        Cliente servicios = null;
        try {
            iniciaOperacion();
            servicios = (Cliente) getSesion().get(Cliente.class, id);

        } finally {
            getSesion().close();
        }
        return servicios;

    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> listaCliente = null;
        try {
            iniciaOperacion();
            listaCliente = getSesion().createQuery("from Cliente").list();
        } finally {
            getSesion().close();
        }
        return listaCliente;
    }

    @Override
    public List<Cliente> findByQuery(String query) {
           List<Cliente> acesso;
        try{
            iniciaOperacion();
            acesso = (List<Cliente>) getSesion().createQuery(query).list();
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
        }finally{
            getSesion().close();
        }
        return acesso;
    }
}
