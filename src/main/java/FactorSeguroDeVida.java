
import bdb.reglas.fsdv.entidades.SolicitudFSdV;
import bdb.reglas.fsdv.servicio.ServicioFactorSeguroImpl;
import bdb.reglas.fsdv.servicio.IServicioFactorSeguro;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class FactorSeguroDeVida {

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
      /*  
        String fecha1 = "2024-02-31";
        String fecha2 = "1938-13-31";
        //String fecha2 = "2019-05-30";
        
        if ( fecha1.matches("\\d{4}([\\-.])(0?[1-9]|1[0-2])\\1(3[01]|[12][0-9]|0?[1-9])") )
        {
            if ( !fecha2.matches("\\d{4}([\\-.])(0?[1-9]|1[0-2])\\1(3[01]|[12][0-9]|0?[1-9])") )
            {
                System.out.println("No");
            }
        }
        else 
        {
            System.out.println("No");
        }
        
        System.out.println("SI y SI Cumple formato");
*/
      /*
      try
      {
        String longString = "-855er";
        int valor;
        valor = Integer.parseInt(longString);
          System.out.println("Valor long es " + valor);
      }
      catch(NumberFormatException | NullPointerException e )
      {
          System.err.println("Error al convertir: " + e);
      }
        */    
            
      /*
        String fecha1 = "2024-02-28";
        String fecha2 = "1938-12-31";
        try
        {
            LocalDate ld1 = LocalDate.parse(fecha1);
            LocalDate ld2 = LocalDate.parse(fecha2);
            long dif = ld1.until(ld2, ChronoUnit.YEARS);
            System.err.println("La edad es: " + dif);            
        }
        catch(java.time.DateTimeException e)
        {
            System.out.println("Error en el formato de la fecha " + e.getMessage());                    
        }
        */

       // IServicioFactorSeguro sv = new ServicioFactorSeguroImpl();
       // SolicitudFSdV solicitud = new SolicitudFSdV();
        
        //double valor = sv.calcularFactorSeguroDeVida(solicitud);
        /*
        System.err.println("El valor es: " + valor);
        */
    }
}
