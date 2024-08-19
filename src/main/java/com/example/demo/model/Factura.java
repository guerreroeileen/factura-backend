package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "factura")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String razonSocialEmisor;
	@NotBlank
	private String nitEmisor;
	@NotBlank
	private String razonSocialReceptor;
	@NotBlank
	private String nitReceptor;
	private Date fechaEmision;
	private Double valorNeto;
	private Double valorIVA;
	private Double valorTotal;
    
	@OneToMany
	private List <Item> items = new ArrayList<>();
}
