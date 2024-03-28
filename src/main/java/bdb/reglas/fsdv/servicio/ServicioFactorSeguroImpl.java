package bdb.reglas.fsdv.servicio;

import bdb.reglas.fsdv.entidades.RespuestaFSdV;
import bdb.reglas.fsdv.entidades.SolicitudFSdV;
import bdb.reglas.fsdv.sesionesDao.ISeguroDeVidaDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

                                 
@WebService(endpointInterface = "bdb.reglas.fsdv.servicio.IServicioFactorSeguro")
@Stateless
public class ServicioFactorSeguroImpl implements IServicioFactorSeguro{

    @EJB
    private ISeguroDeVidaDao seguroDeVidaDao;
    
    //static Logger log = LogManager.getRootLogger();
    
    @Override
    public RespuestaFSdV calcularFactorSeguroDeVida(SolicitudFSdV solicitud) {
      //  log.debug("Ingresa al WS - calcularFactorSeguroDeVida");
        System.out.println("Entra al Web service 0");
        return seguroDeVidaDao.calcularFactorSeguroDeVida(solicitud);
        //return 0.44454;
    }


    
}
