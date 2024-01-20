package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAlumnoRepository;
import com.uce.edu.repository.modelo.Alumno;

@Service
public class AlumnoService implements IAlumnoService {
	@Autowired
	private IAlumnoRepository iAlumnoRepository;

	@Override
	public Alumno buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iAlumnoRepository.seleccionar(id);
	}

	@Override
	public void registrar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.insertar(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.actualizar(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iAlumnoRepository.eliminar(id);
	}

	@Override
	public List<Alumno> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iAlumnoRepository.seleccionarPorNombre(nombre);
	}
	
	

}
