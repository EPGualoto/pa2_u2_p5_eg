package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private ILibroService libroService;
	
	@Autowired
	private IAlumnoService alumnoService;
	
	@Autowired
	private IHotelService hotelService;

	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IAutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("TypedQuery");
		Ciudadano c1 = this.ciudadanoService.buscarPorNombre("Gabriel");
		System.out.println(c1);
		
		List<Alumno> lista = this.alumnoService.buscarPorNombre("Emilio");
		for (Alumno alumno : lista) {
			System.out.println(alumno);
		}
		
		Hotel h1 = this.hotelService.buscarPorDireccion("Shirys");
		System.out.println(h1);
		
		Libro l1 = this.libroService.buscarPorTitulo("LA");
		System.out.println(l1);
		
		List<Empleado> listae = this.empleadoService.buscarPorFechaIngreso(LocalDateTime.of(2024, 01, 16, 20, 42));
		for (Empleado empleado : listae) {
			System.out.println(empleado);
		}
		
		System.out.println("NamedQuery");
		Habitacion ha1 = this.habitacionService.buscarPorClase("VIP");
		System.out.println(ha1);
		
		List<Estudiante> lista2 = this.estudianteService.buscarPorFechaNacimiento(LocalDateTime.of(2000, 1, 1, 7, 15));
		for (Estudiante estudiante : lista2) {
			System.out.println(estudiante);
		}
		
		Autor a = this.autorService.buscarPorNacionalidad("Peruana");
		System.out.println(a);
		
		List<Empleado> listae2 = this.empleadoService.buscarPorSalario(new BigDecimal(10));
		for (Empleado empleado2 : listae2) {
			System.out.println(empleado2);
		}
		
		Ciudadano c2 = this.ciudadanoService.buscarPorApellido("Guaman");
		System.out.println(c2);
		
		
	}
}