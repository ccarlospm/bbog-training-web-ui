/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bdb.reglas.fsdv.sesionesDao;

import bdb.reglas.fsdv.entidades.RespuestaFSdV;
import bdb.reglas.fsdv.entidades.SeguroDeVida;
import bdb.reglas.fsdv.entidades.SolicitudFSdV;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author C_CAR
 */
@Local
public interface ISeguroDeVidaDao {
    
    public List<SeguroDeVida>  finaAllFactorSeguroDeVida();
    
    public RespuestaFSdV calcularFactorSeguroDeVida(SolicitudFSdV SolicitudFSdV);
}
