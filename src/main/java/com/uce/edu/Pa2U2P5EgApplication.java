package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner{	
	
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Hotel hotel = new Hotel();
		hotel.setDireccion("La Colon");
		hotel.setNombre("Marriot");
		//hote.setHabitaciones(null);
		
		Habitacion habi1 = new Habitacion();
		habi1.setClase("Economica");
		habi1.setNumero("A1");
		habi1.setHotel(hotel);
		
		Habitacion habi2 = new Habitacion();
		habi2.setClase("Presidencial");
		habi2.setNumero("A2");
		habi2.setHotel(hotel);
		
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(habi1);
		habitaciones.add(habi2);
		
		hotel.setHabitaciones(habitaciones);
		this.hotelService.guardar(hotel);		
		
		
	}
}