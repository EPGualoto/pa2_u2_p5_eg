package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner{	
	
	@Autowired
	private ILibroService libroService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Insertar:
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
	}
}