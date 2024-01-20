package com.uce.edu.service;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {
	//CRUD
	public void guardar(Hotel hotel);
	
	public Hotel buscar(Integer id);
		
	public void actualizar(Hotel hotel);
	
	public void eliminar(Integer id);
	
	public Hotel buscarPorDireccion(String direccion);
}
