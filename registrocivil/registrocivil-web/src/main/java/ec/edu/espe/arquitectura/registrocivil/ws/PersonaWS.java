/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.registrocivil.ws;

import ec.edu.espe.arquitectura.registrocivil.model.Persona;
import ec.edu.espe.arquitectura.registrocivil.service.PersonaServicio;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author joel
 */
@WebService(serviceName = "PersonaWS")
public class PersonaWS {

    @EJB
    private PersonaServicio ejbRef;

    @WebMethod(operationName = "obtenerDatosPersona")
    public Persona obtenerDatosPersona(@WebParam(name = "cedula") String cedula) {
        return ejbRef.obtenerDatosPersona(cedula);
    }
    
}
