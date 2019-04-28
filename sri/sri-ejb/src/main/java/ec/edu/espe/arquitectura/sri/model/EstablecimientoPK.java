/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.sri.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joel
 */
@Embeddable
public class EstablecimientoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo_establecimiento")
    private String codigoEstablecimiento;

    public EstablecimientoPK() {
    }

    public EstablecimientoPK(String ruc, String codigoEstablecimiento) {
        this.ruc = ruc;
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(String codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        hash += (codigoEstablecimiento != null ? codigoEstablecimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstablecimientoPK)) {
            return false;
        }
        EstablecimientoPK other = (EstablecimientoPK) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        if ((this.codigoEstablecimiento == null && other.codigoEstablecimiento != null) || (this.codigoEstablecimiento != null && !this.codigoEstablecimiento.equals(other.codigoEstablecimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.sri.model.EstablecimientoPK[ ruc=" + ruc + ", codigoEstablecimiento=" + codigoEstablecimiento + " ]";
    }
    
}
