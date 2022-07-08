package edu.escuelaing.arsw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.model.Producto;
import edu.escuelaing.arsw.model.Vendedor;
import edu.escuelaing.arsw.persistence.ProductoPersistence;

@Service
public class productoservice {
    @Autowired
    private ProductoPersistence productoPersistence;

    public List<Producto> findALLProducts() {
        return productoPersistence.findAll();
    }

    public Producto newProducto(Producto producto) {
        return productoPersistence.save(producto);
    }

    public Producto findByName(String productName) {
        return productoPersistence.findByproductName(productName);
    }

    public List<Producto> findByprize(Double precio) {
        return productoPersistence.findByPrecio(precio);
    }

    public List<Producto> findByVendedor(Vendedor vendedor) {
        return productoPersistence.findProductosByVendedor(vendedor);
    }

    public Producto productoById(Long id) {
        return productoPersistence.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productoPersistence.deleteById(id);
    }
}

