/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.banquito.clientews;

import ec.edu.espe.arquitectura.banquito.clientewsper.Persona;
import ec.edu.espe.arquitectura.banquito.clientewsper.PersonaWS;
import ec.edu.espe.arquitectura.banquito.clientewsper.PersonaWS_Service;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author joel
 */
@Stateless
public class PersonaWSCliente implements Serializable {

    private static final Logger LOG = Logger.getLogger(PersonaWSCliente.class.getName());

    private PersonaWS_Service invoker;
    private PersonaWS personaCliente;
    private BindingProvider bindingProvider;

    public void iniciarCliente() {
        this.invoker = new PersonaWS_Service();
        this.personaCliente = invoker.getPersonaWSPort();
        this.bindingProvider = (BindingProvider) personaCliente;
        this.bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://127.0.0.1:8080/registrocivil-web/PersonaWS?wsdl");
    }

    public Persona obtenerDatosPersona(String cedula) {
        Persona persona = null;
        try {
            persona = personaCliente.obtenerDatosPersona(cedula);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return persona;
    }
}
