package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;

public interface ICiudadanoService {
	
	public Ciudadano buscar(Integer id);
	
	public void insertar(Ciudadano ciudadano);
	
	public void actualizar(Ciudadano ciudadano);
	
	public void eliminar(Integer id);
}
