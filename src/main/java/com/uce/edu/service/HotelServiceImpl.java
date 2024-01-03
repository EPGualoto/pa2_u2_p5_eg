package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHotelRepository;
import com.uce.edu.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository iHotelRepository;

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.iHotelRepository.insertar(hotel);
	}

}
