package com.example.demo.rest;

import com.example.demo.model.Factura;
import com.example.demo.service.FacturaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/factura/")
public class FacturaREST {
	Logger logger = LoggerFactory.getLogger(FacturaREST.class);

	@Autowired
	private FacturaService facturaService;
	
	
	@PostMapping
	public ResponseEntity<Factura> saveFactura (@RequestBody Factura factura) {
		try {
			logger.info("factura: {}", factura.toString());
			Factura facturaGuardada = facturaService.save(factura);
			return ResponseEntity.created(new URI("/factura/" + facturaGuardada.getId() )).body(facturaGuardada);
		}catch (Exception e) {
			logger.info("Error :"+e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping ({"nitreceptor/{id}", "nitreceptor/{id}/"})
	public ResponseEntity<List<Factura> > getFacturasByNITReceptor (@PathVariable("id") String NITReceptor){
		try {
			List<Factura> facturaObtenida = facturaService.findByNITReceptor(NITReceptor);
			return ResponseEntity.ok(facturaObtenida);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping ({"razonsocialreceptor/{id}", "razonsocialreceptor/{id}/"})
	public ResponseEntity<List<Factura> > getFacturasByrazonSocialReceptor (@PathVariable("id") String razonSocialReceptor){
		try {
			List<Factura> facturaObtenida = facturaService.findByrazonSocialReceptor(razonSocialReceptor);
			return ResponseEntity.ok(facturaObtenida);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping ({"fechaemision/", "fechaemision"})
	public ResponseEntity<List<Factura> > getFacturasByfechaEmision (@RequestBody Date fechaEmision){
		try {
			List<Factura> facturaObtenida = facturaService.findByFechaEmision(fechaEmision);
			return ResponseEntity.ok(facturaObtenida);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
}
