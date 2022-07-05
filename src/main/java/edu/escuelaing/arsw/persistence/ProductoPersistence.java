package edu.escuelaing.arsw.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.escuelaing.arsw.model.Producto;

public interface ProductoPersistence extends JpaRepository<Producto, Long> {
    public Producto findByname(String name);

    public List<Producto> findAllProducts();

    public List<Producto> findByPrize(Double precio);

}
