package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		//Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :variable AND l.fecha = :variable2");
		Query myQuery = this.entityManager.createQuery("SELECT l  FROM Libro l WHERE l.titulo = : variable ");
		// variable va reemplazar en nombre
		myQuery.setParameter("variable", nombre);
		// myQuery.setParameter("variable2", nombre); --> en el caso de tener 2 variables.
		return (Libro) myQuery.getSingleResult();
	}

}
