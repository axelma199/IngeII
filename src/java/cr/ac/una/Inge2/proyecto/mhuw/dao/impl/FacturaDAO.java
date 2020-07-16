/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.dao.impl;

import cr.ac.una.Inge2.proyecto.mhuw.dao.IBaseDAO;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Factura;
import cr.ac.una.Inge2.proyecto.mhuw.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author patei
 */
public class FacturaDAO extends HibernateUtil implements IBaseDAO<Factura, Integer>{
    public void save(Factura o) {

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
    public Factura merge(Factura o) {
        try {
            iniciaOperacion();
            o = (Factura) getSesion().merge(o);
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
    public void delete(Factura o) {
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
    public Factura findById(Integer id) {
        Factura servicios = null;
        try {
            iniciaOperacion();
            servicios = (Factura) getSesion().get(Factura.class, id);

        } finally {
            getSesion().close();
        }
        return servicios;

    }

    @Override
    public List<Factura> findAll() {
        List<Factura> listaFactura = null;
        try {
            iniciaOperacion();
            listaFactura = getSesion().createQuery("from Factura").list();
        } finally {
            getSesion().close();
        }
        return listaFactura;
    }

    @Override
    public List<Factura> findByQuery(String query) {
           List<Factura> acesso;
        try{
            iniciaOperacion();
            acesso = (List<Factura>) getSesion().createQuery(query).list();
        }catch(HibernateException he){
            manejaExcepcion(he);
            throw he;
        }finally{
            getSesion().close();
        }
        return acesso;
    }
}
