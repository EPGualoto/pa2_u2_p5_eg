package com.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	// CRUD
	public Empleado seleccionar(Integer id);

	public void insertar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);

	// TypedQuery
	public List<Empleado> seleccionarPorFechaIngreso(LocalDateTime fechaIngreso);

	// NamedQuery
	public List<Empleado> seleccionarPorSalario(BigDecimal salario);

	// Criteria API Query
	public Empleado seleccionarPoSalarioC(BigDecimal salario);
}
