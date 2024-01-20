package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {
	// CRUD
	public void insertar(Libro libro);
	
	public Libro seleccionar(Integer id);
	
	public void actualizar(Libro libro);
	
	//public void actualizar(Libro2 libro);

	public void eliminar(Integer id);
	
	public void insertar(Libro2 libro);
	
	public Libro seleccionarPorNombre(String nombre);
	
	public List <Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion);
	
	//TypedQuery
	public Libro seleccionarPorTitulo(String titulo);
	
	public List <Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion);
	
	//NamedQuery
	public Libro seleccionarPorTituloNamed(String titulo);
	
	public List <Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion);
	
	//TypedQuery
	public Libro seleccionarPorAutor(String autor);
	
}
