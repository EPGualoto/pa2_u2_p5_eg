package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	// CRUD
	public Ciudadano seleccionar(Integer id);
	
	public void insertar(Ciudadano ciudadano);
	
	public void actualizar(Ciudadano ciudadano);
	
	public void eliminar(Integer id);
	
	public Empleado seleccionarPorCedula(String cedula);
	
	public Ciudadano seleccionarPorCedulaCiu(String cedula);
	
	//TypeQuery
	public Ciudadano seleccionarPorNombre(String nombre);
	
	//Criteria API Query
	public Ciudadano seleccionarPorApellido(String apellido);
	
	//Funcionalidad que cuando sea el ciudadano de Pichincha lo busque por nombre.
	//Cuando sea de Cotopaxi lo busque por apellido
	//Cuando no sea ni de Cotopaxi ni de Pichincha lo busque por cedula.
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);

	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);

}
