/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.dao.impl;

import cr.ac.una.Inge2.proyecto.mhuw.dao.IBaseDAO;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Controlservicios;
import cr.ac.una.Inge2.proyecto.mhuw.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author patei
 */
public class ControlserviciosDAO extends HibernateUtil implements IBaseDAO<Controlservicios, Integer>{
    public void save(Controlservicios o) {

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
    public Controlservicios merge(Controlservicios o) {
        try {
            iniciaOperacion();
            o = (Controlservicios) getSesion().merge(o);
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
    public void delete(Controlservicios o) {
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
    public Controlservicios findById(Integer id) {
        Controlservicios servicios = null;
        try {
            iniciaOperacion();
            servicios = (Controlservicios) getSesion().get(Controlservicios.class, id);

        } finally {
            getSesion().close();
        }
        return servicios;

    }

    @Override
    public List<Controlservicios> findAll() {
        List<Controlservicios> listaControlservicios = null;
        try {
            iniciaOperacion();
            listaControlservicios = getSesion().createQuery("from Controlservicios").list();
        } finally {
            getSesion().close();
        }
        return listaControlservicios;
    }

    @Override
    public List<Controlservicios> findByQuery(String query) {
           List<Controlservicios> acesso;
        try{
            iniciaOperacion();
            acesso = (List<Controlservicios>) getSesion().createQuery(query).list();
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
        }finally{
            getSesion().close();
        }
        return acesso;
    }
}
