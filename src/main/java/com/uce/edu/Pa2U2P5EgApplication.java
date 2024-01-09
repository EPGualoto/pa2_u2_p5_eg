package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		Libro2 libro = new Libro2();
		libro.setTitulo("Java");
		libro.setFechaPublicacion(LocalDateTime.now());

		Autor2 autor1 = new Autor2();
		autor1.setNombre("Erika Gualoto");
		autor1.setNacionalidad("Ecuatoriana");

		Autor2 autor2 = new Autor2();
		autor2.setNombre("Paola Tigrero");
		autor2.setNacionalidad("Ecuatoriana");

		List<Autor2> autores = new ArrayList<Autor2>();
		autores.add(autor1);
		autores.add(autor2);

		// crear una instancia para setear autor y libro
		// *Segunda forma para agregar columnas si se lo requiere.
		// *Primera forma cuando ya están designados.
		AutorLibro autorLibro1 = new AutorLibro();
		autorLibro1.setLibro2(libro);
		autorLibro1.setAutor2(autor1);
		autorLibro1.setFecha(LocalDateTime.now());

		AutorLibro autorLibro2 = new AutorLibro();
		autorLibro2.setLibro2(libro);
		autorLibro2.setAutor2(autor2);
		autorLibro2.setFecha(LocalDateTime.now());

		List<AutorLibro> lista = new ArrayList<AutorLibro>();
		lista.add(autorLibro1);
		lista.add(autorLibro2);

		libro.setAutoresLibros(lista);

		//this.libroService.guardar(libro);
		Libro libroFinal = this.libroService.buscarPorNombre("Java");
		System.out.println(libroFinal);
	}
}