package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}
	
	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Empleado empl = this.seleccionar(id);
		this.entityManager.remove(empl);
	}

	@Override
	public List<Empleado> seleccionarPorFechaIngreso(LocalDateTime fechaIngreso) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.fechaIngreso >= :fecha", Empleado.class);
		myQuery.setParameter("fecha", fechaIngreso);
		return myQuery.getResultList();
	}

	@Override
	public List<Empleado> seleccionarPorSalario(BigDecimal salario) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager.createNamedQuery("Empleado.queryBuscarPorSalario", Empleado.class);
		myQuery.setParameter("salario", salario);
		return myQuery.getResultList();
	}
}
