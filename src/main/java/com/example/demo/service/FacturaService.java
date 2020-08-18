package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Factura;
import com.example.demo.model.Item;
import com.example.demo.reposiry.FacturaRepository;

@Service
public class FacturaService implements FacturaRepository{
	
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	public List<Factura> findAll(Sort sort) {
		return facturaRepository.findAll(sort);
	}

	@Override
	public List<Factura> findAllById(Iterable<Long> ids) {
		return facturaRepository.findAllById(ids);
	}

	@Override
	public <S extends Factura> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Factura> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Factura> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Factura getOne(Long id) {
		return facturaRepository.getOne(id);
	}

	@Override
	public <S extends Factura> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Factura> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Factura> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Factura> S save(S entity) {
		
		//configurando fecha de emision
		Date today = new Date();
		entity.setFechaEmision(today);
		
		//calculando valor total de los items sin iva
		double valorSinIvaTemp = 0;
		for (int i = 0; i < entity.getItems().size(); i++) {
			Item itemTemporal = entity.getItems().get(i);
			valorSinIvaTemp = valorSinIvaTemp +( itemTemporal.getValorUnitarioItem()*itemTemporal.getCantidadItem() ) ;
		}
		entity.setValorNeto(valorSinIvaTemp);
		
		//calculando IVA
		double valorIVATemp = valorSinIvaTemp*0.16;
		entity.setValorIVA(valorIVATemp);
		//calculando valor total
		double valorTotalTemp = valorSinIvaTemp + valorIVATemp;
		entity.setValorTotal(valorTotalTemp);
		
		
		return facturaRepository.save(entity);
	}

	@Override
	public Optional<Factura> findById(Long id) {
		return facturaRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return facturaRepository.existsById(id);
	}

	@Override
	public long count() {
		return facturaRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Factura entity) {
		facturaRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Factura> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		facturaRepository.deleteAll();
	}

	@Override
	public <S extends Factura> Optional<S> findOne(Example<S> example) {
		return facturaRepository.findOne(example);
	}

	@Override
	public <S extends Factura> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Factura> long count(Example<S> example) {
		return facturaRepository.count(example);
	}

	@Override
	public <S extends Factura> boolean exists(Example<S> example) {
		return facturaRepository.exists(example);
	}

	@Override
	public List<Factura> findByNITReceptor(String NITReceptor) {
		return facturaRepository.findByNITReceptor(NITReceptor);
	}

	@Override
	public List<Factura> findByrazonSocialReceptor(String razonSocialReceptor) {
		return facturaRepository.findByrazonSocialReceptor(razonSocialReceptor);
	}

	@Override
	public List<Factura> findByfechaEmision(Date fechaEmision) {
		return facturaRepository.findByfechaEmision(fechaEmision);
	}

}
