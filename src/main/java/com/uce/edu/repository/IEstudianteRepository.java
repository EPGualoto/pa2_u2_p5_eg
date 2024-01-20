package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	// CRUD
	public Estudiante seleccionar(Integer id);

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
	
	//NamedQuery
	public List <Estudiante> seleccionarPorFechaNacimiento(LocalDateTime fechaNacimiento);
	

}
