package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelRepository {
	// CRUD
	public void insertar(Hotel hotel);
		
	public Hotel seleccionar(Integer id);
	
	public void actualizar(Hotel hotel);

	public void eliminar(Integer id);
	
	public Hotel seleccionarPorDireccion(String direccion);
	
	//Criteria API Query
	//Funcionalidad que cuando la dirección del hotel comience con un numero lo busque por nombre.
	//Caso contrario lo busque por la direccion.
	public Hotel seleccionarPorDireccionC(String nombre, String direccion);
}
