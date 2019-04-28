/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.ws;

import ec.edu.espe.arquitectura.sri.model.Contribuyente;
import ec.edu.espe.arquitectura.sri.service.ContribuyenteServicio;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author joel
 */
@WebService(serviceName = "ContribuyenteWS")
public class ContribuyenteWS {

    @EJB
    private ContribuyenteServicio ejbRef;

    @WebMethod(operationName = "obtenerDatosContribuyente")
    public Contribuyente obtenerDatosContribuyente(@WebParam(name = "ruc") String ruc) {
        return ejbRef.obtenerDatosContribuyente(ruc);
    }
    
}
