package edu.escuelaing.arsw.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.arsw.model.Producto;

public interface ProductoPersistence extends JpaRepository<Producto, Long> {
    public Producto findByproductName(String productName);

    public List<Producto> findByPrecio(Double precio);

}
