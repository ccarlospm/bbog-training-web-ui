package bdb.reglas.fsdv.entidades;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SolicitudFSdV implements Serializable
{

    private static final long serialVersionUID = 1L;
    
    private String fechanacimiento;
    private String fechaActual;
    private String tipoProducto;

    public SolicitudFSdV() {
    }

    public SolicitudFSdV(String fechanacimiento, String fechaActual, String tipoProducto) {
        this.fechanacimiento = fechanacimiento;
        this.fechaActual = fechaActual;
        this.tipoProducto = tipoProducto;
    }

    
    
    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "fechanacimiento=" + fechanacimiento + ", fechaActual=" + fechaActual + ", tipoProducto=" + tipoProducto + '}';
    }
    
}
