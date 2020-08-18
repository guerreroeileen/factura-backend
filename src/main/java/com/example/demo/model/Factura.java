package com.example.demo.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Factura")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String razonSocialEmisor;
	private String NITEmisor;
	private String razonSocialReceptor;
	private String NITReceptor;
	private Date fechaEmision;
	private double valorNeto;
	private double valorIVA;
	private double valorTotal;
    
	@OneToMany
	private List <Item> items;

	
	public Factura(int id, String razonSocialEmisor, String nITEmisor, String razonSocialReceptor, String nITReceptor,
			Date fechaEmision, double valorNeto, double valorIVA, double valorTotal, List<Item> items) {
		super();
		this.id = id;
		this.razonSocialEmisor = razonSocialEmisor;
		NITEmisor = nITEmisor;
		this.razonSocialReceptor = razonSocialReceptor;
		NITReceptor = nITReceptor;
		this.fechaEmision = fechaEmision;
		this.valorNeto = valorNeto;
		this.valorIVA = valorIVA;
		this.valorTotal = valorTotal;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazonSocialEmisor() {
		return razonSocialEmisor;
	}

	public void setRazonSocialEmisor(String razonSocialEmisor) {
		this.razonSocialEmisor = razonSocialEmisor;
	}

	public String getNITEmisor() {
		return NITEmisor;
	}

	public void setNITEmisor(String nITEmisor) {
		NITEmisor = nITEmisor;
	}

	public String getRazonSocialReceptor() {
		return razonSocialReceptor;
	}

	public void setRazonSocialReceptor(String razonSocialReceptor) {
		this.razonSocialReceptor = razonSocialReceptor;
	}

	public String getNITReceptor() {
		return NITReceptor;
	}

	public void setNITReceptor(String nITReceptor) {
		NITReceptor = nITReceptor;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getValorNeto() {
		return valorNeto;
	}

	public void setValorNeto(double valorNeto) {
		this.valorNeto = valorNeto;
	}

	public double getValorIVA() {
		return valorIVA;
	}

	public void setValorIVA(double valorIVA) {
		this.valorIVA = valorIVA;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
	
	


}
