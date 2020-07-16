/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.test;

import cr.ac.una.Inge2.proyecto.mhuw.bl.impl.TelefonosBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Telefonos;

/**
 *
 * @author patei
 */
public class testTelefonos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TelefonosBL ubl = new TelefonosBL();
       Telefonos tel=new Telefonos();
       
       tel.setCelular("88440401");
       ubl.save(tel);
        System.out.print(ubl.findAll(Telefonos.class.getName()).size());
    }

}
