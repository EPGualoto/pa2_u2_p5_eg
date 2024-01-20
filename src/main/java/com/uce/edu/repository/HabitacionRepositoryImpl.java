package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitacion);
	}

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Habitacion habi = this.seleccionar(id);
		this.entityManager.remove(habi);
	}

	@Override
	public Habitacion seleccionarPorClase(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Habitacion> myQuery = this.entityManager.createNamedQuery("Habitacion.queryBuscarPorClase", Habitacion.class);
		myQuery.setParameter("clase", clase);
		return myQuery.getSingleResult();
	}

	
}
