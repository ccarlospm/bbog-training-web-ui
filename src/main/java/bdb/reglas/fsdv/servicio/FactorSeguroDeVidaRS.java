package bdb.reglas.fsdv.servicio;

import bdb.reglas.fsdv.entidades.RespuestaFSdV;
import bdb.reglas.fsdv.entidades.SolicitudFSdV;
import bdb.reglas.fsdv.sesionesDao.ISeguroDeVidaDao;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/factorsegurodevida")
@Stateless
public class FactorSeguroDeVidaRS {

   @Inject
   private ISeguroDeVidaDao seguroDeVidaDao;
   
   @GET
   @Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
   public RespuestaFSdV calcularFactorSeguroDeVidaRS(SolicitudFSdV solicitud) {
        System.out.println("Entra al Rest WebService ");
        return seguroDeVidaDao.calcularFactorSeguroDeVida(solicitud);
        
    }
}
