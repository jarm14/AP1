/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.service;

import ec.edu.espe.arquitectura.sri.facade.ContribuyenteFacade;
import ec.edu.espe.arquitectura.sri.model.Contribuyente;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joel
 */
@Stateless
public class ContribuyenteServicio implements Serializable {

    private static final Logger LOG = Logger.getLogger(ContribuyenteServicio.class.getName());

    @EJB
    private ContribuyenteFacade contribuyenteFacade;

    public Contribuyente obtenerDatosContribuyente(String ruc) {
        Contribuyente contribuyente = null;
        try {
            contribuyente = contribuyenteFacade.obtenerActivos(ruc);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return contribuyente;
    }
}
