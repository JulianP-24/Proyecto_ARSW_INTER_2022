package edu.escuelaing.arsw.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.model.Comprador;
import edu.escuelaing.arsw.model.Producto;
import edu.escuelaing.arsw.model.Vendedor;
import edu.escuelaing.arsw.services.CompradorService;
import edu.escuelaing.arsw.services.productoservice;
import edu.escuelaing.arsw.services.VendedorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/SubastaExpress")
public class CompradorController {
    
    @Autowired
    CompradorService compradorService;

    @Autowired
    productoservice productoService;

    @Autowired
    VendedorService vendedorService;

    @GetMapping("/productos")
    public ResponseEntity<?> getProducts() {
        List<Producto> productos = productoService.findALLProducts();
        return new ResponseEntity<>(productos, HttpStatus.ACCEPTED);
    }

    @GetMapping("/productos/listar/{name}")
    public ResponseEntity<?> getProductsbyName(@PathVariable String name) {
        Producto producto = productoService.findByName(name);
        return new ResponseEntity<>(producto, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/productos/buscar/{precio}")
    public ResponseEntity<?> getProductsbyPrize(@PathVariable Double precio) {
        List<Producto> productosPrecio = productoService.findByprize(precio);
        return new ResponseEntity<>(productosPrecio, HttpStatus.ACCEPTED);
    }

    @GetMapping("/comprador/{name}")
    public ResponseEntity<?> getcompradorByName(@PathVariable String name) {
        Comprador comprador = compradorService.findByName(name);
        return new ResponseEntity<>(comprador, HttpStatus.ACCEPTED);
    }

    @GetMapping("/vendedor/{id}")
    public ResponseEntity<?> getVendedorByName(@PathVariable Long id) {
        Vendedor vendedor = vendedorService.findById(id);
        return new ResponseEntity<>(vendedor, HttpStatus.ACCEPTED);
    }

    @GetMapping("/vendedor")
    public ResponseEntity<?> getAllVendedores() {
        List<Vendedor> vendedores = vendedorService.findAll();
        return new ResponseEntity<>(vendedores, HttpStatus.ACCEPTED);
    }

}
