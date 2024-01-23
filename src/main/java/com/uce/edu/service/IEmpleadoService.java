package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {

	public Empleado buscar(Integer id);

	public void guardar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);

	// TypedQuery
	public List<Empleado> buscarPorFechaIngreso(LocalDateTime fechaIngreso);

	// NamedQuery
	public List<Empleado> buscarPorSalario(BigDecimal salario);

	// Criteria API Query
	public Empleado buscarPoSalarioC(BigDecimal salario);
}
