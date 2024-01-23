package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner {

	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Criteria API Query
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_apellido=?
		Ciudadano ciu = this.ciudadanoService.buscarPorApellido("Guaman");
		System.out.println(ciu);
		
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_nombre=?
		Ciudadano ciu1 = this.ciudadanoService.buscarPorCriteria("Gabriel", "Guaman", "1709998915");
		System.out.println(ciu1);
		
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_apellido=?
		Ciudadano ciu2 = this.ciudadanoService.buscarPorCriteria("Gabriel", "Guaman", "0526894132");
		System.out.println(ciu2);
		
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_cedula=?
		Ciudadano ciu3 = this.ciudadanoService.buscarPorCriteria("Gabriel", "Guaman", "1026894132");
		System.out.println(ciu3);
		
		System.out.println("Criteria API Query AND OR");
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_nombre=? or c1_0.ciud_apellido=?
		Ciudadano ciu4 = this.ciudadanoService.buscarPorCriteriaAndOr("Gabriel", "Guaman", "1709998915");
		System.out.println(ciu4);
		
		//Hibernate: select c1_0.ciud_id,c1_0.ciud_apellido,c1_0.ciud_cedula,c1_0.ciud_nombre 
		//from ciudadano c1_0 where c1_0.ciud_nombre=? and c1_0.ciud_apellido=?
		Ciudadano ciu5 = this.ciudadanoService.buscarPorCriteriaAndOr("Gabriel", "Guaman", "0526894132");
		System.out.println(ciu5);
		
	}
}