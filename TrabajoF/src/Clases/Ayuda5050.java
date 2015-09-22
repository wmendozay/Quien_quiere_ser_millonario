
package Clases;
import Bases.Acciones;
import Interfaces.IAccion; 
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Ayuda5050 extends Acciones implements IAccion {
    
    
    public Ayuda5050 ()
    {
        this.NombreAccion= "50 \ 50";
    }
        public void EjecutarAccion(Pregunta pregunta) {
    
    
                Random rnd = new Random();
		int nmAleatorio1=(int)(rnd.nextDouble() * 3 + 0);
		int nmAleatorio2=(int)(rnd.nextDouble() * 3 + 0);
		
		//mientras numero aleatorio 2 sea igual a num aleatorio 1, seguimos obteniendo un nuevo n�mero aleatorio
		while (nmAleatorio2==nmAleatorio1) {
			nmAleatorio2=(int)(rnd.nextDouble() * 3 + 0);
		}
		
		//procedemos a eliminar las 2 respuestas erroneas;
		pregunta.RespuestasIncorrectas.remove(nmAleatorio1);
		pregunta.RespuestasIncorrectas.remove(nmAleatorio2);
		
		
	}

	

}

