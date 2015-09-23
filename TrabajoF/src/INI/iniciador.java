package INI;
/**
 *
 * @author Daihana Vélez
 */

//SE IMPORTAN LAS LIBRERIAS
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Clases.Ayuda5050;
import Clases.Pregunta;
import Clases.WriteFile;
import Clases.lee_fichero;

//CLASE "PPAL"
public class iniciador {
            //PARA GUARDAR LAS PREGUNTAS
    
             /*SE DEFINEN UNA LISTA "listaPreguntas" MEDIANTE LA ESTRUCTURA DEL TIPO ARRAYLIST 
            QUE SOLO ALMACENARÁ OBJETOS DE TIPO PREGUNTAS*/
            List<Pregunta> listaPreguntas=new ArrayList<Pregunta>();
            
           //SE DEFINEN UNA LISTA "rutaspreguntas" MEDIANTE QUE SOLO ALMACENARÁ OBJETOS DE TIPO STRING
           List<String> rutaspreguntas = new ArrayList<String>();
           
           /*SE CARGA LA ESTRUCTURA CREADA ANTERIOR/ CON DATOS, UTILIZANDO EL METODO .add("Elemento")
           PARA ESTE CASO SE CARGAN 3 ELEMENTOS, LOS CUALES SON LAS RUTAS LOCALES DONDE SE ENCUENTRAN LAS PREGUNTAS
           DEFINIDAS POR TEMATICAS CON FORMATO .txt*/
           
           //RUTA LOCAL DEL ARCHIVO SOBRE PREGUNTAS DE HISTORIA
           C:\Users\Dadi\Documents\NetBeansProjects\TrabajoF\Preguntas\historia.txt
           rutaspreguntas.add("C:\\Users\\Dadi\\Documents\\NetBeansProjects\\TrabajoF\\Preguntas\\historia.txt");
           //RUTA LOCAL DEL ARCHIVO SOBRE PREGUNTAS DE MATEMATICAS
           rutaspreguntas.add("C:\\Users\\Dadi\\Documents\\NetBeansProjects\\TrabajoF\\Preguntas\\matematicas.txt");
           //RUTA LOCAL DEL ARCHIVO SOBRE PREGUNTAS DE CULTURA GENERAL
           rutaspreguntas.add("C:\\Users\\Dadi\\Documents\\NetBeansProjects\\TrabajoF\\Preguntas\\culturaGeneral.txt");
		
           //DECLARACIÓN DE LA VBLE "ruta" QUE ALMACENARÁ INFORMACIÓN DE TIPO STRING
           String ruta="";
           
           //SE RECORRE EL ARRAYLIST "rutapreguntas" MEDIANTE UN BUCLE FOR HASTA SU TAMAÑO SEA INFERIOR A LO CONTENIDO EN "i"
           for (int i = 0; i < rutaspreguntas.size(); i++) {
           ruta=rutaspreguntas.get(i);
           listaPreguntas.addAll(lee_fichero.main(ruta));
           }
		
           //SIMULAR AYUDA 50/50
           //SE INSTANCIA UN OBJETO "objayuda" de tipo AYUDA5050
           Ayuda5050 objayuda=new Ayuda5050();
           objayuda.EjecutarAccion(listaPreguntas.get(1));
}
