package com.uce.edu.service;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionService {
	//CRUD
	public void guardar(Habitacion habitacion);
	
	public Habitacion buscar(Integer id);
	
	public void actualizar(Habitacion habitacion);
	
	public void eliminar(Integer id);

	
}
