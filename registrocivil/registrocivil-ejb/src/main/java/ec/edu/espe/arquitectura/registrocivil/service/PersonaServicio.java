/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.registrocivil.service;

import ec.edu.espe.arquitectura.registrocivil.facade.PersonaFacade;
import ec.edu.espe.arquitectura.registrocivil.model.Persona;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author joel
 */
@Stateless
public class PersonaServicio implements Serializable {

    private static final Logger LOG = Logger.getLogger(PersonaServicio.class.getName());

    @EJB
    private PersonaFacade personaFacade;

    public Persona obtenerDatosPersona(String cedula) {
        Persona persona = null;
        try {
            persona = personaFacade.find(cedula);
        } catch (Exception ex) {
            LOG.severe(ex.toString());
        }
        return persona;
    }
}
