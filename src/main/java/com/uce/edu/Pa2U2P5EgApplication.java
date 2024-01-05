package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner{	
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Insertar:
		Ciudadano ciud = new Ciudadano();
		ciud.setNombre("Pepe");
		ciud.setApellido("Lopez");
		this.ciudadanoService.guardar(ciud);
	
		Empleado empl = new Empleado();
		empl.setSalario(new BigDecimal(25));
		empl.setFechaIngreso(LocalDateTime.now());
		ciud.setEmpleado(empl);
		this.empleadoService.guardar(empl);
		
		/*Ciudadano ciud1 = new Ciudadano();
		ciud1.setNombre("Juan");
		ciud1.setApellido("Perez");
		this.ciudadanoService.guardar(ciud);
	
		Empleado empl1 = new Empleado();
		empl1.setSalario(new BigDecimal(10));
		empl1.setFechaIngreso(LocalDateTime.now());
		ciud1.setEmpleado(empl1);
		this.empleadoService.guardar(empl1);
		
		Ciudadano ciud2 = new Ciudadano();
		ciud2.setNombre("Santiago");
		ciud2.setApellido("Castillo");
		this.ciudadanoService.guardar(ciud);
	
		Empleado empl2 = new Empleado();
		empl2.setSalario(new BigDecimal(30));
		empl2.setFechaIngreso(LocalDateTime.now());
		ciud2.setEmpleado(empl2);
		this.empleadoService.guardar(empl2);*/
		
		//Buscar:
		Ciudadano c = this.ciudadanoService.buscar(1);
		System.out.println(c);
		
		//Actualizar:
		Ciudadano c2 = this.ciudadanoService.buscar(4);
		System.out.println(c2);
		c2.setNombre("Karla");
		this.ciudadanoService.actualizar(c2);
		
		//Eliminar:
		this.ciudadanoService.eliminar(5);
		
		/*//Ciudadano
		//Buscar:
		 Empleado e = this.empleadoService.buscar(2);
		 System.out.println(e);
				
		//Actualizar:
		 Empleado e2 = this.empleadoService.buscar(1);
		 System.out.println(e2);
		 e2.setSalario(new BigDecimal(40));
		 this.empleadoService.actualizar(e2);
				
		 //Eliminar:
		 this.empleadoService.eliminar(2);*/
		
	}
}