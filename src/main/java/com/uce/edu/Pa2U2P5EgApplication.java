package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5EgApplication implements CommandLineRunner{	
	
	@Autowired
	private IHabitacionService habitacionService;
	
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Insertar:
		Hotel hotel = new Hotel();
		hotel.setDireccion("La Colon");
		hotel.setNombre("Marriot");
		//this.hotelService.guardar(hotel);

		Habitacion habi1 = new Habitacion();
		habi1.setClase("Economica");
		habi1.setNumero("A1");
		habi1.setHotel(hotel);
		//this.habitacionService.guardar(habi1);

		Habitacion habi2 = new Habitacion();
		habi2.setClase("Presidencial");
		habi2.setNumero("A2");
		habi2.setHotel(hotel);
		//this.habitacionService.guardar(habi2);
		
		
		Hotel hotel1 = new Hotel();
		hotel1.setDireccion("La Y");
		hotel1.setNombre("Julius");
		//hote.setHabitaciones(null);
		//this.hotelService.guardar(hotel1);

		Habitacion habi3 = new Habitacion();
		habi3.setClase("Economica");
		habi3.setNumero("A1.1");
		habi3.setHotel(hotel1);
		//this.habitacionService.guardar(habi3);
		
		//Buscar:
		Hotel h = this.hotelService.buscar(1);
		System.out.println(h);
		
		//Actualizar:
		Hotel h2 = this.hotelService.buscar(1);
		System.out.println(h2);
		h2.setNombre("Hilton Colon");
		this.hotelService.actualizar(h2);
		
		//Eliminar:
		this.hotelService.eliminar(2);
		
		/*/Habitacion
		//Buscar:
		 Habitacion ha = this.habitacionService.buscar(2);
		 System.out.println(ha);
				
		//Actualizar:
		 Habitacion ha1 = this.habitacionService.buscar(1);
		 System.out.println(ha1);
		 ha1.setClase("VIP");
		 this.habitacionService.actualizar(ha1);
				
		 //Eliminar:
		 this.habitacionService.eliminar(2);*/
		
	}
}