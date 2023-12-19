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
		
		Ciudadano ciud = new Ciudadano();
		ciud.setNombre("Erika");
		ciud.setApellido("Gualoto");
		this.ciudadanoService.insertar(ciud);
		
		Empleado empl = new Empleado();
		empl.setSalario(new BigDecimal(10));
		empl.setFechaIngreso(LocalDateTime.now());
		
		Ciudadano ciud1 = this.ciudadanoService.buscar(1);
		System.out.println(ciud1);
		
		this.empleadoService.insertar(empl);
		
	}
}