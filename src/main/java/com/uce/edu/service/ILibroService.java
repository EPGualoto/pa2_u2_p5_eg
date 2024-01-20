package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {
	// CRUD
	public void guardar(Libro libro);

	public Libro buscar(Integer id);

	public void actualizar(Libro libro);

	public void eliminar(Integer id);
	
	public void guardar(Libro2 libro);
	
	public Libro buscarPorNombre(String nombre);
	
	public List <Libro> buscarPorfecha(LocalDateTime fecha);
	
	//TypedQuery
	public Libro buscarPorTitulo(String titulo);
	
	public List <Libro> buscarPorFechaPubli(LocalDateTime fechaPublicacion);
	
	//NamedQuery
	public Libro buscarPorTituloNamed(String titulo);
		
	public List <Libro> buscarPorFechaNamed(LocalDateTime fechaPublicacion);
	
	//TypedQuery
	public Libro buscarPorAutor(String autor);
}
