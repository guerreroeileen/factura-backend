package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Factura;
import com.example.demo.reposiry.FacturaRepository;

@Service
public class FacturaService {

	public static final double IVA = 0.16;
	
	@Autowired
	private FacturaRepository facturaRepository;

	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	public List<Factura> findAll(Sort sort) {
		return facturaRepository.findAll(sort);
	}

	public List<Factura> findAllById(Iterable<Long> ids) {
		return facturaRepository.findAllById(ids);
	}


	public Factura getOne(Long id) {
		return facturaRepository.getOne(id);
	}

	/**
	 * Calcula los impuestos y precios necesarios antes de guardar la factura en la base de datos.
	 * @param entity factura a guardar.
	 * @return
	 * @param <S>
	 */
	public <S extends Factura> S save(S entity) {
		
		//configurando fecha de emision
		Date today = new Date();
		entity.setFechaEmision(today);
		
		//calculando valor total de los items sin iva
		AtomicReference<Double> valorSinIvaTemp = new AtomicReference<>((double) 0);

		entity.getItems().forEach(item -> {
			valorSinIvaTemp.updateAndGet(v -> (v + (item.getValorUnitarioItem() * item.getCantidadItem())));});

		entity.setValorNeto(valorSinIvaTemp.get());
		
		//calculando IVA
		double valorIVATemp = valorSinIvaTemp.get() * IVA;
		entity.setValorIVA(valorIVATemp);

		//calculando valor total
		double valorTotalTemp = valorSinIvaTemp.get() + valorIVATemp;
		entity.setValorTotal(valorTotalTemp);
		
		
		return facturaRepository.save(entity);
	}

	public long count() {
		return facturaRepository.count();
	}

	public void deleteById(Long id) {
		facturaRepository.deleteById(id);
	}

	public <S extends Factura> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Factura> findByNITReceptor(String NITReceptor) {
		return facturaRepository.findByNitReceptor(NITReceptor);
	}

	/**
	 * Busca una factura por razon social del receptor.
	 * @param razonSocialReceptor razon social del receptor.
	 * @return listado de facturas por la razon social del receptor.
	 */
	public List<Factura> findByrazonSocialReceptor(String razonSocialReceptor) {
		return facturaRepository.findByRazonSocialReceptor(razonSocialReceptor);
	}

	/**
	 * Busca factura por fecha de emision.
	 * @param fechaEmision fecha de emision.
	 * @return retorna una lista de la facturas.
	 */
	public List<Factura> findByFechaEmision(Date fechaEmision) {
		return facturaRepository.findByFechaEmision(fechaEmision);
	}

}
