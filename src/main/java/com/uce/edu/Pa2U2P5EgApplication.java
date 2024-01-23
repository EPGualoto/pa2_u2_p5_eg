package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private ILibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Criteria API Query
		System.out.println("Ejemplo 1");
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,e1_0.empl_id,e1_0.empl_fecha_ingreso,e1_0.empl_salario,c1_0.ciud_nombre 
		//from ciudadano c1_0 left join empleado e1_0 on c1_0.ciud_id=e1_0.empl_id_ciudadano where c1_0.ciud_id=?
		Empleado empl1 =this.empleadoService.buscarPoSalarioC(new BigDecimal(300));
		System.out.println(empl1);
		
		System.out.println("Ejemplo 2");
		//Hibernate: select e1_0.estu_id,e1_0.estu_apellido,e1_0.estu_cedula,e1_0.estu_fecha_nacimiento,e1_0.estu_nombre from estudiante e1_0 where e1_0.estu_nombre=?
		Estudiante est1= this.estudianteService.buscarPorFechaNacimientoC("Erika", "1718411745", LocalDateTime.of(1999, 1, 1, 0, 0));
		System.out.println(est1);
		
		//Hibernate: select e1_0.estu_id,e1_0.estu_apellido,e1_0.estu_cedula,e1_0.estu_fecha_nacimiento,e1_0.estu_nombre from estudiante e1_0 where e1_0.estu_cedula=?
		Estudiante est2= this.estudianteService.buscarPorFechaNacimientoC("Erika", "1709998916", LocalDateTime.of(1985, 1, 1, 0, 0));
		System.out.println(est2);
		
		//Hibernate: select e1_0.estu_id,e1_0.estu_apellido,e1_0.estu_cedula,e1_0.estu_fecha_nacimiento,e1_0.estu_nombre from estudiante e1_0 where e1_0.estu_fecha_nacimiento=?
		Estudiante est3= this.estudianteService.buscarPorFechaNacimientoC("Erika", "1718411745", LocalDateTime.of(1998, 8, 27, 0, 0));
		System.out.println(est3);
		
		System.out.println("Ejemplo 3");
		//Hibernate: select h1_0.hote_id,h1_0.hote_direccion,h1_0.hote_nombre from hotel h1_0 where h1_0.hote_nombre=?
		Hotel h1 = this.hotelService.buscarPorDireccionC("Luna Azul", "5 de Diciembre");
		System.out.println(h1);
		
		//Hibernate: select h1_0.hote_id,h1_0.hote_direccion,h1_0.hote_nombre from hotel h1_0 where h1_0.hote_direccion=?
		Hotel h2 = this.hotelService.buscarPorDireccionC("Luna Azul", "La Colon");
		System.out.println(h2);
		
		System.out.println("Ejemplo 4");
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre from ciudadano c1_0 where c1_0.ciud_cedula=?
		Ciudadano ciu = this.ciudadanoService.buscarPorCedulaC("1718411745");
		System.out.println(ciu);
		
		System.out.println("Ejemplo 5");
		//Hibernate: select l1_0.libr_id,l1_0.libr_fecha_publicacion,l1_0.libr_titulo from libro l1_0 where l1_0.libr_fecha_publicacion=?
		Libro l1 = this.libroService.buscarPorFechaC(LocalDateTime.of(1990, 5, 12, 0, 0));
		System.out.println(l1);
		
	}
	
}