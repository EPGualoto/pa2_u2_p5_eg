package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService {
	@Autowired
	private IEmpleadoRepository iEmpleadoRepository;

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.iEmpleadoRepository.insertar(empleado);
	}

}
