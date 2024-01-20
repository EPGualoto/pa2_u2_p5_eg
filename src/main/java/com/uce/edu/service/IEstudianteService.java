package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteService {
	public Estudiante buscar(Integer id);
	
	public void registrar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public void eliminar(Integer id);
	
	//NamedQuery
	public List <Estudiante> buscarPorFechaNacimiento(LocalDateTime fechaNacimiento);
		
}
