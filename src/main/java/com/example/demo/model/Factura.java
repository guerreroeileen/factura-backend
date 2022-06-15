package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
	private List <Item> items;
}
