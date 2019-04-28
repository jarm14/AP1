/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.service;

import ec.edu.espe.arquitectura.sri.facade.EstablecimientoFacade;
import ec.edu.espe.arquitectura.sri.model.Establecimiento;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joel
 */
@Stateless
public class EstablecimientoServicio implements Serializable {

    private static final Logger LOG = Logger.getLogger(EstablecimientoServicio.class.getName());

    @EJB
    private EstablecimientoFacade establecimientoFacade;

    public Establecimiento obtenerMatriz(String ruc) {
        Establecimiento establecimiento = null;
        try {
            establecimiento = establecimientoFacade.obtenerMatriz(ruc);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return establecimiento;
    }

    public List<Establecimiento> obtenerEstablecimientosActivos(String ruc) {
        List<Establecimiento> establecimientos = null;
        try {
            establecimientos = establecimientoFacade.obtenerActivos(ruc);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return establecimientos;
    }
}
