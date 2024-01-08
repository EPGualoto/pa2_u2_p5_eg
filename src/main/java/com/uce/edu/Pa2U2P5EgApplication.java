package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;

	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Insertar:
		Libro libro = new Libro();
		libro.setTitulo("Java");
		libro.setFechaPublicacion(LocalDateTime.now());

		Autor autor1 = new Autor();
		autor1.setNombre("Erika Gualoto");
		autor1.setNacionalidad("Ecuatoriana");

		Autor autor2 = new Autor();
		autor2.setNombre("Paola Tigrero");
		autor2.setNacionalidad("Ecuatoriana");

		Set<Autor> autores = new HashSet<Autor>();
		autores.add(autor1);
		autores.add(autor2);
		libro.setAutores(autores);

		Set<Libro> libros = new HashSet<Libro>();
		libros.add(libro);
		autor1.setLibros(libros);
		autor2.setLibros(libros);

		this.libroService.guardar(libro);

		// Insertar2:
		Libro libro1 = new Libro();
		libro1.setTitulo("Pinocho");
		libro1.setFechaPublicacion(LocalDateTime.now());

		Autor a1 = new Autor();
		a1.setNombre("Paulina Herrera");
		a1.setNacionalidad("Colombiana");

		Autor a2 = new Autor();
		autor2.setNombre("Gabriel Teran");
		autor2.setNacionalidad("Mexicano");

		Set<Autor> autores1 = new HashSet<Autor>();
		autores1.add(a1);
		autores1.add(a2);
		libro1.setAutores(autores1);

		Set<Libro> libros1 = new HashSet<Libro>();
		libros1.add(libro1);
		a1.setLibros(libros1);
		a2.setLibros(libros1);

		this.libroService.guardar(libro1);

		Libro l1 = this.libroService.buscar(14);
		l1.setTitulo("Viaje al centro de la tierra");
		this.libroService.actualizar(l1);
		System.out.println(l1);

		this.libroService.eliminar(18);

		Autor au3 = this.autorService.buscar(9);
		au3.setNacionalidad("Española");
		this.autorService.actualizar(au3);
		System.out.println(au3);
		
		this.autorService.eliminar(20);
		this.libroService.eliminar(22);
	}
}