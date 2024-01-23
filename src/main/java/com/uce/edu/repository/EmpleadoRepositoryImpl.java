package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

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
		TypedQuery<Empleado> myQuery = this.entityManager.createNamedQuery("Empleado.queryBuscarPorSalario",
				Empleado.class);
		myQuery.setParameter("salario", salario);
		return myQuery.getResultList();
	}

	@Override
	public Empleado seleccionarPoSalarioC(BigDecimal salario) {
		// TODO Auto-generated method stub
		// SELECT e FROM Empleado e WHERE e.salario =: variable

		// 0.Creamos una instancia de la interfaz CriteriaBuilder a partir de un Entity
		// Manager
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

		// 1. Determinamos el tipo de retorno que va ha tener mi consulta.
		CriteriaQuery<Empleado> myCriteriaQuery = myCriteriaBuilder.createQuery(Empleado.class);

		// 2.Construimos el SQL
		// 2.1 Determinamos el from(Root)
		Root<Empleado> myFrom = myCriteriaQuery.from(Empleado.class);

		// 2.2Construir las condiciones del (WHERE)
		// c.salario =: variable
		Predicate condicionSalario = myCriteriaBuilder.equal(myFrom.get("salario"), salario);

		// 3. Construimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionSalario);

		// 4. Ejecutamos la consulta con un TypedQuery
		TypedQuery<Empleado> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}
}
