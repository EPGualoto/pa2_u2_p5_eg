package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
	
	public Ciudadano buscar(Integer id);
	
	public void guardar(Ciudadano ciudadano);
	
	public void actualizar(Ciudadano ciudadano);
	
	public void eliminar(Integer id);
	
	public Empleado buscarPorCedula(String cedula);
	
	public Ciudadano buscarPorCedulaCiu(String cedula);
	
	//TypedQuery
	public Ciudadano buscarPorNombre(String nombre);
	
	//Criteria API Query
	public Ciudadano buscarPorApellido(String apellido);
	
	public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);
	
	public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);

}
