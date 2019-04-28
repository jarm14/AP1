/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.facade;

import ec.edu.espe.arquitectura.sri.model.Contribuyente;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joel
 */
@Stateless
public class ContribuyenteFacade extends AbstractFacade<Contribuyente> {

    private static final Logger LOG = Logger.getLogger(ContribuyenteFacade.class.getName());

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_sri-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContribuyenteFacade() {
        super(Contribuyente.class);
    }

    public Contribuyente obtenerActivos(String ruc) {
        Contribuyente contribuyente = null;
        try {
            contribuyente = em.createQuery("SELECT c FROM Contribuyente c "
                    + "WHERE c.ruc=:ruc AND c.estado='A'",
                    Contribuyente.class).setParameter("ruc", ruc)
                    .getSingleResult();
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return contribuyente;
    }

}
