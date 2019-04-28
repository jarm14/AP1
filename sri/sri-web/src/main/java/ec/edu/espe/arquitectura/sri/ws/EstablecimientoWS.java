/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.ws;

import ec.edu.espe.arquitectura.sri.model.Establecimiento;
import ec.edu.espe.arquitectura.sri.service.EstablecimientoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author joel
 */
@WebService(serviceName = "EstablecimientoWS")
public class EstablecimientoWS {

    @EJB
    private EstablecimientoServicio ejbRef;
    
    @WebMethod(operationName = "obtenerMatriz")
    public Establecimiento obtenerMatriz(@WebParam(name = "ruc") String ruc) {
        return ejbRef.obtenerMatriz(ruc);
    }

    @WebMethod(operationName = "obtenerEstablecimientosActivos")
    public List<Establecimiento> obtenerEstablecimientosActivos(@WebParam(name = "ruc") String ruc) {
        return ejbRef.obtenerEstablecimientosActivos(ruc);
    }
    
}
