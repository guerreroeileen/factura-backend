package com.example.demo.reposiry;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Factura;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{
	
	/**
	 * Repostiorio personalizado para buscar por NIT receptor.
	 * @param nitReceptor NIT del receptor
	 * @return coleccion de List<Factura>
	 */
	List<Factura> findByNitReceptor(String nitReceptor);
	
	
	
	/**Repositorio personalizado para buscar por razon social del receptor.
	 * 
	 * @param razonSocialReceptor razon social del receptor
	 * @return coleccion de List<Factura>
	 */
	List<Factura> findByRazonSocialReceptor(String razonSocialReceptor);
	
	
	/**
	 * Repositorio personalizado para buscar por fecha en la que e generó la factura
	 * @param fechaEmision fecha de emision de la factura
	 * @return coleccion de List<Factura>
	 */
	List<Factura> findByFechaEmision(Date fechaEmision);

}
