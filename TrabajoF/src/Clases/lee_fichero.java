/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sistemas
 */
public class lee_fichero {
     public static List<Pregunta> main(String ruta) {
    //almacenara la lista de preguntas
    List<Pregunta> listaPreguntas=new ArrayList<Pregunta>();
    
    try {
    	//se preapra el filereader y el buffer para la lectura
      FileReader fr = new FileReader(ruta);
      BufferedReader br = new BufferedReader(fr);
       String linea;          		 
       String tematica;
       //se define un nuevo file para obetener el nombre del archivo sin la extension
	   File obj=new File(ruta);
	   tematica=obj.getName().substring(0,obj.getName().length()-4);
	
       
       //mientras haya una linea para leer diferente de null
      while((linea = br.readLine()) != null)
      {
    	  String respuestaCorrecta="";
    	  int finalcomplejidad=linea.indexOf(";"); //define el indice donde termina la complejidad
          int finalpregunta=linea.indexOf(";",finalcomplejidad+1); //define el in dice donde termina la pregunta
          int iniciorespuestas=linea.indexOf("["); //define el indice donde comienzan las respuestas
          int finalrespuestas=linea.indexOf("]"); //define el indice donde terminan las respuestas
          
          String validacionrespuesta;

          String Complejidad=linea.substring(0, finalcomplejidad);//guarda el texto de la complejidad
          String TextoPregunta=linea.substring(finalcomplejidad +1, finalpregunta); //guarda el texto de la pregunta
          String TextoRespuestas=linea.substring(iniciorespuestas +1, finalrespuestas); //guarda el texto de las respuestas
          List<String> RespuestasErroneas=new ArrayList<String>(); //lista para almacenar las respuestas erroneas
          
          while (TextoRespuestas.indexOf(";")>0 | TextoRespuestas.length()>0) { //mientras textorespuestas tenga contenido
        	  int finalRespuesta=TextoRespuestas.lastIndexOf(";") ; //obtenemos el ultimo punto y coma dentro de las respuestas
        	  String respuesta="";
        	  if (finalRespuesta==-1) //si ya en el textoRespuestas no quedan ;
        	  {
        		  respuesta=TextoRespuestas.substring(0, TextoRespuestas.length()); //tomamos todo el contenido de texto respuestas
        		  validacionrespuesta=ValidarRespuestaCorrecta(respuesta); //validamos si es una respuesta correcta
            	  if (validacionrespuesta!=null)
            	  {
            		  respuestaCorrecta=validacionrespuesta;//en este caso es una respuesta correcta ya q devuevle el texto
            	  }
            	  else
            	  {
            		  RespuestasErroneas.add(respuesta); //cortamos desde el inicio hasta el �ltimo punto y coma encontrado, eliminado la respuesta obtenida.
            	  }
            	  TextoRespuestas=""; //dejamos en blanco TextoRespuestas ya que �ra la ultima respuesta a obtener
        		  break;
        	  }
        		  
        	  
        	  respuesta=TextoRespuestas.substring(finalRespuesta +1, TextoRespuestas.length()); //obtenemos la �ltima respuesta, desde el �ltimo punto y coma hasta el final del texto 
        	  validacionrespuesta=ValidarRespuestaCorrecta(respuesta); //validamos si la respuesta obtenida es la correca (q debe estar entre *)
        	  if (validacionrespuesta!=null)
        	  {
        		  respuestaCorrecta=validacionrespuesta; //en este caso es una respuesta correcta ya q devuevle el texto
        	  }
        	  else
        	  {
        		  RespuestasErroneas.add(respuesta);// en este caso es una respuesta incorrecta ya que no retorna nada.
        	  }
        	 
        	  
        	  TextoRespuestas=TextoRespuestas.substring(0 ,finalRespuesta);   //cortamos desde el inicio hasta el �ltimo punto y coma encontrado, eliminado la respuesta obtenida.
        	  
          }
          
          //creando la clase pregunta y asignando a cada propiedad lo obtenido en cada linea le�da
    	  Pregunta objPregunta=new Pregunta();
    	  objPregunta.RespuestaCorrecta=respuestaCorrecta;
    	  objPregunta.RespuestasIncorrectas.addAll(RespuestasErroneas);
    	  objPregunta.NivelComplejidad=Integer.parseInt(Complejidad);
    	  objPregunta.TextoPregunta=TextoPregunta;
    	  objPregunta.Tematica=tematica;
    	  listaPreguntas.add(objPregunta); //agregando el nuevo objeto a ListaPreguntas
      }
    	  
      
 
      fr.close();
    }
    catch(Exception e) {
      System.out.println("Excepcion leyendo fichero "+ ruta + ": " + e);
    }
	return listaPreguntas;
  }
  
  
  public static String ValidarRespuestaCorrecta(String respuesta)
  {
	  if(respuesta.contains("*")==true)
	  {
		  return  respuesta.substring(1, respuesta.length()-1);
	  }
	  else
	  {
		  return null;
	  }
	
 
  }
}
