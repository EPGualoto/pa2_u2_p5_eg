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

	// NamedQuery
	public List<Estudiante> seleccionarPorFechaNacimiento(LocalDateTime fechaNacimiento);

	// Funcionalidad que cuando sea el estudiante nacio en 1999 lo busque por
	// nombre.
	// Cuando sea de 1985 lo busque por cedula.
	// Cuando no sea ni de 1999 ni de 1985 lo busque por la fecha de naciemiento.
	public Estudiante seleccionarPorFechaNacimientoC(String nombre, String cedula, LocalDateTime fechaNacimiento);
}
