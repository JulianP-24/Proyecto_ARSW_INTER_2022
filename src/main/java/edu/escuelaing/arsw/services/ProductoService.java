package edu.escuelaing.arsw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.escuelaing.arsw.model.Producto;
import edu.escuelaing.arsw.persistence.ProductoPersistence;

public class ProductoService {
    
    @Autowired
    ProductoPersistence productoPersistence;

    public List<Producto> findALL() {
        return productoPersistence.findAllProducts();
    }

    public Producto newProducto(Producto producto) {
        return productoPersistence.save(producto);
    }

    public Producto findByName(String name) {
        return productoPersistence.findByname(name);
    }

    public List<Producto> findByprize(Double precio) {
        return productoPersistence.findByPrize(precio);
    }
}
