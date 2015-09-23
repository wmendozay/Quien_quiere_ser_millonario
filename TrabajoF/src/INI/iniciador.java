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

//SE IMPORTAN CLASES DEL PAQUETE "Clases"
import Clases.Ayuda5050;
import Clases.Pregunta;
import Clases.WriteFile;
import Clases.lee_fichero;

//CLASE "iniciador"
public class iniciador {
    
        public static void main(String[] args) {
    
            //SE INSTANCIA UN OBJETO LLAMADO "datas" DE TIPO WRITEFILE
            WriteFile datas = new WriteFile("C:/Users/Dadi/Documents/NetBeansProjects/TrabajoF/Preguntas/ejemploescritura.txt",true);
		
            try {
            //CONTENIDO A ESCRIBIR EN EL ARCHIVO MEDIANTE LA UTILIZACIÓN DEL MÉTODO "writeToFile"
            datas.writeToFile("Esta es otra linea de texto");
            } catch (IOException e) {
                        //EL METODO printStackTrace() IMPRIME EL REGISTRO DEL STACK DONDE SE HA INICIADO LA EXCEPCIÓN
			e.printStackTrace();
            }
    
            //PARA GUARDAR LAS PREGUNTAS EN UNA SOLA LISTA
    
             /*SE DEFINEN UNA LISTA "listaPreguntas" MEDIANTE LA ESTRUCTURA DEL TIPO ARRAYLIST 
            QUE SOLO ALMACENARÁ OBJETOS DE TIPO PREGUNTAS*/
            List<Pregunta> listaPreguntas=new ArrayList<Pregunta>();
            
            //SE DEFINEN UNA LISTA "rutaspreguntas" MEDIANTE QUE SOLO ALMACENARÁ OBJETOS DE TIPO STRING
            List<String> rutaspreguntas = new ArrayList<String>();
            
            /*SE CARGA LA ESTRUCTURA CREADA ANTERIOR/ CON DATOS, UTILIZANDO EL METODO .add("Elemento")
           PARA ESTE CASO SE CARGAN 3 ELEMENTOS, LOS CUALES SON LAS RUTAS LOCALES DONDE SE ENCUENTRAN LAS PREGUNTAS
           DEFINIDAS POR TEMATICAS CON FORMATO .txt*/
           
           //RUTA LOCAL DEL ARCHIVO SOBRE PREGUNTAS DE HISTORIA
           rutaspreguntas.add("C:/Users/Dadi/Documents/NetBeansProjects/TrabajoF/Preguntas/historia.txt");
           //RUTA LOCAL DEL ARCHIVO SOBRE PREGUNTAS DE MATEMATICAS
           rutaspreguntas.add("C:/Users/Dadi/Documents/NetBeansProjects/TrabajoF/Preguntas/matematicas.txt");
           //RUTA LOCAL DEL ARCHIVO SOBRE PREGUNTAS DE CULTURA GENERAL
           rutaspreguntas.add("C:/Users/Dadi/Documents/NetBeansProjects/TrabajoF/Preguntas/culturaGeneral.txt");
		
           //DECLARACIÓN DE LA VBLE "ruta" QUE ALMACENARÁ INFORMACIÓN DE TIPO STRING
           String ruta="";
           
           /*SE RECORRE EL ARRAYLIST "rutapreguntas" MEDIANTE UN BUCLE FOR, CICLO QUE SE DETENDRÁ 
           HASTA QUE EL TAMAÑO DE LA LISTA SEA INFERIOR A LO CONTENIDO EN "i"*/
           for (int i = 0; i < rutaspreguntas.size(); i++) {
                
                //SE ALMACENA EN "ruta" LO CONTENIDO EN "rutapreguntas" EN SU POSICION "i"
                ruta=rutaspreguntas.get(i);
                //SE ALMACENA EN "listaPreguntas" LO RETORNADO DE LLAMAR A "lee_fichero.main" ENVIANDO COMO PARAMETRO A "ruta" 
                listaPreguntas.addAll(lee_fichero.main(ruta));
           }
		
           //SIMULAR AYUDA 50/50
           //SE INSTANCIA UN OBJETO "objayuda" DE TIPO AYUDA5050
           Ayuda5050 objayuda=new Ayuda5050();
           //SE IMPLEMENTA EL METODO "EjecutarAccion" TENIENDO COMO PARAMETRO LO CONTENIDO EN LA POSICION 1 DE "listaPreguntas"
           objayuda.EjecutarAccion(listaPreguntas.get(1));
        }
}
