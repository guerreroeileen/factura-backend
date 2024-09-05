package com.example.demo.rest;

import com.example.demo.model.Factura;
import com.example.demo.service.FacturaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import static com.example.demo.constants.RestConstants.FACTURA;
import static com.example.demo.constants.RestConstants.FECHAEMISION;
import static com.example.demo.constants.RestConstants.ID;
import static com.example.demo.constants.RestConstants.NITRECEPTOR;
import static com.example.demo.constants.RestConstants.RAZONSOCIALRECEPTOR;

@RestController
@RequestMapping(FACTURA)
public class FacturaREST {

    Logger logger = LoggerFactory.getLogger(FacturaREST.class);

    @Autowired
    private FacturaService facturaService;


    @PostMapping
    public ResponseEntity<Factura> saveFactura(@RequestBody Factura factura) throws URISyntaxException {
        logger.info("factura: {}", factura.toString());
        Factura facturaGuardada = facturaService.save(factura);
        return ResponseEntity.created(new URI("/factura/" + facturaGuardada.getId())).body(facturaGuardada);
    }

    @GetMapping(NITRECEPTOR + ID)
    public ResponseEntity<List<Factura>> getFacturasByNITReceptor(@PathVariable("id") String NITReceptor) {
        List<Factura> facturaObtenida = facturaService.findByNITReceptor(NITReceptor);
        return ResponseEntity.ok(facturaObtenida);
    }

    @GetMapping(RAZONSOCIALRECEPTOR + ID)
    public ResponseEntity<List<Factura>> getFacturasByrazonSocialReceptor(@PathVariable("id") String razonSocialReceptor) {
        List<Factura> facturaObtenida = facturaService.findByrazonSocialReceptor(razonSocialReceptor);
        return ResponseEntity.ok(facturaObtenida);
    }

    @PostMapping(FECHAEMISION)
    public ResponseEntity<List<Factura>> getFacturasByfechaEmision(@RequestBody Date fechaEmision) {
        List<Factura> facturaObtenida = facturaService.findByFechaEmision(fechaEmision);
        return ResponseEntity.ok(facturaObtenida);
    }

}
