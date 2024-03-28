package bdb.reglas.fsdv.entidades;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement  //Sin anotaciones es de tipo json
public class RespuestaFSdV implements Serializable
{
    private static final long serialVersionUID = 1L;
 
    private int respuesta;
    private String descripcion;
    private double factor; 

    public RespuestaFSdV() {
    }

    public RespuestaFSdV(int respuesta, String descripcion, double factor) {
        this.respuesta = respuesta;
        this.descripcion = descripcion;
        this.factor = factor;
    }

    
    
    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "RespuestaFSdV{" + "respuesta=" + respuesta + ", descripcion=" + descripcion + ", factor=" + factor + '}';
    }
        
}
