/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.facade;

import ec.edu.espe.arquitectura.sri.model.Establecimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joel
 */
@Stateless
public class EstablecimientoFacade extends AbstractFacade<Establecimiento> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_sri-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstablecimientoFacade() {
        super(Establecimiento.class);
    }
    
}
