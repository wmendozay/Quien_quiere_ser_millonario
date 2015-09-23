/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bases;

/**
 *
 * @author sistemas
 */
public class Persona {
    private String Nombre;
	private String Correo;
	private Integer Edad;
	private String TipoUsuario;
        
        //setters
	public void setNombre(String value)
	{
		this.Nombre=value;
	}
	
	public void setCorreo(String value)
	{
		this.Correo=value;
	}
	
	public void setEdad(Integer value)
	{
		this.Edad=value;
	}
	
	public void setTipoUsuario(String value)
	{
		this.TipoUsuario=value;
	}
	
	//getters
	public String getNombre()
	{
		return this.Nombre;
	}
	
	public String getCorreo()
	{
		return this.Correo;
	}
	
	public Integer getEdad()
	{
		return this.Edad;
	}
	
	public String getTipoUsuario()
	{
		return this.TipoUsuario;
	}
}
