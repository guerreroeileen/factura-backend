package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descripcionItem;
	private int cantidadItem;
	private double valorUnitarioItem;
	


	
	
	public Item(int id, String descripcionItem, int cantidadItem, double valorUnitarioItem, Factura factura) {
		super();
		this.id = id;
		this.descripcionItem = descripcionItem;
		this.cantidadItem = cantidadItem;
		this.valorUnitarioItem = valorUnitarioItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcionItem() {
		return descripcionItem;
	}

	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}

	public int getCantidadItem() {
		return cantidadItem;
	}

	public void setCantidadItem(int cantidadItem) {
		this.cantidadItem = cantidadItem;
	}

	public double getValorUnitarioItem() {
		return valorUnitarioItem;
	}

	public void setValorUnitarioItem(double valorUnitarioItem) {
		this.valorUnitarioItem = valorUnitarioItem;
	}

	
	
	
	
	
	

}
