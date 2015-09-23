/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author sistemas
 */
public class WriteFile {
    
    private String ruta;
	private boolean adjuntar_al_archivo=false;
	
	public WriteFile(String ruta_archivo)
	{
		ruta=ruta_archivo;
	}
	
	public WriteFile(String ruta_archivo, boolean adjuntar_valores)
	{
		ruta=ruta_archivo;
		adjuntar_al_archivo=adjuntar_valores;
	}
	
	public void writeToFile(String texto) throws IOException 
	{
		FileWriter writer=new FileWriter (ruta, adjuntar_al_archivo);
		PrintWriter print_line=new PrintWriter(writer);
		
		print_line.printf("%s" + "%n",texto);
		
		print_line.close();
	}
}
