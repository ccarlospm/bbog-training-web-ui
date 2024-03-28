/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdb.reglas.fsdv.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C_CAR
 */
@Entity
@Table(name = "SEGURO_DE_VIDA")
@NamedQueries({
    @NamedQuery(name = "SeguroDeVida.findAll", query = "SELECT s FROM SeguroDeVida s")
})
public class SeguroDeVida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    private int id;
  
    @Basic(optional = false)
    @NotNull
    private int edad;
   
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_PRODUCTO")
    private String tipoProducto;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String factor;

    public SeguroDeVida() {
    }

    public SeguroDeVida(int id) {
        this.id = id;
    }

    public SeguroDeVida(int id, int edad, String tipoProducto, String factor) {
        this.id = id;
        this.edad = edad;
        this.tipoProducto = tipoProducto;
        this.factor = factor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "SeguroDeVida{" + "id=" + id + ", edad=" + edad + ", tipoProducto=" + tipoProducto + ", factor=" + factor + '}';
    }
    
}
