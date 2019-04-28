/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.facade;

import ec.edu.espe.arquitectura.sri.model.Establecimiento;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joel
 */
@Stateless
public class EstablecimientoFacade extends AbstractFacade<Establecimiento> {

    private static final Logger LOG = Logger.getLogger(EstablecimientoFacade.class.getName());

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_sri-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstablecimientoFacade() {
        super(Establecimiento.class);
    }

    public Establecimiento obtenerMatriz(String ruc) {
        Establecimiento establecimiento = null;
        try {
            List<Establecimiento> establecimientos = em.createQuery("SELECT e FROM Establecimiento e "
                    + "WHERE e.establecimientoPK.ruc=:ruc "
                    + "ORDER BY e.establecimientoPK.codigoEstablecimiento ASC",
                    Establecimiento.class).setParameter("ruc", ruc)
                    .getResultList();
            establecimiento = establecimientos.get(0);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return establecimiento;
    }

    public List<Establecimiento> obtenerActivos(String ruc) {
        List<Establecimiento> establecimientos = null;
        try {
            establecimientos = em.createQuery("SELECT e FROM Establecimiento e "
                    + "WHERE e.establecimientoPK.ruc=:ruc AND e.estado='A'",
                    Establecimiento.class).setParameter("ruc", ruc)
                    .getResultList();
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return establecimientos;
    }
}
