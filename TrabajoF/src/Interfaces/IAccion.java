package Interfaces;

/**
 *
 * @author Daihana Vélez
 */

//SE IMPORTAN CLASES DEL PAQUETE "Clases"
import Clases.Pregunta;

//INTERFAZ IAccion
public interface IAccion {
    //SE DEFINE EL METODO "EjecutarAccion" NECESITANDO COMO PARAMETRO DE ENTRADA UN OBJETO DE TIPO PREGUNTA
    public void EjecutarAccion(Pregunta pregunta);
}
