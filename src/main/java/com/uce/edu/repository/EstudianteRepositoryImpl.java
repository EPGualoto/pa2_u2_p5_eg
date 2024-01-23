package com.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estu = this.seleccionar(id);
		this.entityManager.remove(estu);
	}

	@Override
	public List<Estudiante> seleccionarPorFechaNacimiento(LocalDateTime fechaNacimiento) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.queryBuscarPorFecha",
				Estudiante.class);
		myQuery.setParameter("fecha", fechaNacimiento);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionarPorFechaNacimientoC(String nombre, String cedula, LocalDateTime fechaNacimiento) {
		// TODO Auto-generated method stub
		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un EM
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1. Determinamos el tipo de retorno que ya ha tener mi consulta.
		CriteriaQuery<Estudiante> myCriteriaQuery = myCriteriaBuilder.createQuery(Estudiante.class);

		// 2 Contruir el SQL
		// 2.1 Determinamos el FROM
		Root<Estudiante> myFrom = myCriteriaQuery.from(Estudiante.class);

		// 2.2Construir las condiciones del (WHERE)
		Predicate condicionGenerica = null;

		if (fechaNacimiento.getYear() == 1999) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
		} else if (fechaNacimiento.getYear() == 1985) {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
		} else {
			condicionGenerica = myCriteriaBuilder.equal(myFrom.get("fechaNacimiento"), fechaNacimiento);
		}

		// 3. Construimos el SQL final.
		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		// 4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

}
