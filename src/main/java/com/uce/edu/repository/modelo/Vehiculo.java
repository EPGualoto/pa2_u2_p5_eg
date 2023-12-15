package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehiculo")
	@SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
	
	@Column(name= "vehi_id")
	private Integer id;
	
	@Column(name= "vehi_marca")
	private String marca;
	
	@Column(name= "vehi_modelo")
	private String modelo;
	
	@Column(name= "vehi_precio")
	private BigDecimal precio;
	
	@Column(name="vehi_placa")
	private String placa;
	
	@Column(name="vehi_anio_fabricacion")
	private LocalDateTime anioFabricacion;
	
	
	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(LocalDateTime anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
}
