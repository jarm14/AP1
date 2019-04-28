/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "establecimiento")
@NamedQueries({
    @NamedQuery(name = "Establecimiento.findAll", query = "SELECT e FROM Establecimiento e")})
public class Establecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstablecimientoPK establecimientoPK;
    @Size(max = 20)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 20)
    @Column(name = "canton")
    private String canton;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Size(max = 50)
    @Column(name = "nombre_comercial_establecimiento")
    private String nombreComercialEstablecimiento;
    @JoinColumn(name = "ruc", referencedColumnName = "ruc", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contribuyente contribuyente;

    public Establecimiento() {
    }

    public Establecimiento(EstablecimientoPK establecimientoPK) {
        this.establecimientoPK = establecimientoPK;
    }

    public Establecimiento(String ruc, String codigoEstablecimiento) {
        this.establecimientoPK = new EstablecimientoPK(ruc, codigoEstablecimiento);
    }

    public EstablecimientoPK getEstablecimientoPK() {
        return establecimientoPK;
    }

    public void setEstablecimientoPK(EstablecimientoPK establecimientoPK) {
        this.establecimientoPK = establecimientoPK;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreComercialEstablecimiento() {
        return nombreComercialEstablecimiento;
    }

    public void setNombreComercialEstablecimiento(String nombreComercialEstablecimiento) {
        this.nombreComercialEstablecimiento = nombreComercialEstablecimiento;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (establecimientoPK != null ? establecimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Establecimiento)) {
            return false;
        }
        Establecimiento other = (Establecimiento) object;
        if ((this.establecimientoPK == null && other.establecimientoPK != null) || (this.establecimientoPK != null && !this.establecimientoPK.equals(other.establecimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.sri.model.Establecimiento[ establecimientoPK=" + establecimientoPK + " ]";
    }
    
}
