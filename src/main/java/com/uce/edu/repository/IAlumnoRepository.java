package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoRepository {
	// CRUD
	public Alumno seleccionar(Integer id);

	public void insertar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public void eliminar(Integer id);
	
	//TypedQuery
	public List <Alumno> seleccionarPorNombre(String nombre);
	

}
