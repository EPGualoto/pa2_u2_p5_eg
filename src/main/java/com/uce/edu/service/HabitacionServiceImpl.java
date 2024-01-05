package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {
	@Autowired
	private IHabitacionRepository iHabitacionRepository;

	@Override
	public void guardar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.iHabitacionRepository.insertar(habitacion);
	}

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHabitacionRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.iHabitacionRepository.actualizar(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iHabitacionRepository.eliminar(id);
	}

}
