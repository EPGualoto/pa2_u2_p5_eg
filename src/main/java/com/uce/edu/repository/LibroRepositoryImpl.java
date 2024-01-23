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
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public Libro seleccionarPorFechaC(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		//0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		//1. Determinamos el tipo de retorno que ya ha tener mi consulta.
		CriteriaQuery<Libro> myCriteriaQuery = myCriteriaBuilder.createQuery(Libro.class);
		
		//2.Construimos el SQL
		//2.1 Determinamos el from(Root)
		//Nota: No necesariamente el from es igual al tipo de retorno
		Root<Libro> myFrom = myCriteriaQuery.from(Libro.class); //FROM Ciudadano c
		
		//2.2Construir las condiciones (WHERE)SQL
		//En criteria API Query las condiciones se las conoce como "Predicate"
		
		//c.fechaPublicacion =: variable
		Predicate condicionfecha = myCriteriaBuilder.equal(myFrom.get("fechaPublicacion"), fechaPublicacion);
		
		//3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionfecha);
		
		//4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Libro> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}
}
