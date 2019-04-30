/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.banquito.clientews;

import ec.edu.espe.arquitectura.banquito.clientewsestab.Establecimiento;
import ec.edu.espe.arquitectura.banquito.clientewsestab.EstablecimientoWS;
import ec.edu.espe.arquitectura.banquito.clientewsestab.EstablecimientoWS_Service;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author joel
 */
@Stateless
public class EstablecimientoWSCliente implements Serializable {

    private static final Logger LOG = Logger.getLogger(EstablecimientoWSCliente.class.getName());

    private EstablecimientoWS_Service invoker;
    private EstablecimientoWS establecimientoCliente;
    private BindingProvider bindingProvider;

    public void iniciarCliente() {
        this.invoker = new EstablecimientoWS_Service();
        this.establecimientoCliente = invoker.getEstablecimientoWSPort();
        this.bindingProvider = (BindingProvider) establecimientoCliente;
        this.bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://127.0.0.1:8080/sri-web/EstablecimientoWS?wsdl");
    }

    public Establecimiento obtenerMatriz(String ruc) {
        Establecimiento establecimiento = null;
        try {
            establecimiento = establecimientoCliente.obtenerMatriz(ruc);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return establecimiento;
    }

    public List<Establecimiento> obtenerEstablecimientosActivos(String ruc) {
        List<Establecimiento> establecimientos = null;
        try {
            establecimientos = establecimientoCliente.obtenerEstablecimientosActivos(ruc);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return establecimientos;
    }
}
