package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public Libro seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Libro.class, id);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(libro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Libro libro = this.seleccionar(id);
		this.entityManager.remove(libro);
	}

	@Override
	public void insertar(Libro2 libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
	}

	@Override
	public Libro seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM libro l WHERE l.lbr_titulo = ?
		// JPQL: SELECT l FROM Libro l WHERE l.titulo = :variable
		// Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE
		// l.titulo = :variable AND l.fecha = :variable2");
		Query myQuery = this.entityManager.createQuery("SELECT l  FROM Libro l WHERE l.titulo = : variable ");
		// variable va reemplazar en nombre
		myQuery.setParameter("variable", nombre);
		// myQuery.setParameter("variable2", nombre); --> en el caso de tener 2
		// variables.
		// return (Libro) myQuery.getResultList().get(0); 0 es la posición
		return (Libro) myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM Libro l WHERE l.lbr_fecha_publicacion >= ?
		// JPQL: SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha
		Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha");
		myQuery.setParameter("fecha", fechaPublicacion);
		return (List<Libro>) myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l  FROM Libro l WHERE l.titulo = : titulo ",
				Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager
				.createQuery("SELECT l FROM Libro l WHERE l.fechaPublicacion >= :fecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
		myQuery.setParameter("titulo", titulo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
		myQuery.setParameter("fecha", fechaPublicacion);
		return myQuery.getResultList();
	}

	@Override
	public Libro seleccionarPorAutor(String autor) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l  FROM Libro l WHERE l.autor = : autor ",
				Libro.class);
		myQuery.setParameter("autor", autor);
		return myQuery.getSingleResult();
	}
}
