/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.web;

import ec.edu.espe.arquitectura.banquito.clientews.ContribuyenteWSCliente;
import ec.edu.espe.arquitectura.banquito.clientews.EstablecimientoWSCliente;
import ec.edu.espe.arquitectura.banquito.clientews.PersonaWSCliente;
import ec.edu.espe.arquitectura.banquito.clientewscont.Contribuyente;
import ec.edu.espe.arquitectura.banquito.clientewsestab.Establecimiento;
import ec.edu.espe.arquitectura.banquito.clientewsper.Persona;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;
import org.primefaces.event.FlowEvent;
import org.joda.time.DateTime;

/**
 *
 * @author joel
 */
@Named
@ViewScoped
public class IndexBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(IndexBean.class.getName());

    @Inject
    private ContribuyenteWSCliente contribuyenteWSCliente;
    @Inject
    private EstablecimientoWSCliente establecimientoWSCliente;
    @Inject
    private PersonaWSCliente personaWSCliente;

    private Persona personaSeleccionada;
    private Contribuyente contribuyenteSeleccionado;
    private Establecimiento establecimientoSeleccionado;
    private List<Establecimiento> establecimientos;
    private String cedulaPersona;
    private String rucContribuyente;
    private BigDecimal monto;
    private Boolean siguiente;
    private String mensaje;

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public Contribuyente getContribuyenteSeleccionado() {
        return contribuyenteSeleccionado;
    }

    public void setContribuyenteSeleccionado(Contribuyente contribuyenteSeleccionado) {
        this.contribuyenteSeleccionado = contribuyenteSeleccionado;
    }

    public Establecimiento getEstablecimientoSeleccionado() {
        return establecimientoSeleccionado;
    }

    public void setEstablecimientoSeleccionado(Establecimiento establecimientoSeleccionado) {
        this.establecimientoSeleccionado = establecimientoSeleccionado;
    }

    public List<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(List<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getRucContribuyente() {
        return rucContribuyente;
    }

    public void setRucContribuyente(String rucContribuyente) {
        this.rucContribuyente = rucContribuyente;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @PostConstruct
    public void init() {
        personaWSCliente.iniciarCliente();
        contribuyenteWSCliente.iniciarCliente();
        establecimientoWSCliente.iniciarCliente();
        monto = null;
        siguiente = Boolean.FALSE;
        mensaje = "";
    }

    public String onFlowProcess(FlowEvent event) {
        if (siguiente) {
            return event.getNewStep();
        } else {
            Messages.addGlobalWarn(mensaje);
            return event.getOldStep();
        }
    }

    public void obtenerPersona() {
        personaSeleccionada = personaWSCliente.obtenerDatosPersona(cedulaPersona);
        if (personaSeleccionada == null) {
            Messages.addGlobalWarn("Cedula no encontrada");
            mensaje = "Cedula no encontrada";
            siguiente = Boolean.FALSE;
        } else {
            siguiente = Boolean.TRUE;
        }
    }

    public String obtenerFechaNac() {
        String fecha = null;
        if (personaSeleccionada != null) {
            try {
                DateTime dateTime = new DateTime(personaSeleccionada.getFechaNacimiento().toGregorianCalendar().getTime());
                fecha = dateTime.toString("dd-MM-yyyy");
            } catch (Exception ex) {
                LOG.severe(ex.toString());
            }
        }
        return fecha;
    }

    public String obtenerGenero() {
        String genero = null;
        if (personaSeleccionada != null) {
            switch ((personaSeleccionada.getGenero() != null) ? personaSeleccionada.getGenero() : "N/A") {
                case "M":
                    genero = "Masculino";
                    break;
                case "F":
                    genero = "Femenino";
                    break;
                default:
                    genero = "No definido";
                    break;
            }
        }
        return genero;
    }

    public String obtenerEstadoCivil() {
        String estadoCivil = null;
        if (personaSeleccionada != null) {
            switch ((personaSeleccionada.getEstadoCivil() != null) ? personaSeleccionada.getEstadoCivil() : "N/A") {
                case "C":
                    estadoCivil = "Casad";
                    break;
                case "S":
                    estadoCivil = "Solter";
                    break;
                case "D":
                    estadoCivil = "Divorciad";
                    break;
                case "V":
                    estadoCivil = "Viud";
                    break;
                default:
                    estadoCivil = "No definid";
                    break;
            }
            String genero = personaSeleccionada.getGenero() == null ? "M" : personaSeleccionada.getGenero();
            if (genero.compareTo("M") == 0) {
                estadoCivil = estadoCivil + "o";
            } else {
                estadoCivil = estadoCivil + "a";
            }
        }
        return estadoCivil;
    }

    public void obtenerContribuyente() {
        contribuyenteSeleccionado = contribuyenteWSCliente.obtnerDatosContribuyente(rucContribuyente);
        if (contribuyenteSeleccionado == null) {
            Messages.addGlobalWarn("RUC no encontrado");
            mensaje = "RUC no encontrado";
            siguiente = Boolean.FALSE;
        } else {
            establecimientos = establecimientoWSCliente.obtenerEstablecimientosActivos(contribuyenteSeleccionado.getRuc());
            siguiente = Boolean.TRUE;
        }
    }

    public String obtenerEstadoContribuyente() {
        String estado = null;
        if (contribuyenteSeleccionado != null) {
            switch ((contribuyenteSeleccionado.getEstado() != null) ? contribuyenteSeleccionado.getEstado() : "N/A") {
                case "A":
                    estado = "Activo";
                    break;
                case "D":
                    estado = "Desabilitado";
                    break;
                default:
                    estado = "No definido";
                    break;
            }
        }
        return estado;
    }

    public String obtenerEstadoEstablecimiento() {
        String estado = null;
        if (establecimientoSeleccionado != null) {
            switch ((establecimientoSeleccionado.getEstado() != null) ? establecimientoSeleccionado.getEstado() : "N/A") {
                case "A":
                    estado = "Activo";
                    break;
                case "D":
                    estado = "Desabilitado";
                    break;
                default:
                    estado = "No definido";
                    break;
            }
        }
        return estado;
    }

    public void confirmarTransferencia() {
        Messages.addFlashGlobalInfo("La trasnferencia fue realizada con éxito.");
        cleanBean();
    }

    public void cleanBean() {
        personaSeleccionada = null;
        cedulaPersona = null;
        contribuyenteSeleccionado = null;
        rucContribuyente = null;
        establecimientos = null;
        establecimientoSeleccionado = null;
        monto = null;
    }

    public void validarMonto() {
        if (monto != null) {
            if (monto.compareTo(BigDecimal.ZERO) <= 0) {
                Messages.addGlobalWarn("El monto de transferencia debe ser mayor a 0");
                mensaje = "El monto de transferencia debe ser mayor a 0";
                siguiente = Boolean.FALSE;
            } else {
                siguiente = Boolean.TRUE;
            }
        } else {
            siguiente = Boolean.FALSE;
        }
    }
}
