/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.dao.impl;

import cr.ac.una.Inge2.proyecto.mhuw.dao.IBaseDAO;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Servicios;
import cr.ac.una.Inge2.proyecto.mhuw.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author patei
 */
public class ServiciosDAO extends HibernateUtil implements IBaseDAO<Servicios, Integer>{
    public void save(Servicios o) {

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
    public Servicios merge(Servicios o) {
        try {
            iniciaOperacion();
            o = (Servicios) getSesion().merge(o);
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
    public void delete(Servicios o) {
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
    public Servicios findById(Integer id) {
        Servicios servicios = null;
        try {
            iniciaOperacion();
            servicios = (Servicios) getSesion().get(Servicios.class, id);

        } finally {
            getSesion().close();
        }
        return servicios;

    }

    @Override
    public List<Servicios> findAll() {
        List<Servicios> listaServicios = null;
        try {
            iniciaOperacion();
            listaServicios = getSesion().createQuery("from Servicios").list();
        } finally {
            getSesion().close();
        }
        return listaServicios;
    }

    @Override
    public List<Servicios> findByQuery(String query) {
           List<Servicios> acesso;
        try{
            iniciaOperacion();
            acesso = (List<Servicios>) getSesion().createQuery(query).list();
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
        }finally{
            getSesion().close();
        }
        return acesso;
    }
}
