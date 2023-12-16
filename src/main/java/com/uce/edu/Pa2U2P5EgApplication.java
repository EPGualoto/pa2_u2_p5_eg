package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner{
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IAlumnoService alumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
			//Seleccionar:
			/*Estudiante estu = new Estudiante();
			estu.setNombre("Paola");
			estu.setApellido("Tigrero");
			estu.setCedula("24596851");
			estu.setFechaNacimiento(LocalDateTime.of(1999, 11, 10, 01, 50));
			//estu.setId(10);
			this.estudianteService.registrar(estu);	
			
			//Buscar:
			Estudiante estu1 = this.estudianteService.buscar(1);
			System.out.println(estu1);
			
			//Actualizar:
			Estudiante estu2 = this.estudianteService.buscar(2);
			System.out.println(estu2);
			estu2.setNombre("Paulina");
			this.estudianteService.actualizar(estu2);*/	
			
			//Eliminar:
			//this.estudianteService.eliminar(3);
			
			
			
			//-------------------------------------------
			//Insertar alumno:
			Alumno alumn = new Alumno();
			alumn.setNombre("Gabriel");
			this.alumnoService.registrar(alumn);
			
		
			//Buscar Alumno:
			Alumno alumn1 = this.alumnoService.buscar(2);
			System.out.println(alumn1);
			
			
			//Actualizar Alumno:
			Alumno alumn2 = this.alumnoService.buscar(3);
			System.out.println(alumn2);
			alumn2.setNombre("Bolivar");
			this.alumnoService.actualizar(alumn2);
			
			//Eliminar Alumno:
			this.alumnoService.eliminar(5);
			
	}

}
