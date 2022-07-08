package edu.escuelaing.arsw.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.model.Producto;
import edu.escuelaing.arsw.model.Vendedor;
import edu.escuelaing.arsw.services.VendedorService;
import edu.escuelaing.arsw.services.productoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/SubastaExpress")
public class VendedorController {
    
    @Autowired
    VendedorService vendedorService;

    @Autowired
    productoservice productoService;

    @GetMapping("/vendedor")
    public ResponseEntity<?> getALLVendedores() {
        return new ResponseEntity<>(vendedorService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/vendedor/{name}")
    public ResponseEntity<?> getVendedorByName(@PathVariable String name) {
        Vendedor vendedor = vendedorService.findByName(name);
        return new ResponseEntity<>(vendedor, HttpStatus.ACCEPTED);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> getProductsVendedorById(@PathVariable Long id) {
        try {
            Producto producto = productoService.productoById(id);
            return new ResponseEntity<>(producto, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos/{id}")
    public ResponseEntity<?> createProduct(@RequestBody Producto producto, @PathVariable Long id) {
        Producto newProduct = null;
        try {
            Vendedor vendedor = vendedorService.findById(id);
            if (vendedor == null) {
                return new ResponseEntity<>("No se encontro el vendedor", HttpStatus.BAD_REQUEST);
            }
            producto.setVendedor(vendedor);
            newProduct = productoService.newProducto(producto);
            return new ResponseEntity<>(newProduct, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Producto producto, @PathVariable Long id) {
        Producto productoActualizado = null;
        try {
            Producto productoActual = productoService.productoById(id);
            if (productoActual == null) {
                return new ResponseEntity<>("No se encontro el producto", HttpStatus.NOT_FOUND);
            }
            productoActual.setProductName(producto.getProductName());
            productoActual.setDescripcion(producto.getDescripcion());
            productoActual.setPrecio(producto.getPrecio());
            productoActual.setFechaCreacion(producto.getFechaCreacion());
            productoActualizado = productoService.newProducto(productoActual);

            return new ResponseEntity<>(productoActualizado, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productoService.deleteProduct(id);
            return new ResponseEntity<>("El producto se ha eliminado correctamente", HttpStatus.ACCEPTED); 
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
