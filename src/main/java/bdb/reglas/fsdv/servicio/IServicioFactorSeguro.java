package bdb.reglas.fsdv.servicio;

import bdb.reglas.fsdv.entidades.RespuestaFSdV;
import bdb.reglas.fsdv.entidades.SolicitudFSdV;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IServicioFactorSeguro 
{
    @WebMethod
    @WebResult(name = "RespuestaFSdV")
    public RespuestaFSdV calcularFactorSeguroDeVida(@WebParam(name = "SolicitudFSdV") SolicitudFSdV solicitud);
}
