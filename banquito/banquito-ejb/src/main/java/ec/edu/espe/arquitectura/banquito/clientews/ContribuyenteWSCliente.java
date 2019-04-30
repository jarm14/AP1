/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.banquito.clientews;

import ec.edu.espe.arquitectura.banquito.clientewscont.Contribuyente;
import ec.edu.espe.arquitectura.banquito.clientewscont.ContribuyenteWS;
import ec.edu.espe.arquitectura.banquito.clientewscont.ContribuyenteWS_Service;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author joel
 */
@Stateless
public class ContribuyenteWSCliente implements Serializable {

    private static final Logger LOG = Logger.getLogger(ContribuyenteWSCliente.class.getName());

    private ContribuyenteWS_Service invoker;
    private ContribuyenteWS contribuyenteCliente;
    private BindingProvider bindingProvider;

    public void iniciarCliente() {
        this.invoker = new ContribuyenteWS_Service();
        this.contribuyenteCliente = invoker.getContribuyenteWSPort();
        this.bindingProvider = (BindingProvider) contribuyenteCliente;
        this.bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://127.0.0.1:8080/sri-web/ContribuyenteWS?wsdl");
    }

    public Contribuyente obtnerDatosContribuyente(String ruc) {
        Contribuyente contribuyente = null;
        try {
            contribuyente = contribuyenteCliente.obtenerDatosContribuyente(ruc);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return contribuyente;
    }
}
