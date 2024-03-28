package bdb.reglas.fsdv.sesionesDao;

import bdb.reglas.fsdv.entidades.RespuestaFSdV;
import bdb.reglas.fsdv.entidades.SeguroDeVida;
import bdb.reglas.fsdv.entidades.SolicitudFSdV;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import org.apache.logging.log4j.*;

@Stateless
public class SeguroDeVidaImpl implements ISeguroDeVidaDao
{

    @PersistenceContext(unitName="ReglasBD")
    EntityManager em;
        
    @Override
    public List<SeguroDeVida> finaAllFactorSeguroDeVida() {
        return em.createNamedQuery("SeguroDeVida.findAll").getResultList();
        //return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public RespuestaFSdV calcularFactorSeguroDeVida(SolicitudFSdV SolicitudFSdV) 
    {
        System.out.println("calcularFactorSeguroDeVida() inicio");
        String formatoValido = validarFormatoFecha(SolicitudFSdV);
        int edadInt;
        RespuestaFSdV respuestaFSdV = new RespuestaFSdV();
        double factor = 0;

        System.out.println("formatoValido:" + formatoValido);
        if (formatoValido.equals("S"))
        {
            System.out.println("calcularEdad:");
            String edad = calcularEdad(SolicitudFSdV);
            System.out.println("calcularEdad: " + edad);
            try
            {
              //String longString = "-855er";
              
              edadInt = Integer.parseInt(edad);
              System.out.println("Valor long es " + edadInt);
              if( edadInt >= 0 )
              {
                  System.out.println("Obteniendo el factor:");
                  factor = obtenerFactorSeguro(SolicitudFSdV, edadInt);
                  System.out.println("Factor:" + factor);
                  
                  if ( factor == -1 )
                  {
                        respuestaFSdV.setRespuesta(-4);
                        respuestaFSdV.setDescripcion("No hay Factor para los datos ingresados, por favor revisar.");
                        //respuestaFSdV.setFactor(factor);
                        return respuestaFSdV;
                  }
                  else
                  {
                    respuestaFSdV.setRespuesta(0);
                    respuestaFSdV.setDescripcion("Operacion exitosa");
                    respuestaFSdV.setFactor(factor);
                    return respuestaFSdV;
                  }
              }
              else
              {
                    respuestaFSdV.setRespuesta(-2);
                    respuestaFSdV.setDescripcion("El valor de las fechas no es valido, la fecha de nacimiento debe ser menor a la fecha actual.");
                    return respuestaFSdV;
              }
              
            }
            catch(NumberFormatException | NullPointerException e )
            {
                System.err.println("Error al convertir: " + e);
                respuestaFSdV.setRespuesta(-3);
                respuestaFSdV.setDescripcion(edad);
                return respuestaFSdV;
            }
            
        }
        else
        {
            //Formato defechas no valido
            respuestaFSdV.setRespuesta(-1);
            respuestaFSdV.setDescripcion("El formato de las fechas no es valido, este debe ser AAAA-MM-DD.");
            return respuestaFSdV;
            
        }
        
       // return factor;
    }
    
    private String validarFormatoFecha(SolicitudFSdV SolicitudFSdV)
    {
        if ( SolicitudFSdV.getFechaActual().matches("\\d{4}([\\-.])(0?[1-9]|1[0-2])\\1(3[01]|[12][0-9]|0?[1-9])") )
        {
            if ( !SolicitudFSdV.getFechanacimiento().matches("\\d{4}([\\-.])(0?[1-9]|1[0-2])\\1(3[01]|[12][0-9]|0?[1-9])") )
            {
                return "N";
            }
        }
        else 
        {
            return "N";
        }
        
        return "S";
    }
    
    private String calcularEdad(SolicitudFSdV SolicitudFSdV)
    {
        try
        {
            LocalDate fechaNacimiento = LocalDate.parse(SolicitudFSdV.getFechanacimiento() );
            LocalDate fechaActual = LocalDate.parse(SolicitudFSdV.getFechaActual() );
            long dif = fechaNacimiento.until(fechaActual, ChronoUnit.YEARS);
            System.err.println("La edad es: " + dif);            
            return Long.toString(dif);
        }
        catch(java.time.DateTimeException e)
        {
            System.out.println("Error en el formato de la fecha " + e.getMessage());                    
            return "Error en el formato de la fecha " + e.getMessage();
        }
    } 
    
    private double obtenerFactorSeguro(SolicitudFSdV SolicitudFSdV, int edad)
    {
    
        System.out.println("Ingresa al WS - calcularFactorSeguroDeVida del DAO");
        List<SeguroDeVida> lSeguroDeVida = finaAllFactorSeguroDeVida();
        String jpql = null;
        Query q = null;
        
        System.out.println("FOR");
        for(SeguroDeVida sv: lSeguroDeVida)
        {
            System.out.println(sv);
        }
        
        System.out.println("Obtiene el objeto persona con id igual al parametro proporcionado");
        
        //jpql = "select sv from SeguroDeVida sv where sv.edad =:edad AND sv.tipoProducto =:sv.tipoProducto";
        jpql = "select sv from SeguroDeVida sv where sv.edad =:edad AND sv.tipoProducto LIKE :tipoProducto";
        q = em.createQuery(jpql);      
        q.setParameter("edad", edad);
        q.setParameter("tipoProducto", SolicitudFSdV.getTipoProducto() );
        try
        {
            SeguroDeVida seguroDeVida = new SeguroDeVida();
            seguroDeVida = (SeguroDeVida) q.getSingleResult();
         
            System.out.println("seguroDeVida: " + seguroDeVida);
            return Double.parseDouble(seguroDeVida.getFactor()) ;
        } 
        catch(NoResultException e)  
        {
            return -1;
        }
    
    }
}
